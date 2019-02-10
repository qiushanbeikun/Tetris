import elements.Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {

    private static final int AUTO_BOT_SPEED = 10;
    private JFrame frame;
    private final int LENGTH = 30;

    private BufferedImage image = new BufferedImage(LENGTH*22, LENGTH*22, BufferedImage.TYPE_INT_RGB);
    private Graphics g = image.createGraphics();




    public static void main(String[] args) {
        new Main();
    }

    //initialize the visual interface, including all the components.
    // initial the game when pressing start
    public Main(){
        /*frame = new JFrame("Grand Tetris Auto");
        frame.setSize(600,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        /////
        frame.setVisible(true);*/
        gameRunner();
    }

    //initialize the game, create a canvas, add all
    public void gameRunner(){
        elements.Canvas battleFiled = new Canvas();

    }

}
