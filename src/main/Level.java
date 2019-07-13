package main;

import input.SpriteSheet;
import jdk.nashorn.internal.objects.Global;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Level {

    public LinkedList<GameObject> objects = new LinkedList<>();
    public SpriteSheet ss;
    public BufferedImage background;

    public Level(SpriteSheet ss) {
        this.ss = ss;
        this.background = ss.grabImage(228,0,224,248);
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

    public void clearObjects() {
        objects = new LinkedList<GameObject>();
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(background,0,0, Globals.WIDTH, Globals.HEIGHT, null);

        g.setColor(Color.green);
        for (int i = 0; i < Globals.WIDTH / 16; i++) g.drawLine(i*16, 0, i*16, Globals.HEIGHT);
        for (int i = 0; i < Globals.HEIGHT / 16; i++) g.drawLine(0, i*16, Globals.WIDTH, i*16);

    }
}
