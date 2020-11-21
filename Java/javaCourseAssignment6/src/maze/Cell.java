package maze;

import java.util.ArrayList;
import java.util.Collections;

public class Cell {

    private boolean visited;

    private boolean upWall;
    private boolean downWall;
    private boolean rightWall;
    private boolean leftWall;

    private Cell upNbour;
    private Cell downNbour;
    private Cell rightNbour;
    private Cell leftNbour;

    private ArrayList<Cell> directNbours;

    public Cell(){
        visited = false;
        upNbour = null;
        downNbour = null;
        leftNbour = null;
        rightNbour = null;
        upWall = true;
        downWall = true;
        rightWall = true;
        leftWall = true;
        directNbours = new ArrayList<>();
    }

    public void setVisitedTrue() {visited = true;}

    public boolean isVisited(){
        return visited;
    }

    public void fillDirectNboursWithShuffledNbours(){
        if (upNbour != null) directNbours.add(upNbour);
        if (downNbour != null) directNbours.add(downNbour);
        if (leftNbour != null) directNbours.add(leftNbour);
        if (rightNbour != null) directNbours.add(rightNbour);
        Collections.shuffle(directNbours);
    }

    public ArrayList<Cell> getDirectNbours(){
        return directNbours;
    }

    public Cell getUpNbour() {
        return upNbour;
    }

    public void setUpNbour(Cell upNbour) {
        this.upNbour = upNbour;
    }

    public Cell getDownNbour() {
        return downNbour;
    }

    public void setDownNbour(Cell downNbour) {
        this.downNbour = downNbour;
    }

    public Cell getRightNbour() {
        return rightNbour;
    }

    public void setRightNbour(Cell rightNbour) {
        this.rightNbour = rightNbour;
    }

    public Cell getLeftNbour() {
        return leftNbour;
    }

    public void setLeftNbour(Cell leftNbour) {
        this.leftNbour = leftNbour;
    }

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
}
