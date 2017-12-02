import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel implements Features {

    public Defender defender = new Defender(this);
    ArrayList<Barrier> barrier = new ArrayList<>();
    ArrayList<Invader> invaders = new ArrayList<>();

    /** Constructor for game, builds all essential UI elements */
    public Game (){
        initUI();           // creates window
        getKeyboardInput(); // gets user input
        createObjects();
    }

    public void createObjects(){
        defender = new Defender(this);

        for(int i = 1; i < 4; i++) {
            for(int x = -2; x < 2; x++) {
                for (int y = 0; y < 4; y++) {
                    barrier.add(new Barrier(this, x, y, i));
                }
            }
        }

        for(int x = -COLS_OF_INVADERS/2; x <= COLS_OF_INVADERS/2; x++) {
            for (int y = 0; y < ROWS_OF_INVADERS; y++) {
                invaders.add(new Invader(this, x, y));
            }
        }

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

    /* updates graphics on screen */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        defender.paint(g2d);
        for(Barrier b: barrier){
            if(b != null){
                b.paint(g2d);
            }
        }
        for(Invader i: invaders){
            if(i != null){
                i.paint(g2d);
            }
        }
    }

    /** moves all objects in the game */
    private void move() {
        defender.move();
        for(Invader i : invaders) {
            i.move();
        }
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
