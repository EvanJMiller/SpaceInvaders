import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Game extends JPanel {

    public Game (){
        initUI(); // creates window
    }

    /** initUI creates a window called Space Invader, which is maximized at startup */
    public void initUI(){
        JFrame frame = new JFrame("Space Invaders");
        frame.add(this);
        frame.setSize(300, 400);
        frame.setVisible(true);
        setBackground(Color.black);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}
