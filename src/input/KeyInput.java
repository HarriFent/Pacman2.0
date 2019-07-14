package input;

import Commands.Command;
import Commands.setActorDirection;
import GameObjects.Actor;
import main.GameObject;
import main.Globals;
import main.Level;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private boolean keys[] = new boolean[4];
    private Level level;

    private void clearKeys() {
        for (boolean pressed : keys) pressed = false;
    }

    public KeyInput(Level level) {
        this.level = level;
    }

    public Command handleInput() {
        GameObject pacman = level.getObjectById(Globals.ID.PACMAN);
        for (int i = 0; i < 4; i++) {
            if (keys[i]){
                return new setActorDirection((Actor)pacman, Globals.DIR.fromInt(i));
            }
        }
        return null;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                clearKeys();
                keys[Globals.DIR.toInt(Globals.DIR.UP)] = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                clearKeys();
                keys[Globals.DIR.toInt(Globals.DIR.DOWN)] = true;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                clearKeys();
                keys[Globals.DIR.toInt(Globals.DIR.LEFT)] = true;
                break;
            case KeyEvent.VK_R:
            case KeyEvent.VK_RIGHT:
                clearKeys();
                keys[Globals.DIR.toInt(Globals.DIR.RIGHT)] = true;
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        /*int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                UP = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                DOWN = false;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                LEFT = false;
                break;
            case KeyEvent.VK_R:
            case KeyEvent.VK_RIGHT:
                RIGHT = false;
                break;
            default:
                break;
        }*/
    }

}
