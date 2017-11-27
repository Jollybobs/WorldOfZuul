/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Acquaintance.*;
import java.util.ArrayList;


public class DataFacede implements IData {
    Data data;
    @Override
    public void save(ArrayList aList) {
        data.saveGame(aList);
    }

    @Override
    public ArrayList load() {
        return data.loadGame();
    }

    @Override
    public void saveScore(ArrayList hList) {
        data.saveHighscore(hList);
    }

    @Override
    public ArrayList loadScore() {
        return data.loadHighscore();
    }
    
    
    
}
