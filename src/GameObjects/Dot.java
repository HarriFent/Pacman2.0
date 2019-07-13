package GameObjects;

import input.SpriteSheet;
import main.GameObject;

import java.awt.*;

public class Dot extends GameObject {

    private boolean power;

    public Dot(int x, int y, boolean power) {
        super(x,y,8,8);
        this.power = power;
        this.collide = false;
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        if (power) {
            g.drawImage(ss.grabImage(8, 24, 8, 8), (int) x, (int) y, w, h, null);
        }else {
            g.drawImage(ss.grabImage(8, 8, 8, 8), (int) x, (int) y, w, h, null);
        }
    }
}
