package maze;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MazeFrame extends Frame {

    public Maze maze;

    public MazeFrame(){
        super();
        maze = new Maze(15, 15);
        setSize(600, 600);
        WindowListener close = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                MazeFrame.this.dispose();
            }
        };
        addWindowListener(close);
        add(maze);
        setVisible(true);
    }
}
