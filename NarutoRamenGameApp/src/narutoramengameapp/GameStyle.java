/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author user
 */
public class GameStyle extends JPanel{
    //main text style
    public void labelStyle(JLabel label, Color fgcolor, int size, int x, int y, int width, int height){
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.PLAIN, size));
        label.setForeground(fgcolor);
        label.setAlignmentX(CENTER_ALIGNMENT);
    }
    //main button style (flat without border)
    public void buttonStyle(JButton btn, Color bgcolor, Color fgcolor, int x, int y, int width, int height){
        btn.setFont(new Font("Arial", Font.PLAIN, 20));
        btn.setBounds(x, y, width, height);
        btn.setAlignmentY(CENTER_ALIGNMENT);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(300, 50));
        btn.setForeground(fgcolor);
        btn.setBackground(bgcolor);
    }
    //official colors of the game
    public Color green=new Color(58, 89, 41);
    public Color red=new Color(214, 15, 48);
}
