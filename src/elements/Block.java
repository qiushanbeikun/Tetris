package elements;

import java.util.ArrayList;

public class Block {

    // an array list of 8 integers to represent the block, that is the four coordinates
    public ArrayList<Integer> fourUnits = new ArrayList<>();


    // type type
    // 1        S
    // 2        Z
    // 3        T
    // 4        I
    // 5        O
    public Block(Canvas canvas, int type){

        if(type == 1){
            fourUnits.add(5);
            fourUnits.add(0);
            fourUnits.add(5);
            fourUnits.add(1);
            fourUnits.add(6);
            fourUnits.add(1);
            fourUnits.add(6);
            fourUnits.add(2);
        }else if (type == 2){

        }else if (type == 3){

        }else if (type == 4){

        }else{

        }
    }

    // move the block down by oen unit, increase the value of Y coordinate by 1
    public void dropBlock(){
        for (int i = 0; i < 8; i++) {
            if (i%2 != 0){
                fourUnits.set(i,fourUnits.get(2)+1);
            }
        }
    }

    // move the block to left or right by 1 unit,
    // direction is false, x-coordinate decrease to left
    // direction is true, x-coordinate increase to right
    public void moveBlock(boolean direction){
        if (direction){
            for (int i = 0; i < 8; i++) {
                if (i%2 == 0){
                    fourUnits.set(i,fourUnits.get(2)+1);
                }
            }
        }else{
            for (int i = 0; i < 8; i++) {
                if (i%2 == 0){
                    fourUnits.set(i,fourUnits.get(2)-1);
                }
            }
        }
    }

    // flip the block horizontally if boolean is true;
    // flip the block vertically if the boolean is true
    public void flipBlock(boolean horiOrVer){
        int blockWidth = Math.max(fourUnits.get(0), Math.max(fourUnits.get(2), Math.max(fourUnits.get(4), fourUnits.get(6)))) - Math.min(fourUnits.get(0), Math.min(fourUnits.get(2), Math.min(fourUnits.get(4), fourUnits.get(6))));
        int blockHeight = Math.max(fourUnits.get(1), Math.max(fourUnits.get(3), Math.max(fourUnits.get(5), fourUnits.get(7)))) - Math.min(fourUnits.get(1), Math.min(fourUnits.get(3), Math.min(fourUnits.get(5), fourUnits.get(7))));

        if (horiOrVer){
            if (blockWidth == 3){

            }else{

            }
        }else{

        }
    }



    public void mergeBlock(){

    }



}
