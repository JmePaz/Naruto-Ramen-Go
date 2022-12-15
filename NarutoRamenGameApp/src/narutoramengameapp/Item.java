/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author James RyzenX
 */
public class Item extends GameObject{
    ImageIcon itemIcon;
    Image itemImg;
    String tag;
    
    int stepDist;
    
    public Item(GameCanvas parent, ImageIcon itemIcon, String tag){
        super(parent);
        this.parent = parent;
        this.itemIcon = itemIcon;
        this.tag = tag;        
        this.__Init__();
    }
    
     public Item(GameCanvas parent, ImageIcon itemIcon, String tag, int posX, int posY){
        super(parent, posX, posY);
        this.itemIcon = itemIcon;
        this.tag = tag;
        this.__Init__();
    }
    
    
    @Override
    protected void __Init__() {
        this.stepDist = 9;
        this.itemImg = itemIcon.getImage();
    }

    @Override
    public void Update(Graphics graphic) {
        if(posY<=parent.canvasHeight){
            posY += stepDist;
            graphic.drawImage(itemImg, posX, posY, null);
        }
        else{
            //remove this
            //parent.itemGen.removeAndRegen(parent, this);
            this.isDestoryed = true;
        }
    }
   
}
