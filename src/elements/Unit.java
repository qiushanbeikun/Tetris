package elements;

public class Unit {

    private boolean status;
    public int posX;
    public int posY;



    //set the default unit to empty and unoccupied,set position when declared and will not change
    public Unit(int x, int y){
        status = false;
        posX = x;
        posY = y;
    }

    public boolean getStatus(){
        return status;
    }

    public void changeStatus(){
        status = !status;
    }

    public void getPos(){
        System.out.println("("+posX+","+posY+")");
    }




}
