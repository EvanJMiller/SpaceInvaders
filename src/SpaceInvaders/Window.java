package SpaceInvaders;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;

    Window(){}
    Window(Game game){
        frame = new JFrame("Space Invaders");
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        game.setBackground(Color.black);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getWindowWidth(){
        return frame.getWidth();
    }
    public int getWindowHeight(){
        return frame.getHeight();
    }

}
