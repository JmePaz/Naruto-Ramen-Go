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
    
    Image bg;
    
    public GameCanvas(int width, int height){
        //initalize canvasHeight
        canvasHeight = height;
        canvasWidth = width;
        setBounds(0, 0, width, height);
        
        //initialize Game Objects
        itemGen = new ItemGenerator(20);
        player= new Player(this, canvasWidth/2, canvasHeight-125);
        items =  itemGen.GenerateItems(this);
        
        // for bg
        bg = Toolkit.getDefaultToolkit().getImage("src//Assets//Others//background.png");
        
        //initialize a looping stage
        timer = new Timer(true);
        task = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }//end run
        };//end task 
        
        timer.schedule(task, 100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        //place background art in canvas
        g.drawImage(bg, 0, 0, null);
        
        //end game once player loses all three lives
        if(player.getLives()<=0){
            InitatiateGameOver(g);
            return;
        }

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
            UpdatePace();
        }       
        
        //update UI
        UIindicator(g);
    }
    
    //destroy flushed items
    private void FlushItem(Item item, int index){
        if(item.isDestoryed){
            //replace that item
            items.set(index, itemGen.GenerateSingleItem(this));
        }
    }
    
    //display score and lives
    private void UIindicator(Graphics g){
        
        g.fillRect(0, 0, getWidth(), 35);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Lives: "+player.getLives(), 10, 25);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: "+player.getScore(), getWidth() - 140, 25);
    }
    
    private void InitatiateGameOver(Graphics g){
            //back to orig state
            Item.stepDist = 9;
            ItemGenerator.randYLimit = 70;
            this.score_limit = 50;
            
            // go to game over
            Container parent = this.getParent();
            parent.removeAll();
            GameOverScene gameOverScene = new GameOverScene(player.getScore(), this.canvasWidth, this.canvasHeight);
            parent.add(gameOverScene);
    }
    
    //add difficulty on the Game 
    //add item step dist every score gap
    static int SCORE_GAP = 50;
    int score_limit = 50;
    private void UpdatePace(){
        if(player.getScore()>score_limit){
            //for item speed
            Item.stepDist += 2;
            // for item gap
            ItemGenerator.randYLimit = Math.min(15, ItemGenerator.randYLimit-8);
            
            //score limit update (for next counter)
            score_limit += SCORE_GAP;
        }
    }
}
