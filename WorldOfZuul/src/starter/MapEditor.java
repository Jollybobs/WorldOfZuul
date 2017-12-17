package starter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import acquaintance.IUI;
import acquaintance.IBusiness;
import acquaintance.IData;
import business.BusinessFacede;
import dataLayer.DataFacede;
import ui.mapEditors.EditorUI;

/**
 *
 * @author Jonathan
 */
public class MapEditor {
     public static void main(String[] args) {
         IData Data = new DataFacede();
         IBusiness business = new BusinessFacede();
         business.injectData(Data);
          
         IUI UI = (IUI) new EditorUI();
         UI.injectBusiness(business);
         UI.startAplication(args);
    }
}
