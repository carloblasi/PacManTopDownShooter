package Game;

import static Game.Game.START_DELAY;
import static Game.Game.BULLET_DELAY;
import static Game.Game.ENEMY_DELAY;
import static Game.Game.Score;
import static Game.Game.startDelay;
import static Game.Game.bulletList;
import static Game.Game.canFire;
import static Game.Game.connection;
import static Game.Game.opponent;
import static Game.Game.opponentBulletList;
import static Game.Game.opponentCoordinates;
import static Game.Game.opponentFired;
import static Game.Game.opponentMouseCoordinates;
import static Game.Game.canCreateConnection;
import static Game.Game.canSpawnAmmo;
import static Game.Game.enemyList;
import static Game.Game.smallFont;
import static Game.Game.infoString;
import static Game.Game.player;
import static Game.Game.receiver;
import static Game.Game.sender;
import static Game.Game.server;
import static Game.MultiplayerMenuState.isServer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.newdawn.slick.Color;

public class MultiplayerGamePlayState {

    public static int canSpawnEnemy = ENEMY_DELAY;
    static boolean justStarted = true;

    /**
     * Metodo generico per aggiornare la logica degli oggetti della scena
     * @param gc {@code GameContainer} del gioco
     * @param input L'input del gioco
     * @param delta {@code delta} del gioco
     * @param mouseX Coordinata X del mouse
     * @param mouseY Coordinata Y del mouse
     * @throws SlickException
     */
    public static void update(GameContainer gc, Input input, int delta, int mouseX, int mouseY) throws SlickException {

        startDelay -= delta;
        if (startDelay < 0) {

            canSpawnAmmo -= delta;
            // QUIT GAME
            if (input.isKeyPressed(Input.KEY_ESCAPE)) {
                quitGame();
            }

            checkIfPlayersDied();
            canFire -= delta;

            if (opponentFired) {
                addOpponentBullet();
                opponentFired = false;
            }

            synchronized(enemyList) {

                enemyList.stream().forEach((enemy) -> {

                    if (enemy.getPlayerToFollow() == 0) {

                        if (Game.isServer)
                            enemy.update(player.getCoordinates(), delta);
                        else
                            enemy.update(opponent.getCoordinates(), delta);
                    }
                    else {
                        if (Game.isServer)
                            enemy.update(opponent.getCoordinates(), delta);
                        else
                            enemy.update(player.getCoordinates(), delta);
                    }
                });
            }

            bulletList.stream().forEach((bullet) -> {
                bullet.update(delta);
            });

            synchronized(opponentBulletList) {

                opponentBulletList.stream().forEach((bullet) -> {
                    bullet.update(delta);
                });
            }

            player.update(input, delta);
            opponent.update(opponentCoordinates, opponentMouseCoordinates.x, opponentMouseCoordinates.y);

            // SHOOT
            if (player.isAlive()) {
                if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && canFire <= 0) {

                    addBullet(mouseX, mouseY);
                    canFire = BULLET_DELAY;
                }
            }

            if (justStarted) {

                Score.resetScore();
                justStarted = false;
            }

            /// SENDING AND RECEIVING COORDINATES
            infoString = "" + player.getX() + ":" + player.getY() + ":" + mouseX + ":" + mouseY + ":" + player.getHealth() + ":" + Score.getScore();
            try {
                connection.send(infoString);
            } catch (IOException e) {
                System.out.println("Error while sending coordinates to opponent " + e);
            }

            getOpponentCoordinates();
        }
    }

    public static void render(GameContainer gc, Graphics g) throws SlickException {

        player.render(g);
        player.detectCollisionWithEnemies(enemyList);

        opponent.render(g);
        opponent.detectCollisionWithEnemies(enemyList);

        Iterator<Bullet> iter = bulletList.iterator();
        while (iter.hasNext()) {

            Bullet bullet = iter.next();
            bullet.render();
            if (bullet.isOutOfBounds(gc))
                iter.remove();
        }
        synchronized(opponentBulletList) {

            Iterator<Bullet> oppIter = opponentBulletList.iterator();
            try {
                synchronized (oppIter) {
                    while (oppIter.hasNext()) {

                        Bullet bullet = oppIter.next();
                        synchronized (bullet) {
                            bullet.render();
                            if (bullet.isOutOfBounds(gc)) {
                                oppIter.remove();
                            }
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Error rendering bullets");
            }
        }
        synchronized(enemyList) {

            Iterator<Enemy> enemyIter = enemyList.iterator();
            try {
                while (enemyIter.hasNext()) {

                    Enemy enemy = enemyIter.next();
                    enemy.render();
                    if (enemy.isCollidingWithBullets(bulletList)) {
                        enemyIter.remove();
                    } else if (enemy.isCollidingWithBullets(opponentBulletList)) {
                        enemyIter.remove();
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("Error rendering enemies");
            }
        }

        smallFont.drawString("Score: " + Score.getScore(), 12, 12, Color.white);
    }

    public static void addBullet(int x, int y) {

        try {
            connection.send("1");
        } catch (IOException e) {
            System.out.println("Error while sending new bullet");
        }
        bulletList.add(new Bullet(player.getX(), player.getY(), x, y));
    }

    public static void addOpponentBullet() {

        synchronized(opponentBulletList) {
            opponentBulletList.add(new Bullet(opponentCoordinates.x, opponentCoordinates.y, opponentMouseCoordinates.x, opponentMouseCoordinates.y));
        }
    }

    public static void addEnemy(int x, int y, int imageIndex, int playerToFollow) {

        enemyList.add(new Enemy(x, y, imageIndex, playerToFollow));
    }

    public static void getOpponentCoordinates() {

        String[] s = connection.getOpponentPosition().split(":");
        if (s.length == 6) {

            //if (Integer.parseInt(s[6]) != Game.multiplayerGameID) {

                opponent.setHealth(Integer.parseInt(s[4]));
                opponentCoordinates.x = Integer.parseInt(s[0]);
                opponentCoordinates.y = Integer.parseInt(s[1]);
                opponentMouseCoordinates.x = Integer.parseInt(s[2]);
                opponentMouseCoordinates.y = Integer.parseInt(s[3]);
                if (Score.getScore() < Integer.parseInt(s[5]))
                    Score.setScore(Integer.parseInt(s[5]));
            //}
        }
    }

    public static void checkIfPlayersDied() {

        if (!player.isAlive() || !opponent.isAlive()) {
            resetGame();
        }
    }

    public static void resetGame() {

        Game.startDelay = START_DELAY;
        Game.winnerString = "SCORE: " + Score.getScore();
        if (Score.checkNewMultiplayerHighScore())
            Score.saveScores();
        player.reset();
        opponent.reset();
        bulletList.clear();
        opponentBulletList.clear();
        enemyList.clear();
        Score.resetScore();
        Score.setScore(0);
        try {
            for (int i = 0; i < 24; i++) {
                connection.send("3");
            }
        } catch (IOException e) {
            System.out.println("Error while sending end game");
        }
        connection.stop();
        if (Game.isServer)
            server.close();
        sender.interrupt();
        receiver.interrupt();
        canCreateConnection = true;
        justStarted = true;
        Game.state = Game.MULTIPLAYERGAMEOVERSTATE;
    }

    public static void quitGame() {

        try {
            Game.startDelay = START_DELAY;
            player.reset();
            opponent.reset();
            bulletList.clear();
            opponentBulletList.clear();
            enemyList.clear();
            Score.resetScore();
            Score.setScore(0);
            canCreateConnection = true;
            try {
                for (int i = 0; i < 24; i++)
                    connection.send("2");
            } catch (IOException e) {
                System.out.println("ERROR WHILE SENDING END GAME");
            }
            connection.stop();
            if (Game.isServer)
                server.close();
            sender.interrupt();
            receiver.interrupt();
        } catch (NullPointerException e) {
            Game.state = Game.MENUSTATE;
        }
        isServer = false;
        Game.isServer = false;
        justStarted = true;
        Game.state = Game.MENUSTATE;
    }
}
