package maze;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends Frame {

    GamePanel gamePanel;

    public MainFrame(){
        super();
        int mazeSize = 10;
        gamePanel = new GamePanel( this, mazeSize, mazeSize);

        setSize(600, 600);
        WindowListener close = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                MainFrame.this.dispose();
            }
        };
        addWindowListener(close);
        add(gamePanel);
        setVisible(true);
    }
}
