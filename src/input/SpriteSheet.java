package input;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sprite;

    public SpriteSheet (BufferedImage ss) { this.sprite = ss; }

    public BufferedImage grabImage(int x, int y, int w, int h) {
        BufferedImage img = sprite.getSubimage(x,y,w,h);
        return img;
    }

}
