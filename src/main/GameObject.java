package main;

import input.SpriteSheet;

import java.awt.*;

public class GameObject {

    protected double x, y;
    protected int w, h, index;
    protected double vel, accel, angle;
    protected boolean collide = true;
    protected int stateTick = 0;
    protected float alpha;

    public void GameObject() {

    }

    public void render(Graphics g, SpriteSheet ss) {

    }

    public void tick() {

    }
}
