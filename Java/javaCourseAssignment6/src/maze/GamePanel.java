package maze;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends Canvas implements KeyListener {

    MainFrame mainFrame;
    Hero hero;
    Maze maze;
    int cellSize = 30;
    int width;
    int height;

    public GamePanel(MainFrame mainFrame, int height, int width){
        this.height = height;
        this.width = width;

        Random random = new Random();
        int startx = random.nextInt(height);
        int starty = random.nextInt(width);

        setSize(cellSize * width, cellSize * height);
        addKeyListener(this);

        this.maze = new Maze(width, height, startx, starty, cellSize);
        this.mainFrame = mainFrame;
        this.hero = new Hero(starty, startx, cellSize);


    }

    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        maze.paintMaze(graphics2D);
        hero.paintHero(graphics2D);
    }

    private boolean shouldGameFinish(){
        return hero.getY() * 30 == 0 && hero.getX() == width-1;
    }

    private void tryGameOver(){
        if (shouldGameFinish()) {
            mainFrame.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int keyCode = keyEvent.getKeyCode();

        Cell heroCell = maze.getCell(hero.getY(), hero.getX());

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
