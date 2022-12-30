/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
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
        this.setBounds(0, 0, width, height);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.darkGray);
        this.playerScore = playerScore;
        __Init__();
       
    }
    
    private void __Init__(){
        JLabel label = new JLabel("GAME OVER");
        label.setBounds(getWidth()/5, getHeight()/10, 250, 40);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 38));
        label.setForeground(Color.red);
        label.setAlignmentX(CENTER_ALIGNMENT);
        this.add(label);
       
        
        JLabel label2 = new JLabel("Score: "+ playerScore);
        label2.setBounds(getWidth()/3, getHeight()/7, 250, 80);
        label2.setFont(new Font("Arial", Font.CENTER_BASELINE, 28));
        label2.setForeground(Color.white);
        label2.setAlignmentX(CENTER_ALIGNMENT);
        this.add(label2);
        
        JButton replayBtn = new JButton("Play Again");
        replayBtn.setBounds(getWidth()/3, getHeight()/3, 100, 30);
        replayBtn.setAlignmentX(CENTER_ALIGNMENT);
        replayBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              GoToGame();
            }
            
        });
        
        this.add(replayBtn);
        
        JButton homeBtn = new JButton("Go Home");
        homeBtn.setBounds(getWidth()/3, getHeight()/3+replayBtn.getHeight()+20, 100, 30);
        homeBtn.setAlignmentX(CENTER_ALIGNMENT);
        this.add(homeBtn);
    }

    private void addSpace(int spaceY){
        this.add(Box.createRigidArea(new Dimension(0, spaceY)));
    }
    
    private void GoToGame(){
        Container parent = this.getParent();
        parent.remove(0);
        parent.add(new GameCanvas(getWidth(), getHeight()));
    }
    
}
