package main;

import input.KeyInput;
import input.MouseInput;
import input.SpriteSheet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable{

    public MouseInput mouseInput;
    private BufferedImage imgSpriteSheet;
    private KeyInput keyInput = new KeyInput(this);
    public SpriteSheet spriteSheet;
    private Thread thread;
    private boolean running;
    private double MS_PER_UPDATE = 16;
    private Level level;

    public Game() {
        this.mouseInput = new MouseInput();
        this.addMouseListener(this.mouseInput);
        this.addMouseMotionListener(this.mouseInput);
        this.addKeyListener(this.keyInput);
        try {
            imgSpriteSheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        spriteSheet = new SpriteSheet(imgSpriteSheet);
        level = new Level(spriteSheet);

        new Window(Globals.WIDTH + 6, Globals.HEIGHT + 29, "Pacman", this);
    }

    @Override
    public void run() {
        double previous = System.nanoTime();
        double lag = 0.0;
        while (running)
        {
            double current = System.nanoTime();
            double elapsed = current - previous;
            previous = current;
            lag += elapsed;

            //Input Handler

            while (lag >= MS_PER_UPDATE)
            {
                tick();
                lag -= MS_PER_UPDATE;
            }

            render();
        }
    }

    public synchronized void start() {
        this.thread = new Thread(this);
        this.thread.start();
        this.running = true;
    }

    public synchronized void stop() {
        try {
            this.thread.join();
            this.running = false;
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void tick() {
        this.level.tick();
        this.keyInput.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Globals.WIDTH, Globals.HEIGHT);

        //render
        level.render(g, spriteSheet);

        g.dispose();
        bs.show();
    }
}
