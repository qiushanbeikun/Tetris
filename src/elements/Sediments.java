package elements;


import java.util.ArrayList;

// segments is the blocks on the bottom of the game
public class Sediments {

    public ArrayList<Integer> contents = null;

    //constructor: initialize the sediment constructor as default to be empty
    public Sediments(){
    }

    public  void addUnit(int x, int y){
        contents.add(x);
        contents.add(y);
    }

    public boolean containThisUnit(int x, int y){
        for (int i = 0; i < contents.size(); i=i+2) {
            if (contents.get(i) == x){
                if (contents.get(i+1) == y){
                    return true;
                }
            }
        }
        return false;
    }

    //assume the size of the array list must be even.
    public void allocateSedimnts(Canvas canvas, Sediments sediments){
        for (int i = 0; i < sediments.contents.size()/2; i=i+2) {
            canvas.location(sediments.contents.get(i), sediments.contents.get(i+1)).changeStatus();
        }
    }



}
