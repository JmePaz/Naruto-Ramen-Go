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
    List<Item> items;
    ItemGenerator itemGen;
    
    ImageIcon itemIcon;
    Item itemGame;
    
    
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
        
        if(player.lives<=0){
            InitatiateGameOver(g);
            return;
        }

        // UI
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Lives: "+player.lives, getWidth()/25, getHeight()/25);

        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: "+player.score, getWidth()-150, getHeight()/25);

        //update Game Objects//

        //player update  
        player.Update(g);
        //item update
        for(int i=0; i<items.size(); i++){
            Item item = items.get(i);
            //get icon and tag/name of respective item
            String tag =  item.GetTag();

            item.Update(g);
            FlushItem(item, i);
    
            //player on collision with the item
            player.Collide(item);
            FlushItem(item, i);
         }       
    }
    
    // destroy flushed items
    private void FlushItem(Item item, int index){
        if(item.isDestoryed){
            //replace that item
            items.set(index, itemGen.GenerateSingleItem(this));

        }
    }
    
    private void InitatiateGameOver(Graphics g){
           //background
           Rectangle rectGO=new Rectangle(0,0,getWidth(),getHeight());
           g.setColor(Color.black);
           g.fillRect(rectGO.x, rectGO.y, rectGO.width, rectGO.height);
           
           //game over message
           g.setFont(new Font("Arial", Font.BOLD,48));
           g.setColor(Color.red);
           g.drawString("GAME OVER", getWidth()/10+5, getHeight()/2);
    }
    
}
