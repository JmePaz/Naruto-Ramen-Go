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
/**
 *
 * @author James RyzenX
 */
class Player {
    GameCanvas parent;
    Image playerImg;
    ImageIcon playerIcon;
    ArrayList<ImageIcon>playerSprites;
    String[] directions = {"L", "R"};
    
    int posX;
    int posY;
    int frame;
    float speed;
    
    int gameAction;
    boolean isMoving;
    
    
    public Player(GameCanvas parent){
        this.parent = parent;
        this.__Init();
        
        
    }
    
    public Player(GameCanvas parent, int X, int Y){
        this.parent = parent;
        this.posX = X;
        this.posY = Y;
        this.__Init();
    }  
    
    
    private void __Init(){
        this.SetUpSprites();
        this.playerIcon =  playerSprites.get(0);
        this.playerImg = this.playerIcon.getImage();
        
        this.speed = 4.5f;
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
    
    public void Update(Graphics graphic){
        if(isMoving){
            if(gameAction == KeyEvent.VK_LEFT || gameAction == KeyEvent.VK_A){
               posX = (posX-15);
               frame = (frame+1)%4;
               playerImg = playerSprites.get(frame+0).getImage();
               
                System.out.println("At X: "+ posX);
            }
            else if(gameAction == KeyEvent.VK_RIGHT || gameAction == KeyEvent.VK_D){
               posX = (posX+15);
               frame = (frame+1)%4;
               playerImg = playerSprites.get(frame+4).getImage();
               
               System.out.println("At X: "+ posX);
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
