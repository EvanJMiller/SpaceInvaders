import javax.swing.*;
import java.awt.*;

public class Invader implements Features {

    private Game game;
    private Image invader;
    int x;
    int y;
    int dy = 0;
    int i;
    int width;
    int height;
    int pos = 0;
    int left = 0;
    int right = 1;
    double startTime;
    int yUpdated = 1;

    public Invader(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        loadImage();
        startTime = System.nanoTime();
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("alien.png");
        invader = ii.getImage();
    }

    public void move() {
        if((System.nanoTime()-startTime)/1000000 > 1000 * RATE_OF_INVADERS / 16){
            if (left == 1) {
                if(yUpdated == 1){
                    pos--;
                    if (pos == -8) {
                        left = 0;
                        right = 1;
                        yUpdated = 0;
                    }
                    startTime = System.nanoTime();
                }
                else {
                    dy += Y_MOVE_INVADERS;
                    yUpdated = 1;
                }
            }
            if (right == 1) {
                if(yUpdated == 1){
                    pos++;
                    if (pos == 8) {
                        left = 1;
                        right = 0;
                        yUpdated = 0;
                    }
                    startTime = System.nanoTime();
                }
                else {
                    dy += Y_MOVE_INVADERS;
                    yUpdated = 1;
                }
            }
        }

    }

    public void paint(Graphics g){
        width = game.getWidth() / INVADER_SPACING_X;
        height = game.getHeight() / INVADER_SPACING_Y;
        g.drawImage(invader,game.getWidth()/2 + x*width/ROWS_OF_INVADERS + pos*X_MOVE_INVADERS, 50 + y*height/(ROWS_OF_INVADERS) + dy,null);
        Toolkit.getDefaultToolkit().sync();
    }

}
