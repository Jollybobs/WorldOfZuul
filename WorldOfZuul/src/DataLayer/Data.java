/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 103020
 */
public class Data {
    /**
     * saves the game with serializabel
     * @param aList it saves an ArrayList
     * @return returns true if it saved or false if it could not save
     */
    protected boolean saveGame(List aList){
        
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        //System.out.println(desktop.toString());
        
        String folderName = "data";
        
        File filePath = new File(desktop.toString(),folderName);
        
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath + "\\data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(aList);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
        }
        return false;
    }
    /**
     * load a serialized file from memory
     * @return the loaded ArrayList loaded from the file
     */
    protected List loadGame(){
        ArrayList aList = new ArrayList();
        
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        //System.out.println(desktop.toString());
        
        try {
           FileInputStream fileIn = new FileInputStream(desktop + "\\data\\data.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           Object temp = in.readObject();
            if (temp instanceof ArrayList) {
                aList = (ArrayList) temp;
            }
           in.close();
           fileIn.close();
           return aList;
        } catch (IOException i) {
           i.printStackTrace();
        } catch (ClassNotFoundException c) {
           c.printStackTrace();
        }
        return null;
    }
    //TODO: mayby to be removed
    /**
     * saves the highscore
     * @param aList the ArrayList with the highscore
     * @return true if saved and false if it faild
     */
    protected boolean saveHighscore(List aList){
        
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        //System.out.println(desktop.toString());
        
        String folderName = "data";
        
        File filePath = new File(desktop.toString(),folderName);
       
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath + "\\high.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(aList);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
        }
        return false;
    }
    /**
     * loads the highscore
     * @return the ArrayList with the highscore that it read from the file
     */
    protected List loadHighscore(){
        ArrayList aList = new ArrayList();
        
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        //System.out.println(desktop.toString());
        
        try {
           FileInputStream fileIn = new FileInputStream(desktop + "\\data\\high.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           Object temp = in.readObject();
            if (temp instanceof ArrayList) {
                aList = (ArrayList) temp;
            }
           in.close();
           fileIn.close();
           return aList;
        } catch (IOException i) {
           i.printStackTrace();
        } catch (ClassNotFoundException c) {
           c.printStackTrace();
        }
        return null;
    }
}
