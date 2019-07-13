package input;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private int x,y;
    private boolean clicked = false;

    @Override
    public void mousePressed(MouseEvent e) {
        clicked = true;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }
    @Override
    public void mouseDragged(MouseEvent e){
        x = e.getX();
        y = e.getY();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public Point getMousePos() {
        return new Point(x,y);
    }

    public boolean isClicked() {
        return clicked;
    }

}
