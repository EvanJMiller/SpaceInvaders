package SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import SpaceInvaders.GameObject;
import SpaceInvaders.Window;

public class Invader extends GameObject implements Features {

    private Window w;
    private Image invader;
    int i;
    int width;
    int height;
    int pos = 0;
    int left = 0;
    int right = 1;
    double startTime;
    int yUpdated = 1;

    public Invader(Window w, int x, int y){
        this.w = w;
        setX(x);
        setY(y);
        loadImage();
        startTime = System.nanoTime();
        objectType = GameObjectType.INVADER;
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("alien.png");
        invader = ii.getImage();
    }

    public void update() {
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
                    setDy(Y_MOVE_INVADERS);
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
                    setDy(Y_MOVE_INVADERS);
                    yUpdated = 1;
                }
            }
        }

    }

    public void render(Graphics g){
        width = w.getWindowWidth() / INVADER_SPACING_X;
        height = w.getWindowHeight() / INVADER_SPACING_Y;
        g.drawImage(invader, w.getWindowWidth()/2 + getX()*width/ROWS_OF_INVADERS + pos*X_MOVE_INVADERS, 50 + getY()*height/(ROWS_OF_INVADERS) + getDy(),null);
        Toolkit.getDefaultToolkit().sync();
    }

}
