package main;

import input.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected int x, y;
    protected int w, h;

    public GameObject(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int x() {return x;}
    public int y() {return y;}

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void render(Graphics g, SpriteSheet ss);
}
