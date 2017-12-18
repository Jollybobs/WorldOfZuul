package starter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import acquaintance.IBusiness;
import acquaintance.IData;
import acquaintance.IUI;
import business.BusinessFacade;
import dataLayer.DataFacade;
import ui.UI;

/**
 * a Launcher for the program.
 * 
 * @author Unknown
 */
public class Starter {
     public static void main(String[] args) {
         IData Data = new DataFacade();
         IBusiness business = new BusinessFacade();
         business.play();
         IUI UI = (IUI) new UI();
         UI.injectBusiness(business);
         UI.startAplication(args);
    }
}


