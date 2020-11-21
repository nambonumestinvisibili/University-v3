package maze;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends Frame {

    public Maze maze;

    public MainFrame(){
        super();
        maze = new Maze(10, 10, this);
        setSize(600, 600);
        WindowListener close = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                MainFrame.this.dispose();
            }
        };
        addWindowListener(close);
        add(maze);
        setVisible(true);
    }
}
