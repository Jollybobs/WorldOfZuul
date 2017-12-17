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
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import static javax.imageio.ImageIO.getCacheDirectory;

/**
 *
 * @author 103020
 */
public class Data {
    /**
     * saves the game with serializable
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
        System.out.println(System.getProperty("os.name"));
        try {
            FileOutputStream fileOut;
            if ((System.getProperty("os.name").substring(0, 7)).equals("Windows")) {
                fileOut = new FileOutputStream(filePath + "\\data.ser");
            } else {
                fileOut = new FileOutputStream(filePath + "/data.ser");
            }
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
        
        try {
            FileInputStream fileIn;
            if ((System.getProperty("os.name").substring(0, 7)).equals("Windows")) {
                fileIn = new FileInputStream(desktop + "\\data\\data.ser");
            } else {
                fileIn = new FileInputStream(desktop + "/data/data.ser");
            }
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
    
    /**
     * saves the game with serializable
     * @param aList it saves an ArrayList
     * @return returns true if it saved or false if it could not save
     */
    protected boolean saveMap(HashMap aMap) {
        
        File file;
        if ((System.getProperty("os.name").substring(0, 7)).equals("Windows")) {
                file = new File("src\\resources", "newfile.ser");
            } else {
                file = new File("src/resources/newfile.ser");
            }
        
        if(!file.exists()){
            try {
//                            file.mkdirs();
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(aMap);
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
    protected HashMap loadMap(){
        HashMap<String, String> aMap = new HashMap<>();
        File file;
        if ((System.getProperty("os.name").substring(0, 7)).equals("Windows")) {
                file = new File("src\\resources", "newfile.ser");
            } else {
                file = new File("src/resources/newfile.ser");
            }
        
        try {
           FileInputStream fileIn = new FileInputStream(file);
           ObjectInputStream in = new ObjectInputStream(fileIn);
           Object temp = in.readObject();
            if (temp instanceof HashMap) {
                aMap = (HashMap) temp;
            }
           in.close();
           fileIn.close();
           return aMap;
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
            FileOutputStream fileOut;
            if ((System.getProperty("os.name").substring(0, 7)).equals("Windows")) {
                fileOut = new FileOutputStream(filePath + "\\high.ser");
            } else {
                fileOut = new FileOutputStream(filePath + "/high.ser");
            }
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
        
        String folderName = "data";
        
        File filePath = new File(desktop.toString(),folderName);
       
        if(!filePath.exists()){ //a defalt list if a list do not exist to begin with
            filePath.mkdirs();
            ArrayList hList = new ArrayList();
            hList.add("Bob");
            hList.add(1);
            hList.add("Jack");
            hList.add(3);
            hList.add("John");
            hList.add(5);
            hList.add("Tim");
            hList.add(7);
            hList.add("Tom");
            hList.add(10);
            saveHighscore(hList);
        }
        
        
        try {
            FileInputStream fileIn;
            if ((System.getProperty("os.name").substring(0, 7)).equals("Windows")) {
                fileIn = new FileInputStream(desktop + "\\data\\high.ser");
            } else {
                fileIn = new FileInputStream(desktop + "/data/high.ser");
            }
            //FileInputStream fileIn = new FileInputStream(desktop + "\\data\\high.ser");
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
