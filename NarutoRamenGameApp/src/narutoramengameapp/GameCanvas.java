/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;


import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;

/**
 *
 * @author James RyzenX
 */
public class GameCanvas extends Canvas{

    int canvasHeight;
    int canvasWidth;
    Timer timer;
    TimerTask task;
    
    Player player;
    
    public GameCanvas(int width, int height){
        //initalize canvasHeight
        canvasHeight = height;
        canvasWidth = width;
        
        //initialize Game Objects
        player = new Player(this,canvasWidth/2, canvasHeight-100);
        
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
        player.Update(g);
    }
    
    
    
    
}
