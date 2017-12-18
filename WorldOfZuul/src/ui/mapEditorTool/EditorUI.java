/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.mapEditorTool;

import acquaintance.IBusiness;
import acquaintance.IUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX FXML starter for map editor.
 * 
 * @author Jonathan
 */
public class EditorUI extends Application implements IUI{
    IBusiness business;
    static EditorUI ui;
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
        Parent root = FXMLLoader.load(getClass().getResource("EditorUI.fxml"));
        rootScene = new Scene(root);
        aStage.setScene(rootScene);
        aStage.show();
        root.requestFocus();
    }

    /**
     * Inject business data interface to UI, to enable getter for BusinessFacade.
     * 
     * @param business Interface for Business.
     */
    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }

    /**
     * External accessor of start through IUI interface.
     * 
     * @param args not used.
     */
    @Override
    public void startAplication(String[] args) {
        ui = this;
        launch(args);
    }
    
}
