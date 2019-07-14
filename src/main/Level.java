package main;

import GameObjects.Actor;
import GameObjects.Dot;
import GameObjects.Pacman;
import input.SpriteSheet;
import jdk.nashorn.internal.objects.Global;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Level {

    public LinkedList<GameObject> objects = new LinkedList<>();
    public BufferedImage background;
    public int[][] collisionArray;

    public Level(SpriteSheet ss) {
        this.background = ss.grabImage(228,0,224,248);
        LoadLevelFromFile();
        addObject(new Pacman());
    }

    public void LoadLevelFromFile() {
        Scanner input = null;
        try {
            input = new Scanner(new BufferedReader(new FileReader("res/level.txt")));
            int n = 28;
            int m = 31;
            collisionArray = new int[m][n];
            while(input.hasNextLine()) {
                for (int i=0; i<collisionArray.length; i++) {
                    String[] line = input.nextLine().trim().split(",");
                    for (int j=0; j<line.length; j++) {
                        int val = Integer.parseInt(line[j]);
                        switch (val) {
                            case 2:
                                //DOT
                                addObject(new Dot(j*16,i*16,false));
                                break;
                            case 3:
                                //POWER
                                addObject(new Dot(j*16,i*16,true));
                                break;
                            default:
                                collisionArray[i][j] = val;
                                break;

                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public GameObject getObjectById(Globals.ID id) {
        for (GameObject object : objects) {
            if (object.id == id)
                return object;
        }
        return null;
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

    public void render(Graphics g, SpriteSheet ss) {
        g.drawImage(background,0,0, Globals.WIDTH, Globals.HEIGHT, null);

        for (GameObject go: objects) {
            go.render(g, ss);
        }


        //Displays Grid over map.
        /*g.setColor(Color.green);
        for (int i = 0; i < Globals.WIDTH / 16; i++) g.drawLine(i*16, 0, i*16, Globals.HEIGHT);
        for (int i = 0; i < Globals.HEIGHT / 16; i++) g.drawLine(0, i*16, Globals.WIDTH, i*16);*/
    }

    public void tick() {
        for (GameObject object : objects) {
            switch (object.id) {
                case PACMAN:
                    Actor act = (Actor)object;
                    act.tick();
                    break;
            }
        }
    }
}
