/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;


import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;
import java.util.ArrayList;
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
    
    GameObject player;
    List<GameObject> items;
    ItemGenerator itemGen;
    
    public GameCanvas(int width, int height){
        //initalize canvasHeight
        canvasHeight = height;
        canvasWidth = width;
        setBackground(Color.darkGray);
        
        //initialize Game Objects
        itemGen = new ItemGenerator(20);
        player = new Player(this, canvasWidth/2, canvasHeight-100);
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
       
        //update Game Objects
        //player update
        player.Update(g);
        
        //item update
        for(int i=0; i<items.size(); i++){
            GameObject item = items.get(i);
            item.Update(g);
            if(item.isDestoryed){
                //replace that item
                items.set(i, itemGen.GenerateSingleItem(this));
            }
          
        }
    }
    
    
    
    
}
