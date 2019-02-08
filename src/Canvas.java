import elements.Unit;

import java.util.ArrayList;

public class Canvas {
    ArrayList<ArrayList<Unit>> canvas = new ArrayList<>();

    //initialize the canvas with 10 units width and 20 units height
    public Canvas(){
        for (int i = 1; i <= 20; i++) {
            ArrayList line = new ArrayList<>();
            canvas.add(line);
            for (int j = 1; j <= 10; j++) {
                Unit unit = new Unit(j,i);
                line.add(unit);
                unit.getPos();
            }
        }
    }

    // locate the unit with the given coordinate
    public Unit location(int x, int y){
        return canvas.get(y).get(x);
    }
}
