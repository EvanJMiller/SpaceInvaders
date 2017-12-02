import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Invader implements Features {

    private Game game;
    private Image invader;
    int x;
    int y;
    int i;
    int width;
    int height;

    public Invader(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        loadImage();
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("alien.png");
        invader = ii.getImage();
    }

    public void paint(Graphics g){
        width = game.getWidth() / 4;
        height = game.getHeight() / 4;
        g.drawImage(invader,width + x*width/ROWS_OF_INVADERS, 50 + y*height/(ROWS_OF_INVADERS),null);
        Toolkit.getDefaultToolkit().sync();
    }

}
