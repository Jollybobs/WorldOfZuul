/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import acquaintance.IBusiness;
import acquaintance.IUI;
import business.BusinessFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX FXML starter for Prison Escape Game.
 * 
 * @author Jonathan
 */
public class UI extends Application implements IUI {
    static IBusiness business;
    static BusinessFacade businessFacade;
    static UI ui;
    static Stage aStage;
    static Scene rootScene; 
    static Scene gameScene;
            
    /**
     * starter method class from JavaFX's Application class.
     * 
     * @param stage Auto generated stage from JavaFX Application to add content.
     * @throws Exception is not handled since file is within package.
     */
    @Override
    public void start(Stage stage) throws Exception {
        aStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        rootScene = new Scene(root);
        aStage.setScene(rootScene);
        aStage.show();
    }

    /**
     * External accessor of start through IUI interface, to ensure correct layering.
     * 
     * @param args not used.
     */
    public void startAplication(String[] args) {
        businessFacade = new BusinessFacade();
        ui = this;
        launch(args);
    }
        
    /**
     * Inject business data interface to UI.
     * 
     * @param businessInterface Interface for Business.
     */
    public void injectBusiness(IBusiness businessInterface) {
        business = businessInterface;
    }

    /**
     * Enables getter for BusinessFacade in UI.
     * 
     * @return instance of BusinessFacade.
     */
    public static BusinessFacade getBusiness() {
        return businessFacade;
    }
}