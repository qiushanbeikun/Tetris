package elements;

import java.util.ArrayList;
import java.util.Random;

public class Block {
    // an array list of 8 integers to represent the block, that is the four coordinates
    public ArrayList<Integer> fourUnits = new ArrayList<>();


    // ranInt type
    // 1        S
    // 2        Z
    // 3        T
    // 4        I
    // 5        O
    public Block(Canvas canvas){
        int ranInt = new Random().nextInt(5);
        if(ranInt == 1){
            fourUnits.add(5);
            fourUnits.add(20);
            fourUnits.add(5);
            fourUnits.add(19);
            fourUnits.add(6);
            fourUnits.add(19);
            fourUnits.add(6);
            fourUnits.add(18);
        }else if (ranInt == 2){

        }else if (ranInt == 3){

        }else if (ranInt == 4){

        }else{

        }
    }

    public void dropBlock(){
        
    }


    public void mergeBlock(){

    }


}
