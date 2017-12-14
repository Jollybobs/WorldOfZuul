/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IUI;
import Business.BusinessFacede;
import DataLayer.DataFacede;
import UI.UI;

/**
 *
 * @author Unknown
 */
public class Starter {
     public static void main(String[] args) {
         IData Data = new DataFacede();
         IBusiness business = new BusinessFacede();
          business.injectData(Data);
          business.play();
          
         IUI UI = (IUI) new UI();
         UI.injectBusiness(business);
         UI.startAplication(args);
    }
}


