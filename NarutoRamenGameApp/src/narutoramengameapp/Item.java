/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author James RyzenX
 */
public class Item extends GameObject{

    String tag;
    
    int stepDist;
    //added rectangle for collision detection
    Rectangle rectI;
    
   
    
    public Item(GameCanvas parent, ImageIcon itemIcon, String tag){
        super(parent);
        this.parent = parent;
        this.icon = itemIcon;
        this.tag = tag;        
        this.__Init__();
    }
    
     public Item(GameCanvas parent, ImageIcon itemIcon, String tag, int posX, int posY){
        super(parent, posX, posY);
        this.icon = itemIcon;
        this.tag = tag;
        this.__Init__();
    }
    
    
    @Override
    protected void __Init__() {
        this.stepDist = 9;
        this.img = this.icon.getImage();
        //added rectangle for collision detection
        //placed here so it can be used outside
        this.rectI=new Rectangle (posX, posY, this.img.getWidth(parent),this.img.getHeight(parent));
    }

    @Override
    public void Update(Graphics graphic) {
        if(posY<=parent.canvasHeight){
            posY += stepDist;
            graphic.drawImage(this.img, posX, posY, parent);
                
        }
        else{
            //remove this
            //parent.itemGen.removeAndRegen(parent, this);
            this.OnDestroy(true);
        }
    }

    
   public String GetTag(){
       return this.tag;
   }

    @Override
    public void OnDestroy(boolean isDestroyed) {
        this.isDestoryed = true;
        this.icon = null;
        this.img = null;
    }
}
