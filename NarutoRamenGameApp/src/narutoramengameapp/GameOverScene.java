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
    
   JButton homeBtn;

    private int playerScore;

    public GameOverScene(int playerScore, int width, int height){
        this.setBounds(0, 0, width, height);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        this.playerScore = playerScore;
        __Init__();
       
    }
    
    private void __Init__(){
        //styling for game over scene
        GameStyle gameOverStyle = new GameStyle();
        
        //"GAME OVER" written
        JLabel label = new JLabel("GAME OVER");
        gameOverStyle.labelStyle(label, gameOverStyle.red, 40, getWidth()/5, getHeight()/10, 350, 40);
        this.add(label);
       
        //display obtained points
        JLabel label2 = new JLabel("You got "+ playerScore + " points!");
        gameOverStyle.labelStyle(label2, Color.BLACK, 25, getWidth()/5, getHeight()/7, 350, 80);
        this.add(label2);
        
        //button to play again
        JButton replayBtn = new JButton("Play Again");
        gameOverStyle.buttonStyle(replayBtn, gameOverStyle.green, Color.WHITE,getWidth()/4, getHeight()/3, 200, 50);
        replayBtn.addActionListener(e->goToGame());
        this.add(replayBtn);
        
        //button to go back to home/intro scene
        homeBtn = new JButton("Go Home");
        gameOverStyle.buttonStyle(homeBtn, gameOverStyle.red, Color.WHITE,getWidth()/4, getHeight()/3+replayBtn.getHeight()+20, 200, 50);
        homeBtn.addActionListener(e->goToIntro());
        this.add(homeBtn);
    }

    private void addSpace(int spaceY){
        this.add(Box.createRigidArea(new Dimension(0, spaceY)));
    }
    
    private void goToGame(){
        this.setVisible(false);
        Container parent = this.getParent();
        parent.remove(0);
        parent.add(new GameCanvas(getWidth(), getHeight()));
        parent.revalidate();
    }
    
    private void goToIntro(){
        Container parent = this.getParent();
        parent.remove(0);
        parent.add(new IntroScene(getWidth(), getHeight()));
        homeBtn.revalidate();
        parent.revalidate();
     
    }
    
}
