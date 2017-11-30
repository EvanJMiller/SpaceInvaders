import javax.swing.*;
import java.awt.*;

public class Barrier {

    private Game game;
    private Image barrier;

    public Barrier(Game game) {
        this.game = game;
        loadImage();
    }

    /** loads image of defender */
    private void loadImage() {
        ImageIcon ii = new ImageIcon("barrier.png");
        barrier = ii.getImage();
    }

    /** updates defender graphics */
    public void paint(Graphics g){
        for(int i = 1; i < 4; i++){
            for(int x = -2; x < 2; x++){
                for(int y = 0; y < 4; y++){
                    g.drawImage(barrier, game.getWidth()*i/4 - x * barrier.getWidth(null), game.getHeight() - barrier.getHeight(null) - 50 - y*barrier.getHeight(null),null);
                }
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

}
