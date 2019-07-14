package input;

import main.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private boolean UP;
    private boolean DOWN;
    private boolean LEFT;
    private boolean RIGHT;

    public enum KEY{
        KEY_UP,
        KEY_DOWN,
        KEY_LEFT,
        KEY_RIGHT
    }

    private void clearKeys() {
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
    }


    private Game game;

    public KeyInput(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                clearKeys();
                UP = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                clearKeys();
                DOWN = true;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                clearKeys();
                LEFT = true;
                break;
            case KeyEvent.VK_R:
            case KeyEvent.VK_RIGHT:
                clearKeys();
                RIGHT = true;
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

    public void tick() {

    }

}
