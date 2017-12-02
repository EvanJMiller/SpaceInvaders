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

import SpaceInvaders.Window;
import SpaceInvaders.Handler;

public class Game extends JPanel implements Runnable, Features {

    Window w;
    private Thread thread; // thread to be used later
    private boolean running; //is the program running
    Handler h;

    public synchronized void start(){

        thread = new Thread(this);
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


    /** Constructor for game, builds all essential UI elements */
    public Game (){ 
        //initUI();           // creates window
        start();
        w = new Window(this);
        getKeyboardInput(); // gets user input
        h = new Handler();
        createObjects(h);
    }

    public void createObjects(Handler h){
        h.addObject(new Defender(w,h));

        for(int i = 1; i < 4; i++) {
            for(int x = -2; x < 2; x++) {
                for (int y = 0; y < 4; y++) {
                    h.addObject(new Barrier(w, x, y, i));
                }
            }
        }

        for(int x = -COLS_OF_INVADERS/2; x <= COLS_OF_INVADERS/2; x++) {
            for (int y = 0; y < ROWS_OF_INVADERS; y++) {

                h.addObject(new Invader(w, x, y));

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
                h.getDefender().keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                h.getDefender().keyPressed(e);
            }
        });
        setFocusable(true);
    }

    /** initUI creates a window with a black background called Space SpaceInvaders.SpaceInvaders.Invader, which is maximized at startup */

    /* updates graphics on screen */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
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
        while (running)
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
            //h.update(g);

            // draw everyting
            //h.render(g);

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

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
    }
}
