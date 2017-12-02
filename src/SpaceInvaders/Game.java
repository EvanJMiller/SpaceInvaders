package SpaceInvaders;

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

    /*

    private Thread thread; // thread to be used later
    private boolean running; //is the program running

    public Game(){

    initUI() - He has a window class but this should work
    Handler = new handler();

    }

    public synchronized void start(){

        Thread t = new Thread(this);
        thread.start();
        running  = true;

    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    //ALREADY IMPLEMENTED, MAIN GAME LOOP
    public synchonized void run(){

    }




     */

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

    /** initUI creates a window with a black background called Space SpaceInvaders.SpaceInvaders.Invader, which is maximized at startup */
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
    public synchronized void run()
    {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        boolean gameRunning = true;
        long lastFpsTime = 0;
        long fps = 0;
        // keep looping round til the game ends
        while (gameRunning)
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000)
            {
                System.out.println("(FPS: "+fps+")");
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            //doGameUpdates(delta);

            // draw everyting
            //render();

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try{
                Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
            }
            catch(Exception e){
                System.out.println(e);
            };
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
