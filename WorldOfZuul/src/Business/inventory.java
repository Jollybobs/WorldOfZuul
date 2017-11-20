
package Business;
import Business.Item;
import java.util.ArrayList;
public class inventory {
    
    //the only time the inventroy size is definable is in the constructor (if this ability is need add a setFreeSpace method)
    
//DEF. VAR.
    private int FreeSpace=1;//ledig plads i inventory
   ArrayList<Item> inventory= new ArrayList<Item>();
   
   //CONSTRUCTOR
   public inventory(){} 
   public inventory(int FreeSpace){this.FreeSpace=FreeSpace;} 
   
/*METHODS contained in inventory 
-addItem
-dropItem  
-PrintInventory   
-checkFor 
-checkEmpty */
   
    //ADD ITEM
   //Checks the variabel Freespace, adds an Item to the ArrayList inventory.
   //prints outcome on consol display
    public void addItem(Item item){
    if (item.getSize()>0){
        if(item.getSize()<=FreeSpace){
    inventory.add(item);
    FreeSpace-=item.getSize();
    //sout Item pick up
        System.out.println("you picked up a "+item.getName()+"!");
    }//if getsize<=FreeSpace
         else{
        System.out.println("your inventory doesn't have space");
        }//if getsize>0 false
    }//if getsize>0    
    else{
        System.out.println("your inventory doesn't have space");
    }//else getsize<=freeSpace false
    }//m-addItem
    
    //DROP ITEM
    //romves Item from ArrayList inventory & and adds the items size back to FreeSpace
     public void dropItem(Item item){
    inventory.remove(item);
    FreeSpace+=item.getSize();
        System.out.println("you dropped"+item);
    }//m-addItem 
    
     //PRINT INVENTORY
     //prints ArrayList inventory
   public void PrintInventory(){
       System.out.println("you inventory contains:");
       for (Item item : inventory){
           System.out.println(item.getName());
       }//for print
     
       }//PrintInventory
   
   //CHECK FOR ITEM
   //check for .containts on ArrayList inventory
   public boolean checkFor(Item item){
    boolean result=false;
   if(inventory.contains(item)){
    result=true;
    }//if contains
   return result;
   }//m-checkFor
   
   //CHECK EMPTY
   //check if the inventory contains anything (returns true if inventory is empty)
   public boolean checkEmpty(){
   boolean result=false;
       if (inventory.isEmpty()) {
           result=true;
       }//if .isempty= true result=true
   return result;}//m-checkEmpty
         
    
}//c-inventory
