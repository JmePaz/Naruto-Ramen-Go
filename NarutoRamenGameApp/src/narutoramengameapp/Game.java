/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author James RyzenX
 */
public class Game  extends JFrame{
    GameCanvas gameCanvas;
    IntroScene intro;
    
    public Game(int width, int height){
        // initalize container
        Container Pane;
        Pane = getContentPane();
        Pane.setLayout(null);
        Pane.setBackground(Color.WHITE);
        
        //set up game canvas
        gameCanvas = new GameCanvas(width, height);
        intro = new IntroScene(width, height);

        Pane.add(intro);
        
        //set window Event
        WindowEvents();
 
        //set properties
        setTitle("Naruto Ramen Go [by Maala and Paz]");
        setSize(width, height);
        setResizable(false);
    }
    private void WindowEvents(){
               //set event for closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void Show(){
        setVisible(true);
    }
}
