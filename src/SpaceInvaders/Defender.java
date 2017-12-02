package SpaceInvaders;

import SpaceInvaders.GameObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Defender extends GameObject {

    int x = 0;
    int xa = 0;
    private Game game;
    private Image defender;
    ArrayList<Shot> shot = new ArrayList<Shot>();

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

    public void render(Graphics g) {
        g.drawImage(defender, x, game.getHeight() - defender.getHeight(null) - 20 , null);
        Toolkit.getDefaultToolkit().sync();
    }

    public void update(){
        if (x + xa > 0 && x + xa < game.getWidth() - defender.getWidth(null))
            x = x + 2*xa;
    }
    public void paint(Graphics g){
        render(g);
            for(Shot s: shot){
                if (s.y > 0) {
                    s.paint(g);
                    s.move();
                } else {
                    s = null;   // dereferences shot so gc can delete it
                }
            }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            xa = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            shot.add(new Shot(game,x + defender.getWidth(null)/2,game.getHeight() - defender.getHeight(null) - 20));
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
