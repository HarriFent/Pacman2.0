package GameObjects;

import input.SpriteSheet;
import main.GameObject;
import main.Globals;

import java.awt.*;

public class Pacman extends Actor {

    private int dx;
    private int dy;


    public Pacman() {
        super( 210,266,26,26);
        id = Globals.ID.PACMAN;
    }

    @Override
    public void render(Graphics g, SpriteSheet ss) {
        g.drawImage(ss.grabImage(456,1,14,14), (int)x, (int)y, w, h,null);
    }

    @Override
    public void tick() {
        x += dx;
        y += dy;
    }

    @Override
    public void setDirection(Globals.DIR dir) {
        dx = 0; dy = 0;
        switch (dir) {
            case UP:
                dy = -1;
                break;
            case DOWN:
                dy = 1;
                break;
            case LEFT:
                dx = -1;
                break;
            case RIGHT:
                dx = 1;
        }
    }

    @Override
    public void stopMoving() {
        dx = 0; dy = 0;
    }
}
