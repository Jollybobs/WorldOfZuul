/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.List;

/**
 *
 * @author 103020
 */
public interface IData {
    
    boolean save(List aList);
    List load();
    boolean saveScore(List hList);
    List loadScore();
}
