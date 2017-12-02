package SpaceInvaders;

import SpaceInvaders.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    Handler(){ }

    public void update(){
        for(int i = 0; i < gameObjects.size(); i++){
            gameObjects.get(i).update();
        }
    }
    public void render(Graphics g){
        for(int i = 0; i < gameObjects.size(); i++){
            gameObjects.get(i).render(g);
        }
    }
    public void addObject(GameObject g){
        this.gameObjects.add(g);
    }
    public void removeObject(GameObject g){
        this.gameObjects.remove(g);
    }
    public Defender getDefender() {
        for(int i = 0; i < gameObjects.size(); i++){
            if(gameObjects.get(i).objectType == GameObjectType.PLAYER){
                return (Defender) gameObjects.get(i);
            }
        }
        return null;
    }
}
