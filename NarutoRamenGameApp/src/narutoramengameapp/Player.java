/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.lang.Math;
import  java.util.List;

/**
 *
 * @author James RyzenX
 */
class Player extends GameObject{

    ArrayList<ImageIcon>playerSprites;
    String[] directions = {"L", "R"};
    List<GameObject> items;

    int frameSprite;
    int stepDist;
    
    int gameAction;
    boolean isMoving;
    
    private int lives;
    private int score;
    
    public Player(GameCanvas parent){
        super(parent);
        this.__Init__();
        
        
    }
    
    public Player(GameCanvas parent, int X, int Y){
        super(parent, X, Y);
        this.__Init__();
    }  
    
    @Override
    protected void __Init__(){
        this.SetUpSprites();
        this.icon =  playerSprites.get(0);
        this.img = this.icon.getImage();
        
        this.lives = 3;
        this.stepDist = 7;
        this.isMoving = false;
        this.gameAction = 0;
        parent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                gameAction = evt.getKeyCode();
                isMoving = true;
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                gameAction = 0;
                isMoving = false;
            }
        });
    }
    
    @Override
    public void Update(Graphics graphic){
        // able to move L and Right
        if(isMoving){
            if(gameAction == KeyEvent.VK_LEFT || gameAction == KeyEvent.VK_A){
               posX = Math.max(posX-stepDist, 0);
               frameSprite = (frameSprite+1)%4;
               this.img = playerSprites.get(frameSprite+0).getImage();
               
            }
            else if(gameAction == KeyEvent.VK_RIGHT || gameAction == KeyEvent.VK_D){
               posX = Math.min(posX+stepDist, parent.canvasWidth-(int)(0.14f*parent.canvasWidth));
               frameSprite = (frameSprite+1)%4;
               this.img = playerSprites.get(frameSprite+4).getImage();
               
            }
        }
        graphic.drawImage(this.img, posX, posY, parent);
    }
    
    private void SetUpSprites(){
      playerSprites = new ArrayList<>();
      for(int d = 0; d < directions.length; d++) {
            for (int f = 1; f <= 4; f++) {
                ImageIcon icon = new ImageIcon("src//Assets//Naruto//"+directions[d] + f + ".png");
                playerSprites.add(icon);
            }//loop frame to create all images in array form
        }
    
    }
    

    @Override
    public void OnDestroy(boolean isDestroyed) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void Collide(Item item){
        
        if(item.isDestoryed){
            return;
        }
        //rectangles to detect collision
        
        //rectangle for player
        Rectangle rectP=new Rectangle(this.posX,this.posY, this.img.getHeight(null),this.img.getHeight(null));
       
        //rectangle for items
        Rectangle rectI=new Rectangle(item.posX, item.posY,item.img.getWidth(null), item.img.getHeight(null));
       
        if (rectP.intersects(rectI)){ 
            //destroy item once collision occurs
            item.OnDestroy(true);
            
            if (getLives()<=0){
              lives=0;
              System.out.println("RIP");
            }
            else{
                //scores vary depending on item
                //except in kunai, where player will lose 1 life
                switch(item.tag){
                    case "egg" -> {
                        score+=5;
                    }
                    case "pork" -> {
                        score+=10;
                    }
                    case "maki" -> {
                        score+=15;
                    }
                    case "kunai" -> {
                        lives-=1;
                    }
                    default -> {
                    }
                }
            }
 
        }
    }
    
    /**
     * @return the lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

}
