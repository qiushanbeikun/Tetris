package elements;


import java.util.ArrayList;

// segments is the blocks on the bottom of the game
public class Sediments {

    public ArrayList<Integer> contents = new ArrayList<>();

    //constructor: initialize the sediment constructor as default to be empty
    public Sediments(){
    }

    public  void addUnit(int x, int y){
        contents.add(x);
        contents.add(y);
    }

    public boolean containThisUnit(int x, int y){
        if (contents == null){
            return false;
        }else{
            for (int i = 0; i < contents.size(); i=i+2) {
                if (contents.get(i) == x){
                    if (contents.get(i+1) == y){
                        return true;
                    }
                }
            }
        }
        return false;
    }





}
