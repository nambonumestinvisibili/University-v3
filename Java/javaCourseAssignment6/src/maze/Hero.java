package maze;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hero {
    private int x;
    private int y;
    private String imageFilename = "C:\\Users\\dvwid\\Documents\\University-v3\\Java\\javaCourseAssignment6\\src\\images\\hero.png";
    private Image img;
    private int cellSize;

    public Hero(int x, int y, int cellSize){
        this.x = x;
        this.y = y;
        this.cellSize = cellSize;

        try {
            img = ImageIO.read(new File(imageFilename));
        } catch (IOException e) {
            System.out.println("No image of given filename");
        }
    }

    public void moveUp(){
        y -= 1;
    }

    public void moveDown(){
        y += 1;
    }

    public void moveLeft(){
        x -= 1;
    }

    public void moveRight(){
        x += 1;
    }

    public void paintHero(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.drawImage(getImg(), (cellSize) * getX(),
                (cellSize) * getY(), null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImg() {
        return img;
    }
}
