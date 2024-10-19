package src.slUtils.slVariables;

public class Coords {
    private int x, y;
    public Coords (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
    return this.x;
    }
    
    public int getY() {
    return this.y;
    }
    
    @Override
    public String toString() {
        return "Coords(" + x + ", " + y + ")";  // Override toString to print coordinates
    }

    
    
}   
