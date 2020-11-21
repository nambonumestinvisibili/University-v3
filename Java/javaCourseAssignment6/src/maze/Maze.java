package maze;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Maze extends Canvas implements KeyListener {


    private final int height;
    private final int width;
    private final int cellSize;
    private final Hero hero;
    private final Cell[][] maze;
    private Cell start;
    private Cell finish;
    private boolean gameFinished;
    private final MainFrame mainFrame;

    public Maze(int width, int height, MainFrame mainFrame){
        this.height = height;
        this.width = width;
        this.maze = new Cell[height][width];
        this.cellSize = 30;
        this.mainFrame = mainFrame;

        setSize(cellSize * width, cellSize * height);
        addKeyListener(this);

        initializeMaze();

        Random random = new Random();
        int startx = random.nextInt(height);
        int starty = random.nextInt(width);

        start = maze[startx][starty];
        start.setVisitedTrue();

        finish = maze[0][width-1];

        hero = new Hero(starty, startx);

        generateMaze(start);
    }

    private void initializeMaze() {
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                maze[i][j] = new Cell();
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // position of neighbours depending on current cell position
                if (i == 0 && j == 0) {
                    //top left
                    maze[i][j].setDownNbour(maze[i + 1][j]);
                    maze[i][j].setRightNbour(maze[i][j + 1]);

                } else if (i == height-1 && j == 0) {
                    //bottom left
                    maze[i][j].setUpNbour(maze[i - 1][j]);
                    maze[i][j].setRightNbour(maze[i][j + 1]);
                } else if (i == 0 && j == width - 1) {
                    //top right
                    maze[i][j].setDownNbour(maze[i + 1][j]);
                    maze[i][j].setLeftNbour(maze[i][j - 1]);
                } else if (i == height - 1 && j == width - 1) {
                    //bottom right
                    maze[i][j].setUpNbour(maze[i - 1][j]);
                    maze[i][j].setLeftNbour(maze[i][j - 1]);
                } else if (i == 0 && j > 0 && j < width - 1) {
                    //very top row
                    maze[i][j].setDownNbour(maze[i + 1][j]);
                    maze[i][j].setRightNbour(maze[i][j + 1]);
                    maze[i][j].setLeftNbour(maze[i][j - 1]);
                } else if (i == height - 1 && j > 0 && j < width - 1) {
                    //very bottom row
                    maze[i][j].setUpNbour(maze[i - 1][j]);
                    maze[i][j].setRightNbour(maze[i][j + 1]);
                    maze[i][j].setLeftNbour(maze[i][j - 1]);
                } else if (i > 0 && i < height - 1 && j == 0) {
                    //very left col
                    maze[i][j].setUpNbour(maze[i - 1][j]);
                    maze[i][j].setDownNbour(maze[i + 1][j]);
                    maze[i][j].setRightNbour(maze[i][j + 1]);
                } else if (i > 0 && i < height - 1 && j == width - 1) {
                    //very right col
                    maze[i][j].setUpNbour(maze[i - 1][j]);
                    maze[i][j].setDownNbour(maze[i + 1][j]);
                    maze[i][j].setLeftNbour(maze[i][j - 1]);
                } else {
                    maze[i][j].setUpNbour(maze[i - 1][j]);
                    maze[i][j].setDownNbour(maze[i + 1][j]);
                    maze[i][j].setRightNbour(maze[i][j + 1]);
                    maze[i][j].setLeftNbour(maze[i][j - 1]);
                }
                maze[i][j].fillDirectNboursWithShuffledNbours();
            }
        }
    }

    private void generateMaze(Cell start) {
        for (Cell cell : start.getDirectNbours()){
            if (cell.isVisited() == false){
                cell.setVisitedTrue();
                if (cell == start.getUpNbour()){
                    start.deleteUpWall();
                    cell.deleteDownWall();
                }
                else if (cell == start.getDownNbour()){
                    start.deleteDownWall();
                    cell.deleteUpWall();
                }
                else if (cell == start.getRightNbour()){
                    start.deleteRightWall();
                    cell.deleteLeftWall();
                }
                else if (cell == start.getLeftNbour()){
                    start.deleteLeftWall();
                    cell.deleteRightWall();
                }
                generateMaze(cell);
            }
        }
    }

    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        paintMaze(graphics2D);
        hero.paintHero(graphics2D, cellSize);
    }

    private void paintMaze(Graphics g) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == finish) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    g.setColor(Color.BLACK);
                }
                if (maze[i][j].hasUpWall()) {
                    g.drawLine(j * 30, i * 30, j * 30 + 30, i * 30);
                }
                if (maze[i][j].hasDownWall()) {
                    g.drawLine(j * 30, i * 30 + 30, j * 30 + 30, i * 30 + 30);
                }
                if (maze[i][j].hasRightWall()) {
                    g.drawLine(j * 30 + 30, i * 30, j * 30 + 30, i * 30 + 30);
                }
                if (maze[i][j].hasLeftWall()) {
                    g.drawLine(j * 30, i * 30, j * 30, i * 30 + 30);
                }
            }
        }
    }

    private boolean shouldGameFinish(){
        return hero.getY() * 30 == 0 && hero.getX() == width-1;
    }

    private void tryGameOver(){
        if (shouldGameFinish()) {
            gameFinished = true;

            System.out.println("You've won!");

            mainFrame.dispose();
        }
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (gameFinished) return;

        int keyCode = keyEvent.getKeyCode();

        Cell heroCell = maze[hero.getY()][hero.getX()];

        if (keyCode == KeyEvent.VK_UP && !heroCell.hasUpWall()) {
            hero.moveUp();
        }
        if (keyCode == KeyEvent.VK_DOWN && !heroCell.hasDownWall()) {
            hero.moveDown();
        }
        if (keyCode == KeyEvent.VK_LEFT && !heroCell.hasLeftWall()) {
            hero.moveLeft();
        }
        if (keyCode == KeyEvent.VK_RIGHT && !heroCell.hasRightWall()) {
            hero.moveRight();
        }

        repaint();

        tryGameOver();
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {    }
}
