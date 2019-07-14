package GameObjects;

import input.SpriteSheet;
import main.GameObject;

import java.awt.*;

public class Pacman extends GameObject {

    private int dx;
    private int dy;


    public Pacman() {
        super( 210,266,26,26);
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        g.drawImage(ss.grabImage(456,1,14,14), (int)x, (int)y, w, h,null);
    }

    public void tick() {

    }
}
