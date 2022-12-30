/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;


import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author James RyzenX
 */
public class GameCanvas extends Canvas{

    int canvasHeight;
    int canvasWidth;
    Timer timer;
    TimerTask task;
    
    public int virtualX = 100;
    public int virtualY = 40;
    
    Player player;
    List<GameObject> items;
    ItemGenerator itemGen;
    
    ImageIcon itemIcon;
    Item itemGame;
    
    //added score and lives
    public int score=0;
    public int lives=3;
    
    public GameCanvas(int width, int height){
        //initalize canvasHeight
        canvasHeight = height;
        canvasWidth = width;
        setBackground(Color.CYAN);
        
        //initialize Game Objects
        itemGen = new ItemGenerator(20);
        //REMOVE MUNA//gameObj= new Player(this, canvasWidth/2, canvasHeight-100);
        player= new Player(this, canvasWidth/2, canvasHeight-100);
        items =  itemGen.GenerateItems(this);
        
        //initialize a looping stage
        
        timer = new Timer(true);
        task = new TimerTask() {
            @Override
            public void run() {
                repaint();
               
            }//end run
        };//end task 
        
        timer.schedule(task, 500, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        //display this once game over
        if (lives<=0){
           
           //background
           Rectangle rectGO=new Rectangle(0,0,getWidth(),getHeight());
           g.setColor(Color.red);
           g.fillRect(rectGO.x, rectGO.y, rectGO.width, rectGO.height);
           
           //game over message
           g.setFont(new Font("Arial", Font.BOLD,48));
           g.drawString("GAME OVER", getWidth()/10+5, getHeight()/2);
        }
        else{
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Lives: "+lives, getWidth()/25, getHeight()/25);

            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Score: "+score, getWidth()-150, getHeight()/25);
            
            //update Game Objects//
            
            //player update  
            player.Update(g);
            //item update
            for(int i=0; i<items.size(); i++){
                GameObject item = items.get(i);

                //get icon and tag/name of respective item
                itemIcon=itemGen.selectedItemIcon;
                String tag=itemGen.colItem;

                item.Update(g);
                if(item.isDestoryed){
                    //replace that item
                    items.set(i, itemGen.GenerateSingleItem(this));
                    itemGame = new Item(this,itemIcon,tag,item.posX,item.posY);
                }

                //parameters to read item's current position
                Collide(g,item.posX,item.posY,itemIcon.getImage(),tag);
            }
        }
    }
    
    public void Collide(Graphics g,int x, int y, Image img, String tag)    {  
        
        //rectangles to detect collision
        
        //rectangle for player
        Rectangle rectP=new Rectangle(player.posX,player.posY,player.playerImg.getWidth(this),player.playerImg.getHeight(this));
       
        //rectangle for items
        Rectangle rectI=new Rectangle(x,y,img.getWidth(this),img.getHeight(this));
       
        if (rectP.intersects(rectI)){ 
            //destroy item once collision occurs
            items=null;
            items =  itemGen.GenerateItems(this);
            
            if (lives<=0){
              lives=0;
              System.out.println("RIP");
            }
            else{
                //scores vary depending on item
                //except in kunai, where player will lose 1 life
                switch(tag){
                    case "egg" -> {
                        lives-=0;
                        score+=5;
                    }
                    case "pork" -> {
                        lives-=0;
                        score+=10;
                    }
                    case "maki" -> {
                        lives-=0;
                        score+=15;
                    }
                    case "kunai" -> {
                        lives-=1;
                    }
                    default -> {
                    }
                }
            }
            //for testing
            System.out.println(tag+": "+score);
        }
        
    }
}
