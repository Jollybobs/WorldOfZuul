/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.*;

/**
 *
 * @author Bruger
 */
public class BusinessFacede implements IBusiness {

    @Override
    public void PrintTest(String input) {
        System.out.println("WORKS"+input);
    }

  
    IData data;
    public void InjectData(IData Data) {
        this.data=data;
    }
    
}
