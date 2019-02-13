package elements;

import Exceptions.gameOverException;
import Exceptions.illegalOperationException;

import java.util.ArrayList;
import java.util.Arrays;

public class Block {

    private int numberOfY;
    private int numberOfX;
    private int type;
    private int status ;

/*    private Unit s11 = new Unit(5,1);
    private Unit s12 = new Unit(6,1);
    private Unit s13 = new Unit(6,2);
    private Unit s14 = new Unit(7,3);
    private Unit s15 = new Unit(5,2);
    private Unit s16 = new Unit(5,3);
    private Unit s17 = new Unit(6,3);
    private Unit s18 = new Unit(7,1);*/



    private ArrayList<Integer> sBlockS1 = new ArrayList<>(Arrays.asList(5, 1, 6, 1, 6, 2, 7, 3));
    private ArrayList<Integer> sBlockS2 = new ArrayList<>(Arrays.asList(6, 1, 5, 2, 6, 2, 5, 3));
    private ArrayList<Integer> sBlockS3 = new ArrayList<>(Arrays.asList(5,1,5,2,6,2,6,3));
    private ArrayList<Integer> sBlockS4 = new ArrayList<>(Arrays.asList(6,1,7,1,5,2,6,2));

    private ArrayList<Integer> lBlockS1 = new ArrayList<>(Arrays.asList(5, 1, 5, 2, 5, 2, 6, 3));
    private ArrayList<Integer> lBlockS2 = new ArrayList<>(Arrays.asList(7,1,5,2,6,2,7,2));
    private ArrayList<Integer> lBlockS3 = new ArrayList<>(Arrays.asList(5,1,6,1,6,2,6,3));
    private ArrayList<Integer> lBlockS4 = new ArrayList<>(Arrays.asList(6,1,6,2,5,3,6,3));
    private ArrayList<Integer> lBlockS5 = new ArrayList<>(Arrays.asList(5,1,6,1,7,1,7,2));
    private ArrayList<Integer> lBlockS6 = new ArrayList<>(Arrays.asList(5,1,6,1,5,2,5,3));
    private ArrayList<Integer> lBlockS7 = new ArrayList<>(Arrays.asList(5,1,6,1,7,1,5,2));
    private ArrayList<Integer> lBlockS8 = new ArrayList<>(Arrays.asList(5,1,5,2,6,2,7,2));


    private ArrayList<Integer> tBlockS1 = new ArrayList<>(Arrays.asList(5, 1, 6, 1, 7, 1, 6, 2));
    private ArrayList<Integer> tBlockS2 = new ArrayList<>(Arrays.asList(5, 1,5,2,6,2,5,3));
    private ArrayList<Integer> tBlockS3 = new ArrayList<>(Arrays.asList(6,1,5,2,6,2,6,3));
    private ArrayList<Integer> tBlockS4 = new ArrayList<>(Arrays.asList(6,1,5,2,6,2,7,3));

    private ArrayList<Integer> iBlockS1 = new ArrayList<>(Arrays.asList(5, 1, 5, 2, 5, 3, 5, 4));
    private ArrayList<Integer> iBlockS2 = new ArrayList<>(Arrays.asList(4,1,5,1,6,1,7,1));

    private ArrayList<Integer> oBlockS1 = new ArrayList<>(Arrays.asList(5, 1, 6, 1, 5, 2, 6, 2));



    // an array list of 8 integers to represent the block, that is the four coordinates
    public ArrayList<Integer> fourUnits;
    
    // the canvas that this Block is on
    // this will make a bi-directional relationship
    private Canvas canvas;
    

    // type type
    // 1        S
    // 2        L
    // 3        T
    // 5        I
    // 6        O
    // initialize the block waiting to drop or begin to drop,
    // type is random (not doing here), statues is also 1(default)
    public Block(Canvas canvas, int type) throws gameOverException {
        this.canvas = canvas;
        tryToInstanciateABlock(type);
    }

    public void tryToInstanciateABlock(int type) throws gameOverException {
        ArrayList<Integer> temp;
        if (type == 1){
            temp = sBlockS1;
        }else if (type == 2){
            temp = lBlockS1;
        }else if (type == 3){
            temp = tBlockS1;
        }else if (type == 4){
            temp = iBlockS1;
        }else{
            temp = oBlockS1;
        }

        if (passport(temp, this.canvas.sediments)){
            fourUnits = temp;
        }else{
            throw new gameOverException("Your game is over!");
        }
        this.type = type;
    }

    // move the block down by oen unit, increase the value of Y coordinate by 1
    public void dropBlock(){
        for (int i = 0; i < 8; i++) {
            if (i%2 != 0){
                fourUnits.set(i,fourUnits.get(i)+1);
            }
        }
        numberOfY++;
    }

    // move the block to left or right by 1 unit,
    // direction is false, x-coordinate decrease to left
    // direction is true, x-coordinate increase to right
    public void moveBlock(boolean direction){
        if (direction){
            for (int i = 0; i < 8; i++) {
                if (i%2 == 0){
                    fourUnits.set(i,fourUnits.get(i)+1);
                }
            }
            numberOfX++;
        }else{
            for (int i = 0; i < 8; i++) {
                if (i%2 == 0){
                    fourUnits.set(i,fourUnits.get(i)-1);
                }
            }
            numberOfX--;
        }
    }

    public void changeCatch(){
        try {
            changeBlockStatus();
        } catch (illegalOperationException e) {
            System.out.println("Illegal operation");
        }

    }

    // rotate the block if the up button is pressed
    // change the block to the next status of the four
    public void changeBlockStatus() throws illegalOperationException {
        if (type == 1){
            if (status%4 == 1){
                fourUnits = updatePosition(sBlockS2);
            }else if (status%4 == 2){
                fourUnits = updatePosition(sBlockS3);
            }else if (status%4 == 3){
                fourUnits = updatePosition(sBlockS4);
            }else{
                fourUnits = updatePosition(sBlockS1);
            }
        }else if(type == 2){
            if (status%8 == 1){
                fourUnits = updatePosition(lBlockS2);
            }else if (status%8 == 2){
                fourUnits = updatePosition(lBlockS3);
            }else if (status%8 == 3){
                fourUnits = updatePosition(lBlockS4);
            }else if (status%8 == 4){
                fourUnits = updatePosition(lBlockS5);
            }else if (status%8 == 5){
                fourUnits = updatePosition(lBlockS6);
            }else if (status%8 == 6){
                fourUnits = updatePosition(lBlockS7);
            }else if (status%8 == 7){
                fourUnits = updatePosition(lBlockS8);
            }else{
                fourUnits = updatePosition(lBlockS1);
            }
        }else if (type == 3){
            if (status%4 == 1){
                fourUnits = updatePosition(tBlockS2);
            }else if (status%4 == 2){
                fourUnits = updatePosition(tBlockS3);
            }else if (status%4 == 3){
                fourUnits = updatePosition(tBlockS4);
            }else{
                fourUnits = updatePosition(tBlockS1);
            }
        }else if (type == 4){
            if (status%2 == 1){
                fourUnits = updatePosition(iBlockS2);
            }else{
                fourUnits = updatePosition(iBlockS1);
            }
        }else{
            System.out.println("block of type o can not change status");
        }
        status++;
    }

    // update the array from the formal status to now, system should array the movement if there is not enough space to finish the order
    public ArrayList<Integer> updatePosition(ArrayList<Integer> array) throws illegalOperationException {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i%2 == 0){
                temp.set(i, array.get(i)+numberOfX);
            }else{// i%2 !=0
                temp.set(i, array.get(i)+numberOfY);
            }
        }
        if (passport(temp,this.canvas.sediments)){
            return temp;
        }else{
            throw new illegalOperationException("This is an illegal operation");
        }
    }


    // drop the block directly to bottom
    // requires the block target is available (do not overlap with the sediments)
    // &&&&& beta &&&&&
    public void dropBottom(Block target, Sediments sediments){
        if (target.passport(target.fourUnits, sediments)){
            mergeBlock(target, sediments);
        }
        mergeBlock(target, sediments);
    }


    // the block should merge to the segment when it reaches the furthest position it can go
    public void mergeBlock(Block block, Sediments sediments){
        for (int i = 0; i < 8; i = i+2) {
            sediments.addUnit(block.fourUnits.get(i),block.fourUnits.get(i+1));
        }
    }

    public boolean passport(ArrayList<Integer> array, Sediments sediments){
        for (int i = 0; i < 8; i=i+2) {
            if (sediments.containThisUnit(array.get(i), array.get(i+1))){
                return false;
            }
        }
        return true;
    }







}
