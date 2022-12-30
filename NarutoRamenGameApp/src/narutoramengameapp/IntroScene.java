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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author James RyzenX
 */
public class IntroScene extends JPanel{
    public IntroScene(int width, int height){
        setBackground(Color.darkGray);
        setBounds(0, 0, width, height);
        __Init__();
        
    }
    
    private void __Init__(){
        addSpace(200);
        JLabel label = new JLabel("Naruto Ramen GO!");
        label.setBounds(getWidth()/5, getHeight()/10, 250, 40);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 38));
        label.setForeground(Color.white);
        label.setAlignmentX(CENTER_ALIGNMENT);
        this.add(label);
        
        addSpace(40);
        JButton replayBtn = new JButton("Start Game");
        replayBtn.setBounds(getWidth()/3, getHeight()/3, 100, 30);
        replayBtn.setAlignmentX(CENTER_ALIGNMENT);
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
    
     private void addSpace(int spaceY){
        this.add(Box.createRigidArea(new Dimension(0, spaceY)));
    }
}
