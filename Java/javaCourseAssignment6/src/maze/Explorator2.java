package maze;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Explorator2 {
    private int dx;
    private int dy;
    private Cell2 cells[][];
    private int x;
    private int y;
    private int w;
    private int h;
    private Image img;

    public Explorator2(int x, int y, Cell2[][] maze) {
        this.x = x;
        this.y = y;
        cells = maze;
        loadImg();
    }

    private void loadImg() {
        String filename = "C:\\Users\\dvwid\\Documents\\University-v3\\Java\\javaCourseAssignment6\\src\\images\\minion.png";
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("NO such img");
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

}