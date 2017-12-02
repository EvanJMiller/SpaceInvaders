package SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import SpaceInvaders.GameObject;

public class Barrier extends GameObject {

    private Window w;
    private Image barrier;
    int x;
    int y;
    int i;

    public Barrier(Window w, int x, int y, int i) {
        this.w = w;
        setX(x);
        setY(y);
        this.i = i;
        loadImage();
    }

    /** loads image of defender */
    private void loadImage() {
        ImageIcon ii = new ImageIcon("barrier.png");
        barrier = ii.getImage();
    }

    public void update(){}

    /** updates defender graphics */
    public void render(Graphics g){
        g.drawImage(barrier, w.getWindowWidth()*i/4 - x * barrier.getWidth(null), w.getWindowHeight() - barrier.getHeight(null) - 50 - y*barrier.getHeight(null),null);
        Toolkit.getDefaultToolkit().sync();
    }

}
