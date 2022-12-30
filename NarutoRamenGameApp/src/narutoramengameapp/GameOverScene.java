/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;


import java.awt.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author James RyzenX
 */
public class GameOverScene extends JPanel{
    
    private int playerScore;
    public GameOverScene(int playerScore, int width, int height){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.darkGray);
        this.playerScore = playerScore;
        __Init__();
       
    }
    
    private void __Init__(){
        addSpace(70);
        JLabel label = new JLabel("GAME OVER");
        label.setBounds(getWidth()/10, getHeight()/10, 250, 40);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 48));
        label.setForeground(Color.red);
        label.setAlignmentX(CENTER_ALIGNMENT);
        this.add(label);
        addSpace(40);
       
        
        JLabel label2 = new JLabel("Score: "+ playerScore);
        label2.setBounds(getWidth()/10, getHeight()/10, 250, 80);
        label2.setFont(new Font("Arial", Font.CENTER_BASELINE, 28));
        label2.setForeground(Color.white);
        label2.setAlignmentX(CENTER_ALIGNMENT);
        this.add(label2);
        
        addSpace(60);
        JButton replayBtn = new JButton("Play Again");
        replayBtn.setAlignmentX(CENTER_ALIGNMENT);
        this.add(replayBtn);
        
        addSpace(20);
        JButton homeBtn = new JButton("Go Home");
        homeBtn.setAlignmentX(CENTER_ALIGNMENT);
        this.add(homeBtn);
    }

    private void addSpace(int spaceY){
        this.add(Box.createRigidArea(new Dimension(0, spaceY)));
    }
    
}
