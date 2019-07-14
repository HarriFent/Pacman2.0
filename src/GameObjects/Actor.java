package GameObjects;

import main.GameObject;
import main.Globals;

public abstract class Actor extends GameObject {

    public Actor(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public abstract void setDirection(Globals.DIR dir);
    public abstract void stopMoving();
}
