package starter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import acquaintance.IUI;
import acquaintance.IBusiness;
import acquaintance.IData;
import business.BusinessFacade;
import dataLayer.DataFacade;
import ui.mapEditorTool.EditorUI;

/**
 * a Mapeditor, not part of this program but an external tool to ease map creation.
 * 
 * @author Jonathan
 */
public class MapEditor {
     public static void main(String[] args) {
         IData Data = new DataFacade();
         IBusiness business = new BusinessFacade();
         IUI UI = (IUI) new EditorUI();
         UI.injectBusiness(business);
         UI.startAplication(args);
    }
}
