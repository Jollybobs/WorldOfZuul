/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.group14.apiWrapper;

import Business.Game;

/**
 *
 * @author jollybob
 */
public class GameWrapper {
    Game aGame = new Game();

    public void play() 
    {            
        aGame.play();
    }
}
