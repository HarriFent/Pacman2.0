package main;

public class Globals {

    public static int WIDTH = 448;          // 224 * 2
    public static int HEIGHT = 496;         // 248 * 2

    public enum ID {
        PACMAN,
        GHOST,
        DOT,
        FRUIT
    }

    public enum DIR {
        UP,
        DOWN,
        LEFT,
        RIGHT;

        public static int toInt(DIR dir) {
            switch (dir) {
                case UP:
                    return 0;
                case DOWN:
                    return 1;
                case LEFT:
                    return 2;
                case RIGHT:
                    return 3;
            }
            return -1;
        }

        public static DIR fromInt(int i) {
            switch (i){
                case 0 :
                    return UP;
                case 1 :
                    return DOWN;
                case 2 :
                    return LEFT;
                case 3 :
                    return RIGHT;
            }
            return UP;
        }
    }

}
