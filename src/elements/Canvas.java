package elements;

import java.util.ArrayList;

public class Canvas {
    public ArrayList<ArrayList<Unit>> canvas = new ArrayList<>();
    public Sediments sediments;

    //initialize the canvas with 10 units width and 20 units height
    public Canvas(){
        for (int i = 1; i <= 20; i++) {
            ArrayList<Unit> line = new ArrayList<>();
            canvas.add(line);
            for (int j = 1; j <= 10; j++) {
                Unit unit = new Unit(j,i);
                line.add(unit);

            }
        }
        sediments = new Sediments();
        //printStatus();
    }

    // locate the unit with the given coordinate
    public Unit location(int x, int y){
        return canvas.get(y).get(x);
    }

    public void printStatus(){
        for (int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 10; j++) {
                Unit temp = canvas.get(i).get(j);
                temp.printPos();
                temp.printStatus();
            }
            System.out.println("\n");
        }


    }

    // allocate the position of the
    public void allocateBlock(Canvas canvas, Block block){
        for (int i = 0; i < 8; i=i+2) {
            canvas.location(block.fourUnits.get(i), block.fourUnits.get(i+1)).changeStatus();
        }
    }

    //assume the size of the array list must be even.
    public void allocateSedimnts(Canvas canvas, Sediments sediments){
        for (int i = 0; i < sediments.contents.size()/2; i=i+2) {
            canvas.location(sediments.contents.get(i), sediments.contents.get(i+1)).changeStatus();
        }
    }
}
