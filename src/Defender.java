import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Defender {

    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private Game game;
    private Image defender;

    private void loadImage() {
        ImageIcon ii = new ImageIcon("player.png");
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

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y;
    }
}