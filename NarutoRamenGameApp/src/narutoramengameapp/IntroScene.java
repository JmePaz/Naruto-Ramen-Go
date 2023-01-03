/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author James RyzenX
 */
public class IntroScene extends JPanel{
    public IntroScene(int width, int height){
        setBackground(Color.WHITE);
        setBounds(0, 0, width, height);
        __Init__();
        
    }
    
    private void __Init__(){
        //place game logo
        addSpace(85, 250);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("src//Assets//Others//logo.png"));
        logo.setBounds(0, getHeight()/10, 0, 50); 
        this.add(logo);
        
        //styling for intro scene
        GameStyle introStyle=new GameStyle();
        
        //written game instructions
        addSpace(100, 0);
        JLabel instructions = new JLabel("HOW TO PLAY");
        introStyle.labelStyle(instructions, Color.BLACK, 20, 0, getHeight()/30, 0, 50);
        this.add(instructions);
        
        addSpace(0, 0);
        JLabel instructions1 = new JLabel("1. Use left and right keys to move Naruto.");
        introStyle.labelStyle(instructions1, Color.BLACK, 16, getWidth()/5, getHeight()/100, 350, 40);
        this.add(instructions1);
        
        addSpace(0, 50);
        JLabel instructions2 = new JLabel("2. Get egg, pork, and narutomaki for points.");
        introStyle.labelStyle(instructions2, Color.BLACK, 16, getWidth()/5, getHeight()/100, 350, 40);
        this.add(instructions2);
        
        addSpace(0, 0);
        JLabel instructions3 = new JLabel("3. Avoid ninja knives/kunai to survive.");
        introStyle.labelStyle(instructions3, Color.BLACK, 16, getWidth()/5, getHeight()/100, 350, 40);
        instructions3.setAlignmentY(LEFT_ALIGNMENT);
        this.add(instructions3);
        
        //button to start the game
        addSpace(0, 50);
        JButton replayBtn = new JButton("Start Game");
        introStyle.buttonStyle(replayBtn, introStyle.green, Color.WHITE, getWidth()/3, getHeight()/3, 100, 50);
        replayBtn.addActionListener(e->goToGame());  
        this.add(replayBtn);
    }
    
    private void goToGame(){
        this.setVisible(false);
        Container parent = this.getParent();
        parent.remove(0);
        parent.revalidate();
        parent.add(new GameCanvas(getWidth(), getHeight()));
    }
    
    private void addSpace(int spaceX, int spaceY){
        this.add(Box.createRigidArea(new Dimension(spaceX, spaceY)));
    }
     
     
}
