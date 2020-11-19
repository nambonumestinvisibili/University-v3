package maze;

import java.util.ArrayList;
import java.util.Collections;

public class Cell {
    private boolean visited = false;

    private Cell upNeighbour = null;
    private Cell downNeighbour = null;
    private Cell rightNeighbour = null;
    private Cell leftNeighbour = null;

    private boolean upWall = true;
    private boolean downWall = true;
    private boolean rightWall = true;
    private boolean leftWall = true;

    public ArrayList<Cell> directNeighbours = new ArrayList<>();



    public void markAsVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    //begin getters and setters

    public void setUpNeighbour(Cell c) {
        upNeighbour = c;
    }

    public Cell getUpNeighbour() {
        return upNeighbour;
    }

    public void setDownNeighbour(Cell c) {
        downNeighbour = c;
    }

    public Cell getDownNeighbour() {
        return downNeighbour;
    }

    public void setRightNeighbour(Cell c) {
        rightNeighbour = c;
    }

    public Cell getRightNeighbour() {
        return rightNeighbour;
    }

    public void setLeftNeighbour(Cell c) {
        leftNeighbour = c;
    }

    public Cell getLeftNeighbour() {
        return leftNeighbour;
    }

    // end

    public void deleteNorthernWall() {
        upWall = false;
    }

    public void deleteSouthernWall() {
        downWall = false;
    }

    public void deleteEasternWall() {
        rightWall = false;
    }

    public void deleteWesternWall() {
        leftWall = false;
    }


    public boolean hasNorthernWall() {
        return upWall;
    }

    public boolean hasSouthernWall() {
        return downWall;
    }

    public boolean hasEasternWall() {
        return rightWall;
    }

    public boolean hasWesternWall() {
        return leftWall;
    }

    private void shuffleDirectNeighbours() {
        Collections.shuffle(directNeighbours);
    }

    public void setDirectNeighbours() {
        if (upNeighbour != null) {
            directNeighbours.add(upNeighbour);
        }
        if (downNeighbour != null) {
            directNeighbours.add(downNeighbour);
        }
        if (rightNeighbour != null) {
            directNeighbours.add(rightNeighbour);
        }
        if (leftNeighbour != null) {
            directNeighbours.add(leftNeighbour);
        }
        shuffleDirectNeighbours();
    }
}