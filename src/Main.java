import Exceptions.gameOverException;
import elements.Block;
import elements.Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Main {

    // beta
    // the visual speed that the auto bot will run
    // will be subjected to user's change
    // depending on developer-orientated or user orientated
    private int AUTO_BOT_SPEED = 10;
    private JFrame frame;
    private final int LENGTH = 30;

    private BufferedImage image = new BufferedImage(LENGTH*22, LENGTH*22, BufferedImage.TYPE_INT_RGB);
    private Graphics g = image.createGraphics();

    private boolean gameIsOn = false;
    private Canvas battleField;
    private Block block;




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
        gameIsOn = true;
        battleField = new Canvas();

        while(gameIsOn){
            battleField.printStatus();
            Random ran = new Random();
            int x = ran.nextInt(4);
            try {
                block = new Block(battleField, x);
            } catch (gameOverException e) {
                gameIsOn = false;
                gameOverProcess();
            }

            block.mergeBlock(block, battleField.sediments);
            battleField.allocateSedimnts(battleField,battleField.sediments);

        }
    }

    public void gameOverProcess(){

    }




}
