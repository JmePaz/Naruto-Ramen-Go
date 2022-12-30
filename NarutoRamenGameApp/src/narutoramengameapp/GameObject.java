/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;

import java.awt.Graphics;

/**
 *
 * @author James RyzenX
 */
abstract class GameObject {
    public GameCanvas parent;
    public int posX;
    public int posY;
    public boolean isDestoryed;
    
    protected GameObject(GameCanvas parent){
        this.parent = parent;
        this.isDestoryed = false;
    }
    
    protected GameObject(GameCanvas parent, int posX, int posY){
        this.parent = parent;
        this.posX = posX;
        this.posY = posY;
        this.isDestoryed = false;
    }
    
    protected abstract void __Init__();
    public abstract void Update(Graphics graphic);
    public abstract void OnDestroy(boolean isDestroyed);
    
}
