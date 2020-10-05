package Model;

import javax.validation.constraints.Min;

public class Map {
    private int gridSize;
    private String[][] grid;

    public Map(){}
    public void printMap(){
        for(int row = 0;row  < gridSize; row++){
            int column;
            for (column = 0; column < gridSize ; column++) {
                if (grid[row][column] == null) {
                    System.out.print(" * ");
                }
                else {
                    System.out.print(" "+ grid[row][column]  + " ");
                }
            }
            if (column == gridSize) {
                System.out.print("");
            }
            System.out.print("\n");
        }
    }

    @Min(1)
    public void setSize(int level) {

        this.gridSize = (int) ((level -1) * 5 + 10 - (level % 2));
    }

    public int getSize() {
        return gridSize;
    }

    public void updatePosition(int x, int y, String c){
        if (x < gridSize && y < gridSize){
            this.grid[x][y] = c;
        }
    }

    public void setBoard() {
        this.grid = new String[gridSize][gridSize];
        for(int row = 0;row  < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                grid[row][column] = null;
            }
        }
    }


}
