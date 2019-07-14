package Commands;

import GameObjects.Actor;
import main.Globals;

public class stopActor extends Command {

    private Actor act;

    public stopActor(Actor act){
        this.act = act;
    }

    @Override
    public void execute() {
        act.stopMoving();
    }
}
