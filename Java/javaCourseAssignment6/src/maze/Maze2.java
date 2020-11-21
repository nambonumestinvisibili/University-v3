package maze;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Maze2 extends Canvas implements KeyListener {
    private int numOfClicks;
    private final int mHeight;
    private final int mWidth;
    private final int cellSize = 30;
    private final Cell2[][] maze;
    private final Cell2 start;
    private final Cell2 finish;

    private final Explorator2 explorator;
    private boolean gameWon = false;

    public Maze2(int height, int width) {
        mHeight = height;
        mWidth = width;
        this.maze = new Cell2[mHeight][mWidth];
        numOfClicks = 0;

        setSize(cellSize*mWidth, cellSize*mHeight);
        addKeyListener(this);

        initializeMaze();

        Random rand = new Random();
        int startX = rand.nextInt(mHeight), startY = rand.nextInt(mWidth);

        start = maze[startX][startY];
        start.markAsVisited();
        finish = maze[0][mWidth - 1];

        explorator = new Explorator2(startY, startX, maze);

        generateMaze(start);
    }

    private void initializeMaze() {
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                maze[i][j] = new Cell2();
            }
        }
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                // position of neighbours depending on current cell position
                if (i == 0 && j == 0) {
                    //top left
                    maze[i][j].setDownNeighbour(maze[i + 1][j]);
                    maze[i][j].setRightNeighbour(maze[i][j + 1]);

                } else if (i == mHeight - 1 && j == 0) {
                    //bottom left
                    maze[i][j].setUpNeighbour(maze[i - 1][j]);
                    maze[i][j].setRightNeighbour(maze[i][j + 1]);
                } else if (i == 0 && j == mWidth - 1) {
                    //top right
                    maze[i][j].setDownNeighbour(maze[i + 1][j]);
                    maze[i][j].setLeftNeighbour(maze[i][j - 1]);
                } else if (i == mHeight - 1 && j == mWidth - 1) {
                    //bottom right
                    maze[i][j].setUpNeighbour(maze[i - 1][j]);
                    maze[i][j].setLeftNeighbour(maze[i][j - 1]);
                } else if (i == 0 && j > 0 && j < mWidth - 1) {
                    //very top row
                    maze[i][j].setDownNeighbour(maze[i + 1][j]);
                    maze[i][j].setRightNeighbour(maze[i][j + 1]);
                    maze[i][j].setLeftNeighbour(maze[i][j - 1]);
                } else if (i == mHeight - 1 && j > 0 && j < mWidth - 1) {
                    //very bottom row
                    maze[i][j].setUpNeighbour(maze[i - 1][j]);
                    maze[i][j].setRightNeighbour(maze[i][j + 1]);
                    maze[i][j].setLeftNeighbour(maze[i][j - 1]);
                } else if (i > 0 && i < mHeight - 1 && j == 0) {
                    //very left col
                    maze[i][j].setUpNeighbour(maze[i - 1][j]);
                    maze[i][j].setDownNeighbour(maze[i + 1][j]);
                    maze[i][j].setRightNeighbour(maze[i][j + 1]);
                } else if (i > 0 && i < mHeight - 1 && j == mWidth - 1) {
                    //very right col
                    maze[i][j].setUpNeighbour(maze[i - 1][j]);
                    maze[i][j].setDownNeighbour(maze[i + 1][j]);
                    maze[i][j].setLeftNeighbour(maze[i][j - 1]);
                } else {
                    maze[i][j].setUpNeighbour(maze[i - 1][j]);
                    maze[i][j].setDownNeighbour(maze[i + 1][j]);
                    maze[i][j].setRightNeighbour(maze[i][j + 1]);
                    maze[i][j].setLeftNeighbour(maze[i][j - 1]);
                }
                maze[i][j].setDirectNeighbours();
            }
        }
    }

    private void generateMaze(Cell2 start) {
        for (Cell2 current : start.directNeighbours) {
            if (!current.isVisited()) {
                current.markAsVisited();
                if (current == start.getUpNeighbour()) {
                    start.deleteUpWall();
                    current.deleteDownWall();
                } else if (current == start.getDownNeighbour()) {
                    start.deleteDownWall();
                    current.deleteUpWall();
                } else if (current == start.getRightNeighbour()) {
                    start.deleteRightWall();
                    current.deleteLeftWall();
                } else if (current == start.getLeftNeighbour()) {
                    start.deleteLeftWall();
                    current.deleteRightWall();
                }
                generateMaze(current);
            }
        }
    }

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        drawEverything(graphics2D);
        //paintMaze(g);
        //g.drawImage(explorator.getImg(), explorator.getX() * cellSize, explorator.getY() * cellSize, this);
    }

    private void drawEverything(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        paintMaze(graphics2D);
        graphics2D.drawImage(explorator.getImg(), cellSize * explorator.getX(), cellSize * explorator.getY(), null);
    }

    private void paintMaze(Graphics g) {
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                if (maze[i][j] == start) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    g.setColor(Color.BLACK);
                }
                if (maze[i][j] == finish) {
                    g.setColor(Color.RED);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        numOfClicks++;

        if (gameWon) return;

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP && !maze[explorator.getY()][explorator.getX()].hasUpWall()) {
            explorator.setY((explorator.getY() - 1));
        }
        if (key == KeyEvent.VK_DOWN && !maze[explorator.getY()][explorator.getX()].hasDownWall()) {
            explorator.setY((explorator.getY() + 1));
        }
        if (key == KeyEvent.VK_LEFT && !maze[explorator.getY()][explorator.getX()].hasLeftWall()) {
            explorator.setX((explorator.getX() - 1));
        }
        if (key == KeyEvent.VK_RIGHT && !maze[explorator.getY()][explorator.getX()].hasRightWall()) {
            explorator.setX((explorator.getX() + 1));
        }

        repaint();

        if (explorator.getY() * 30 == 0 && explorator.getX() == mWidth-1) {
            gameWon = true;
            System.out.println("Congratulations, You've made it in " + numOfClicks + " clicks!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}