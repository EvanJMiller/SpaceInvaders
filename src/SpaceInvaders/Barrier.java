package SpaceInvaders;

import javax.swing.*;
import java.awt.*;

public class Barrier {

    private Game game;
    private Image barrier;
    int x;
    int y;
    int i;

    public Barrier(Game game, int x, int y, int i) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.i = i;
        loadImage();
    }

    /** loads image of defender */
    private void loadImage() {
        ImageIcon ii = new ImageIcon("barrier.png");
        barrier = ii.getImage();
    }

    /** updates defender graphics */
    public void paint(Graphics g){
        g.drawImage(barrier, game.getWidth()*i/4 - x * barrier.getWidth(null), game.getHeight() - barrier.getHeight(null) - 50 - y*barrier.getHeight(null),null);
        Toolkit.getDefaultToolkit().sync();
    }

}
