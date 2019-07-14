package main;

import input.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected double x, y;
    protected int w, h;

    public GameObject(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void render(Graphics g, SpriteSheet ss);
}
