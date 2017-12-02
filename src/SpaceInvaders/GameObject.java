package SpaceInvaders;

import java.awt.*;
import SpaceInvaders.GameObjectType;

public abstract class GameObject {

    private int x, y;
    private int dx, dy;
    public GameObjectType objectType;

    public GameObject(){
        this.x = 0;
        this.y = 0;
    }
    public GameObject(int x, int y, GameObjectType objectType){
        this.x = x;
        this.y = y;
        this.objectType = objectType;
    }
    public abstract void update();
    public abstract void render(Graphics g);
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getDy(){
        return this.dy;
    }
    public int getDx(){
        return this.dx;
    }
    public GameObjectType getObjectType(){
        return this.getObjectType();
    }

}
