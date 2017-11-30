import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Defender {

    int x = 0;
    int xa = 0;
    private Game game;
    private Image defender;

    private void loadImage() {
        ImageIcon ii = new ImageIcon("defender.png");
        defender = ii.getImage();
    }

    public Defender(Game game) {
        this.game = game;
        loadImage();
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - defender.getWidth(null))
            x = x + 2*xa;
    }


    private void drawDefender(Graphics g) {
        g.drawImage(defender, x, game.getHeight() - defender.getHeight(null) - 20 , null);
        Toolkit.getDefaultToolkit().sync();
    }

    public void paint(Graphics g){
        drawDefender(g);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
    }
}
