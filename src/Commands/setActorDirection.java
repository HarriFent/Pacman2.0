package Commands;

import GameObjects.Actor;
import main.Globals;

public class setActorDirection extends Command {

    private Actor act;
    private Globals.DIR dir;

    public setActorDirection(Actor act, Globals.DIR dir) {
        this.act = act;
        this.dir = dir;
    }

    @Override
    public void execute() {
        act.setDirection(dir);
    }
}
