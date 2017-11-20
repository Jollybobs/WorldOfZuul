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
import UI.FXMLDocumentController;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import UI.UI;

/**
 *
 * @author Unknown
 */
public class Starter {
     public static void main(String[] args) {
         IData Data = new DataFacede();
         IBusiness business = new BusinessFacede();
          business.InjectData(Data);
          
         IUI UI = (IUI) new UI();
         UI.InjectBusiness(business);
         UI.StartAplication(args);
       
     
         
    
    }
}


