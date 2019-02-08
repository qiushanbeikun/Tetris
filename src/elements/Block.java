package elements;

import java.util.ArrayList;
import java.util.Arrays;

public class Block {

    private int numberOfY;
    private int numberOfX;
    private int type;
    private int status ;



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
    private ArrayList<Integer> fourUnits;

    // type type
    // 1        S
    // 2        L
    // 3        T
    // 5        I
    // 6        O
    // initialize the block waiting to drop or begin to drop,
    // type is random (not doing here), statues is also 1(default)
    public Block(Canvas canvas, int type){
        if (type == 1){
            fourUnits = sBlockS1;
        }else if (type == 2){
            fourUnits = lBlockS1;
        }else if (type == 3){
            fourUnits = tBlockS1;
        }else if (type == 4){
            fourUnits = iBlockS1;
        }else{
            fourUnits = oBlockS1;
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

    // drop the block directly to bottom
    public void dropBottom(){

    }

    // rotate the block
    // change the block to the next status of the four
    public void changeBlockStatus(){
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

    // update the block from the formal status to now, system should block the movement if there is not enough space to finish the order
    public ArrayList<Integer> updatePosition(ArrayList<Integer> block){
        for (int i = 0; i < 8; i++) {
            if (i%2 == 0){
                block.set(i, block.get(i)+numberOfX);
            }else{// i%2 !=0
                block.set(i, block.get(i)+numberOfY);
            }
        }
        return block;
    }


    // the block should merge to the segment when it reaches the furthest position it can go
    public void mergeBlock(){

    }



}
