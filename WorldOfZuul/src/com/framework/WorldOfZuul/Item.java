package com.framework.WorldOfZuul;


public class Item {
 private String name; //items navn
 private int size; //størelsen itemet har (lige nu er der plads til 1 "size" i en tom inventory)

 /*METHODS contained in inventory 
-getSize
-getName
-getItemID */
 
//CONSTRUCTOR 
 public Item (String name, int Size){
 this.name=name;
 this.size=Size;}
 public Item(){}
  
 //METHODS
 public int getSize(){
 return this.size;} //Nemmere at se
    
 public String getName(){
 return this.name;}
 
}//c-Item

//C-KEY
class key extends Item{
 private final int itemID; 

//CONSTRUCTOR
public key(String name, int Size,int itemID){
super (name, Size);
this.itemID=itemID;
}//key no args -constructor

public int getItemID(){
return this.itemID;}
}//c-key
