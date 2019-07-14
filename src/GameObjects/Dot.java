package GameObjects;

import input.SpriteSheet;
import main.GameObject;
import main.Globals;

import java.awt.*;

public class Dot extends GameObject {

    private boolean power;

    public Dot(int x, int y, boolean power) {
        super(x,y,16,16);
        this.power = power;
        id =  Globals.ID.DOT;
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        if (power) {
            g.drawImage(ss.grabImage(8, 24, 8, 8), x, y, w, h, null);
        }else {
            g.drawImage(ss.grabImage(8, 8, 8, 8), x, y, w, h, null);
        }
    }
}
