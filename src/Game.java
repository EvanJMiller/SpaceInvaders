import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Game extends JPanel {

    Defender defender = new Defender(this);
    Barrier barrier = new Barrier(this);


    public Game (){
        initUI();           // creates window
        getKeyboardInput(); // gets user input
    }

    /** Takes in input from Keyboard */
    public void getKeyboardInput(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                defender.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                defender.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    /* updates graphics on screen */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        defender.paint(g2d);
        barrier.paint(g2d);
    }

    /** initUI creates a window with a black background called Space Invader, which is maximized at startup */
    public void initUI(){
        JFrame frame = new JFrame("Space Invaders");
        frame.add(this);
        frame.setSize(300, 400);
        frame.setVisible(true);
        setBackground(Color.black);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /** moves all objects in the game */
    private void move() {
        defender.move();
    }

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10); // must be included so that OS can use threads
        }
    }
}
