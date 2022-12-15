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
/**
 *
 * @author James RyzenX
 */
class Player extends GameObject{
    GameCanvas parent;
    Image playerImg;
    ImageIcon playerIcon;
    ArrayList<ImageIcon>playerSprites;
    String[] directions = {"L", "R"};
    
    int posX;
    int posY;
    int frameSprite;
    int stepDist;
    
    int gameAction;
    boolean isMoving;
    
    
    public Player(GameCanvas parent){
        this.parent = parent;
        this.__Init__();
        
        
    }
    
    public Player(GameCanvas parent, int X, int Y){
        this.parent = parent;
        this.posX = X;
        this.posY = Y;
        this.__Init__();
    }  
    
    @Override
    protected void __Init__(){
        this.SetUpSprites();
        this.playerIcon =  playerSprites.get(0);
        this.playerImg = this.playerIcon.getImage();
        
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
               playerImg = playerSprites.get(frameSprite+0).getImage();
               
            }
            else if(gameAction == KeyEvent.VK_RIGHT || gameAction == KeyEvent.VK_D){
               posX = Math.min(posX+stepDist, parent.canvasWidth-(int)(0.14f*parent.canvasWidth));
               frameSprite = (frameSprite+1)%4;
               playerImg = playerSprites.get(frameSprite+4).getImage();
               
            }
        }
        
        graphic.drawImage(playerImg, posX, posY, null);
        
    }
    
    public void CollideWith(){
        
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
    
    public Image GetPlayerImg(){
        return playerImg;
    }
}
