/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import acquaintance.IBusiness;
import acquaintance.IUI;
import business.BusinessFacede;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;

/**
 *
 * @author paul
 */
public class UI extends Application implements IUI {

    static IBusiness business;
    static BusinessFacede businessFacade;
    static UI ui;
    static Stage aStage;
    static Scene rootScene; 
    static Scene gameScene;
            
    /**
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        aStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        rootScene = new Scene(root);
        
//        TileMap map = TileMapReader.readMap(“path/to/my/map.tmx”);

        root.requestFocus();
        aStage.setScene(rootScene);
        aStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public void startAplication(String[] args) {
        businessFacade = new BusinessFacede();
        ui = this;
        launch(args);
    }
        
    /**
     * 
     * @param business 
     */
    public void injectBusiness(IBusiness businessInterface) {
        business = businessInterface;
    }

    /**
     * 
     * @return 
     */
    public static BusinessFacede getBusiness() {
        return businessFacade;
    }
    
    //    /**
//     * 
//     * @return 
//     */
//    public static Stage getStage() {
//        return aStage;
//    }
///**
// * 
// * @return 
// */
//    public static Scene getRootScene() {
//        return rootScene;
//    }
//   /**
//    * 
//    * @return 
//    */  
//    public static Scene getGameScene() {
//        return gameScene;
//    }
}