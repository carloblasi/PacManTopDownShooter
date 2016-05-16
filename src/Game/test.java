/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Point;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author carloblasi
 */
public class test extends BasicGame {

    Ball ball, ball2;
    int w, h;

    public test(String title) {
        super(title);
    }

    /*public static void main(String args[]) throws SlickException {

        AppGameContainer app = new AppGameContainer(new test(""), 600, 500, false);
        app.start();
    }*/

    @Override
    public void init(GameContainer container) throws SlickException {

       // container.setTargetFrameRate(60);
        //container.setMaximumLogicUpdateInterval(60);
        ball = new Ball(container.getWidth()/2, container.getHeight()/2);
        ball2 = new Ball(container.getWidth()/2, container.getHeight()/2, false, Color.cyan);
        w = container.getWidth();
        h = container.getWidth();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        ball.update(w, h, delta);
        ball2.update(w, h, delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        ball.render(g);
        ball2.render(g);
    }
}

class Ball {

    private Point position;
    private int size = 40;
    private int speed = 1;
    private boolean rigth = true;
    private boolean up = true;
    private Color color = Color.white;

    public Ball(int x, int y) {
        position = new Point(x, y);
    }

    public Ball(int x, int y, boolean up, Color color) {
        position = new Point(x, y);
        this.up = up;
        this.color = color;
    }

    public void update(int screenWidth, int screenHeight, int delta) {

        if (this.rigth == true && this.up == true) {
            this.position.x += speed * delta;
            this.position.y -= speed * delta;
        }
        else if (this.rigth == false && this.up == false) {
            this.position.x -= speed * delta;
            this.position.y += speed * delta;
        }
        else if (this.rigth == false && this.up == true) {
            this.position.x -= speed * delta;
            this.position.y -= speed * delta;
        }
        else if (this.rigth == true && this.up == false) {
            this.position.x += speed * delta;
            this.position.y += speed * delta;
        }

        if (this.position.x >= screenWidth - this.size/2) {
            this.rigth = false;
        }
        if (this.position.x <= this.size/2) {
            this.rigth = true;
        }
        if (this.position.y >= screenHeight - this.size*3) {
            this.up = true;
        }
        if (this.position.y <= this.size/2) {
            this.up = false;
        }
    }

    public void render(Graphics g) {

        g.setColor(this.color);
        g.fillOval(this.position.x - this.size/2, this.position.y-this.size/2, this.size, this.size);
        g.setColor(Color.white);
    }
}