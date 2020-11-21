package maze;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MazeFrame2 extends Frame {

    public Maze2 maze;

    public MazeFrame2() {
//        super("aMAZEing");
        super();
        maze = new Maze2(14, 14);
        setSize(650, 650);
        WindowListener closeAndResize = new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                MazeFrame2.this.dispose();
            }
        };
        this.addWindowListener(closeAndResize);
        add(maze);
        setVisible(true);
    }
}