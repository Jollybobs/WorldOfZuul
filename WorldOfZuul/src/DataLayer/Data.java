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
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author 103020
 */
public class Data {
    protected boolean saveGame(ArrayList aList){
        
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        //System.out.println(desktop.toString());
        
        String folderName = "data";
        
        File f = new File(desktop.toString(),folderName);
        
        if(!f.exists()){
            f.mkdirs();
        }
        
        try {
            FileOutputStream fileOut = new FileOutputStream(desktop + "\\" + folderName + "\\data.ser");
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
    protected ArrayList loadGame(){
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
    protected boolean saveHighscore(ArrayList aList){
        
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        //System.out.println(desktop.toString());
        
        String folderName = "data";
        
        File f = new File(desktop.toString(),folderName);
       
        if(!f.exists()){
            f.mkdirs();
        }
        
        try {
            FileOutputStream fileOut = new FileOutputStream(desktop.toString() + "\\" + folderName + "\\high.ser");
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
    protected ArrayList loadHighscore(){
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
