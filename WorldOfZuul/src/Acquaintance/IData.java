/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.ArrayList;

/**
 *
 * @author Bruger
 */
public interface IData {
    
    void save(ArrayList aList);
    ArrayList load();
    void saveScore(ArrayList hList);
    ArrayList loadScore();
}
