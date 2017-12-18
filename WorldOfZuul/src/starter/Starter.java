package starter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import acquaintance.IBusiness;
import acquaintance.IData;
import acquaintance.IUI;
import business.BusinessFacede;
import dataLayer.DataFacede;
import ui.UI;

/**
 *
 * @author Unknown
 */
public class Starter {
     public static void main(String[] args) {
         IData Data = new DataFacede();
         IBusiness business = new BusinessFacede();
         business.play();
         IUI UI = (IUI) new UI();
         UI.injectBusiness(business);
         UI.startAplication(args);
    }
}


