package SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import SpaceInvaders.GameObject;

public class Shot extends GameObject implements Features{

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

    public void update(){
        y = y + ya;
    }

    /** updates defender graphics */
    public void render(Graphics g){
        g.drawImage(shot,x,y,null);
        Toolkit.getDefaultToolkit().sync();
    }
}
