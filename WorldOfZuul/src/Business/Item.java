package Business;


public class Item {
 private String name; 
 private int size; 

 
 
//CONSTRUCTOR 
 public Item (String name, int Size){
 this.name=name;
 this.size=Size;}
 public Item(){}
  
 /**
 returns the size(int) that the item will take up in the inventory
 */
 public int getSize(){
 return this.size;} //Nemmere at se
    
 /**
 returns items name(String)
 */
 public String getName(){
 return this.name;}
 
}//c-Item

//C-KEY
class key extends Item{
 private final int itemID; 

/**
 * 
 * @param name
 * @param Size
 * @param itemID 
 */
public key(String name, int Size,int itemID){
super (name, Size);
this.itemID=itemID;
}//key no args -constructor

/**
return the items ID witch is used to find a specific item.
itemID is final and is defined when the constructor is called
*/
public int getItemID(){
return this.itemID;}
}//c-key
