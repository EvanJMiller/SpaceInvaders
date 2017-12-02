import javax.swing.*;
import java.awt.*;

public class Shot implements Features{

    private Game game;
    private Image shot;

    public int x;
    public int y;
    public int ya = -SPEED_OF_SHOT;

    public Shot(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
        loadImage();
    }

    /** loads image of defender */
    private void loadImage() {
        ImageIcon ii = new ImageIcon("shot.png");
        shot = ii.getImage();
    }

    public void move(){
        y = y + ya;
    }

    /** updates defender graphics */
    public void paint(Graphics g){
        g.drawImage(shot,x,y,null);
        Toolkit.getDefaultToolkit().sync();
    }
}
