/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author 103020
 */
public class Data {
    protected boolean saveGame(ArrayList aList){
        
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        System.out.println(desktop.toString());
        
        String folderName = "data";
        
        File f = new File(desktop.toString(),folderName);
        f.mkdirs();
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
}
