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
    String[]itemProps;
    List<GameObject> items;
    GameObject lastItem;
    
    public ItemGenerator(int Nlimit){
        this.Nlimit = Nlimit;
        random = new Random();
        itemProps = new String[] {"candy", "egg", "maki", "pork"};
    }
    
    public List<GameObject> GenerateItems(GameCanvas parent){
        items = new ArrayList<>();
        int randY = 0;
        for(int i=0; i<Nlimit; i++){
            String selectedItem = SelectItem();
            ImageIcon selectedItemIcon = new ImageIcon("src//Assets//Items//"+selectedItem+".png");
            
            int randX = random.nextInt(parent.canvasWidth-(int)(parent.canvasWidth*0.14));
            randY -= random.nextInt(50) + 70;
            GameObject item = new Item(parent,selectedItemIcon, selectedItem, randX, randY );
            lastItem = item;
            items.add(item);
        }
        return items;
    }
    private String SelectItem(){
        int randNum = random.nextInt(9) + 1;
        if(randNum<=6){
            return "kunai";
        }
        
        return itemProps[randNum%4];
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
          String selectedItem =  SelectItem();
          ImageIcon selectedItemIcon = new ImageIcon("src//Assets//Items//"+selectedItem+".png");
          GameObject item = new Item(parent,selectedItemIcon, selectedItem, randX, randY );
          lastItem = item;
          //returning item
          return item;
    }
}
