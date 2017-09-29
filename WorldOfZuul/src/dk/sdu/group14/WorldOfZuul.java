/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group14;

import dk.sdu.group14.apiWrapper.GameWrapper;

/**
 *
 * @author Group14
 */
public class WorldOfZuul {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a Game object
        GameWrapper game = new GameWrapper();
        
        // Execute the game using it's play() method.
        game.play();
    }
    
}
