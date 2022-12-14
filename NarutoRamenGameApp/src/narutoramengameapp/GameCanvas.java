/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;


import java.awt.*;
import javax.swing.*;

/**
 *
 * @author James RyzenX
 */
public class GameCanvas extends Canvas{
    Image naruto;
    ImageIcon narutoIcon;
    public GameCanvas(){
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        narutoIcon = new ImageIcon("Assets//Naruto//L1.png");
        naruto = narutoIcon.getImage();
        
        g.drawImage(naruto, 100, 40, this);
    }
    
    
    
}
