/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package narutoramengameapp;

/**
 *
 * @author James RyzenX
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

public class ItemGenerator {
    Random random;
    int Nlimit;
    List<GameObject> items;
    GameObject lastItem;
    
    public ItemGenerator(int Nlimit){
        this.Nlimit = Nlimit;
        random = new Random();
    }
    
    public List<GameObject> GenerateItems(GameCanvas parent){
        items = new ArrayList<>();
        ImageIcon kunai = new ImageIcon("src//Assets//TempItems//kunai.png");
        int randY = 0;
        for(int i=0; i<Nlimit; i++){
            int randX = random.nextInt(parent.canvasWidth-(int)(parent.canvasWidth*0.14));
            randY -= random.nextInt(50) + 70;
            GameObject item = new Item(parent,kunai, "Obstacle", randX, randY );
            lastItem = item;
            items.add(item);
        }
        return items;
    }
    
    
    //remove an index and generate another object
    public GameObject GenerateSingleItem(GameCanvas parent){
          //generate items
          //initializing positions
          int randX = random.nextInt(parent.canvasWidth-(int)(parent.canvasWidth*0.14));
          int randY = random.nextInt(50) + 70;
          if(lastItem != null && !lastItem.isDestoryed){
              randY = lastItem.posY - randY;
          }
          else{
              randY = -randY;
          }
          //generating item
          ImageIcon kunai = new ImageIcon("src//Assets//TempItems//kunai.png");
          GameObject item = new Item(parent,kunai, "Obstacle", randX, randY );
          lastItem = item;
          //returning item
          return item;
    }
}
