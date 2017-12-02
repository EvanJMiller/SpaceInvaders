package SpaceInvaders;

import SpaceInvaders.GameObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Defender extends GameObject implements Features {

    int x = getX();
    int xa = getDy();
    Window w;
    Handler h;
    private Game game;
    private Image defender;
    ArrayList<Shot> shot = new ArrayList<Shot>();

    private void loadImage() {
        ImageIcon ii = new ImageIcon("defender.png");
        defender = ii.getImage();
    }

    public Defender(Window w, Handler h) {
        this.w = w;
        this.h = h;
        loadImage();
    }

    public void update(){
        if (x + xa > 0 && x + xa < w.getWindowWidth() - defender.getWidth(null))
            x = x + SPEED_OF_DEFENDER*xa;
    }
    public void render(Graphics g){
        g.drawImage(defender, x, w.getWindowHeight() - defender.getHeight(null) - 20 , null);
        Toolkit.getDefaultToolkit().sync();
        /*    for(Shot s: shot){
                if (s.y > 0) {
                    s.render(g);
                    s.update();
                } else {
                    s = null;   // dereferences shot so gc can delete it
                }
            } */
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            h.addObject(new Shot(game,x + defender.getWidth(null)/2,game.getHeight() - defender.getHeight(null) - 20));
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            xa = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            xa = 1;
        }
    }
}
