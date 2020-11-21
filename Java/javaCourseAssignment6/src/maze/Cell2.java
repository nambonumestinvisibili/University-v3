package maze;

import java.util.ArrayList;
import java.util.Collections;

public class Cell2 {
    private boolean visited = false;

    private Cell2 upNeighbour = null;
    private Cell2 downNeighbour = null;
    private Cell2 rightNeighbour = null;
    private Cell2 leftNeighbour = null;

    private boolean upWall = true;
    private boolean downWall = true;
    private boolean rightWall = true;
    private boolean leftWall = true;

    public ArrayList<Cell2> directNeighbours = new ArrayList<>();



    public void markAsVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    //begin getters and setters

    public void setUpNeighbour(Cell2 c) {
        upNeighbour = c;
    }

    public Cell2 getUpNeighbour() {
        return upNeighbour;
    }

    public void setDownNeighbour(Cell2 c) {
        downNeighbour = c;
    }

    public Cell2 getDownNeighbour() {
        return downNeighbour;
    }

    public void setRightNeighbour(Cell2 c) {
        rightNeighbour = c;
    }

    public Cell2 getRightNeighbour() {
        return rightNeighbour;
    }

    public void setLeftNeighbour(Cell2 c) {
        leftNeighbour = c;
    }

    public Cell2 getLeftNeighbour() {
        return leftNeighbour;
    }

    // end

    public void deleteUpWall() {
        upWall = false;
    }

    public void deleteDownWall() {
        downWall = false;
    }

    public void deleteRightWall() {
        rightWall = false;
    }

    public void deleteLeftWall() {
        leftWall = false;
    }


    public boolean hasUpWall() {
        return upWall;
    }

    public boolean hasDownWall() {
        return downWall;
    }

    public boolean hasRightWall() {
        return rightWall;
    }

    public boolean hasLeftWall() {
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