package Game;

import static Game.GameFont.optionBlue;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.LinkedList;
import org.newdawn.slick.Sound;

public class Game extends BasicGame {

    public static GameContainer container;
    static Input input;
    public static int mouseX, mouseY;
    static final int MENUSTATE = 0, GAMEPLAYSTATE = 1, MULTIPLAYERMENUSTATE = 2, MULTIPLAYERGAMEPLAYSTATE = 3,
                    MULTIPLAYERGAMEOVERSTATE = 4, LEADERBOARDSTATE = 5, PAUSESTATE = 6, GAMEOVERSTATE = 7;
    static int state = MENUSTATE;
    static boolean canCreateConnection = true;
    static boolean paused = false;

    public static Button leaderboardButton;
    public static Button quitButton;
    public static Button playButton;
    public static Button multiplayerButton;
    public static Button menuButton;
    public static Button resumeButton;
    public static Button retryButton;
    public static Button serverButton;
    public static Button showMultiplayerScoresButton;

    static GameFont bigFont;
    static GameFont playFont;
    static GameFont replayFont;
    static GameFont leaderboardFont;
    static GameFont escFont;
    static GameFont multiplayerFont;
    static GameFont smallFont;
    static Image titleImage;
    static Image youLostImage;
    static Image[] ghosts = new Image[4];
    static ScoreManager Score;

    static LinkedList<Bullet> bulletList = new LinkedList<>();
    static ArrayList<Enemy> enemyList = new ArrayList<>();
    static Ammo[] ammos = new Ammo[10];
    static Player player;

    static int bulletCount = 0, enemyCount = 0, ammosCount = 0;
    static final int START_DELAY = 500, AMMOS_DELAY = 10000, NEW_DIFFICULTY_DELAY = 15000, BULLET_DELAY = 200;
    static int ENEMY_DELAY = 500;
    static int startDelay = START_DELAY;
    static int canSpawnEnemy = ENEMY_DELAY;
    static int canSpawnAmmo = AMMOS_DELAY;
    static int increaseDifficulty = NEW_DIFFICULTY_DELAY;
    static int canFire = 0;
    static Random enemyPositionX = new Random();
    static Random enemyPositionY = new Random();

    static GameFont IPFont;
    static GameFont DestinationPortFont;
    static GameFont SourcePortFont;
    static TextField IPTextField, DestinationPortTextField, SourcePortTextField;
    static String IP;
    static int SourcePort, DestinationPort;

    static boolean opponentFired = false;
    static Opponent opponent;
    static ArrayList<Bullet> opponentBulletList = new ArrayList<>();
    static int oppBulletCount = 0;
    static Point opponentCoordinates = new Point(Window.HALF_WIDTH, Window.HALF_HEIGHT);
    static Point opponentMouseCoordinates = new Point();
    static int opponentScreenHeight = 0, opponentScreenWidth = 0;
    public static Sound openingSound;
    public static Sound shootSound;

    static Connection connection;
    static InetSocketAddress address;
    static String infoString = "";
    static String winnerString = "";
    public static int players = 0;
    public static int multiplayerGameID = 0;

    static UDPServerThread server;
    static boolean isServer = false;
    static UDPSenderThread sender;
    static UDPReceiverThread receiver;
    public static String localIP = null;

    public static void main(String[] args) throws SlickException {

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();

                if (iface.isLoopback() || !iface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    localIP = address.getHostAddress();
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        AppGameContainer app = new AppGameContainer(new Game("Pac Man: The Top Down Shooter"));
        app.setDisplayMode(Window.WIDTH, Window.HEIGHT, true);
        app.start();
    }

    public Game(String title) {
        super(title);
    }

    /**
     * Inizializza tutte le variabili del gioco.
     * @param gc {@code GameContainer} del gioco
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc) throws SlickException {

        gc.setMaximumLogicUpdateInterval(60);
        gc.setTargetFrameRate(60);
        gc.setVSync(true);
        gc.setAlwaysRender(true);
        gc.setShowFPS(false);
        gc.setClearEachFrame(true);
        gc.setSmoothDeltas(false);
        gc.setVerbose(true);
        gc.setMouseCursor("Images/Aim.png", 16, 16);

        playFont = new GameFont(64);
        replayFont = new GameFont(64f);
        leaderboardFont = new GameFont(44f);
        escFont = new GameFont(44f);
        multiplayerFont = new GameFont(44f);
        smallFont = new GameFont(24f);
        IPFont = new GameFont(54f);
        DestinationPortFont = new GameFont(44f);
        SourcePortFont = new GameFont(44f);

        Score = new ScoreManager();
        Score.resetScore();

        IPTextField = new TextField(gc, IPFont.getFont(), Window.HALF_WIDTH - 180, Window.HALF_HEIGHT - 200, IPFont.getStringWidth("555555555555555"), 54);
        IPTextField.setBorderColor(Color.transparent);
        IPTextField.setMaxLength(15);
        IPTextField.setCursorVisible(false);

        SourcePortTextField = new TextField(gc, DestinationPortFont.getFont(), Window.HALF_WIDTH, Window.HALF_HEIGHT - 120, DestinationPortFont.getStringWidth("55555"), 44);
        SourcePortTextField.setBorderColor(Color.transparent);
        SourcePortTextField.setMaxLength(5);
        SourcePortTextField.setCursorVisible(false);

        DestinationPortTextField = new TextField(gc, SourcePortFont.getFont(), Window.HALF_WIDTH - 40, Window.HALF_HEIGHT - 48, SourcePortFont.getStringWidth("55555"), 44);
        DestinationPortTextField.setBorderColor(Color.transparent);
        DestinationPortTextField.setMaxLength(5);
        DestinationPortTextField.setCursorVisible(false);

        playButton = new Button("PLAY (ENTER)", Window.HALF_WIDTH, Window.HALF_HEIGHT, 64, optionBlue);
        multiplayerButton = new Button("MULTIPLAYER (M)", Window.HALF_WIDTH, Window.HALF_HEIGHT + 64, 44, optionBlue);
        leaderboardButton = new Button("LEADERBOARD (L)", Window.HALF_WIDTH, Window.HALF_HEIGHT + 128, 44, optionBlue);
        quitButton = new Button("QUIT (ESC)", Window.HALF_WIDTH, Window.HEIGHT - Window.HEIGHT/20, 44, Color.red);
        menuButton = new Button("MENU (ESC)", Window.HALF_WIDTH, Window.HEIGHT - Window.HEIGHT/20, 44, Color.red);
        resumeButton = new Button("RESUME (R)", Window.HALF_WIDTH, Window.HALF_HEIGHT, 64, optionBlue);
        retryButton = new Button("RETRY (R)", Window.HALF_WIDTH, Window.HALF_HEIGHT, 64, optionBlue);
        serverButton = new Button("SERVER", Window.HALF_WIDTH, Window.HALF_HEIGHT + 40, 32, Color.red);
        showMultiplayerScoresButton = new Button("SHOW MULTIPLAYER HIGHSCORES", Window.HALF_WIDTH, quitButton.getY() -  Window.HEIGHT/16, 24, Color.white);

        player = new Player();
        opponent = new Opponent();

        for (int i = 0; i < 10; i++)
            ammos[i] = new Ammo();

        try {
            titleImage = new Image("Images/Title.png");
            youLostImage = new Image("Images/GameLost.png");
            ghosts[0] = new Image("Images/Clyde.png");
            ghosts[1] = new Image("Images/Blinky.png");
            ghosts[2] = new Image("Images/Inky.png");
            ghosts[3] = new Image("Images/Pinky.png");
            openingSound = new Sound("Sounds/openingSound.wav");
            shootSound = new Sound("Sounds/pacmanShoot.wav");

            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("pmmtds.scores"));
            Score = (ScoreManager) inStream.readObject();

        } catch (IOException e) {
            System.out.println("SCORES FILE NOT FOUND");
        } catch (ClassNotFoundException e) {
            System.out.println("SCORES FILE EMPTY");
        } catch (SlickException e) {
            System.out.println("ONE OR MORE IMAGES NOT FOUND");
        }
        Score.resetScore();

    }

    /**
     * Metodo generico per aggiornare la logica degli oggetti di tutto il gioco
     * @param gc {@code GameContainer} del gioco
     * @param delta {@code delta} del gioco
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {

        input = gc.getInput();
        mouseX = input.getMouseX();
        mouseY = input.getMouseY();

        switch (state) {

            case MENUSTATE:

                MenuState.update(gc, input, delta, mouseX, mouseY);
                break;

            case GAMEPLAYSTATE:

                GamePlayState.update(gc, input, delta, mouseX, mouseY);
                break;

            case MULTIPLAYERMENUSTATE:

                MultiplayerMenuState.update(gc, input, delta, mouseX, mouseY);
                break;

            case MULTIPLAYERGAMEPLAYSTATE:

                createConnection();
                MultiplayerGamePlayState.update(gc, input, delta, mouseX, mouseY);
                break;

            case MULTIPLAYERGAMEOVERSTATE:

                MultiplayerGameOverState.update(gc, input, delta, mouseX, mouseY);
                break;

            case LEADERBOARDSTATE:

                LeaderBoardState.update(gc, input, delta, mouseX, mouseY);
                break;

            case PAUSESTATE:

                PauseState.update(gc, input, delta, mouseX, mouseY);
                break;

            case GAMEOVERSTATE:

                GameOverState.update(gc, input, delta, mouseX, mouseY);
                break;
        }
    }

    /**
     * Metodo generico per aggiornare la logica degli oggetti di tutto il gioco
     * @param gc {@code GameContainer} del gioco
     * @param g L'oggetto che si occupa di disergnare su schermo
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

        switch (state) {

            case MENUSTATE:

                MenuState.render(gc, g);
                break;

            case GAMEPLAYSTATE:

                GamePlayState.render(gc, g);
                break;

            case MULTIPLAYERMENUSTATE:

                MultiplayerMenuState.render(gc, g);
                break;

            case MULTIPLAYERGAMEPLAYSTATE:

                MultiplayerGamePlayState.render(gc, g);
                break;

            case MULTIPLAYERGAMEOVERSTATE:

                MultiplayerGameOverState.render(gc, g);
                break;

            case LEADERBOARDSTATE:

                LeaderBoardState.render(gc, g);
                break;

            case PAUSESTATE:

                PauseState.render(gc, g);
                break;

            case GAMEOVERSTATE:

                GameOverState.render(gc, g);
                break;
        }
    }

    /**
     * Apre la connessione tra i due giocatori e apre il server che serve ad inviare le posizioni dei nemici.
     */
    private void createConnection() {

        if (canCreateConnection) {

            address = new InetSocketAddress(IP, DestinationPort);
            try {
                connection = new Connection();
                connection.connect(SourcePort, address);
                connection.start();

            } catch (SocketException e) {
                System.out.println("ERROR: IP, SOURCE PORT or DESTINATION PORT NOT VALID " + e);
            }

            int serverPort = 7777;
            if (isServer) {

                server = new UDPServerThread(serverPort, 2);
                server.isRunning(true);
                server.start();
            }
            try {

                InetAddress serverAddress;
                if (isServer)
                    serverAddress = InetAddress.getByName("localhost");
                else
                    serverAddress = InetAddress.getByName(IP);

                sender = new UDPSenderThread(serverAddress, serverPort);
                sender.start();
                receiver = new UDPReceiverThread(sender.getSocket());
                receiver.start();

            } catch (SocketException e) {
                System.out.println("Socket Exception");
            } catch (UnknownHostException e) {
                System.out.println("Unknown Host");
            }
            canCreateConnection = false;
        }
    }
}
