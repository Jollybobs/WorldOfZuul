/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.mapEditors;

import acquaintance.IBusiness;
import acquaintance.IUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jonathan
 */
public class EditorUI extends Application implements IUI{
    
    IBusiness business;
    static EditorUI ui;
    static Stage aStage;
    static Scene rootScene; 
    static Scene gameScene;

    @Override
    public void start(Stage stage) throws Exception {
         aStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("EditorUI.fxml"));

        rootScene = new Scene(root);
        
//        TileMap map = TileMapReader.readMap(“path/to/my/map.tmx”);


        aStage.setScene(rootScene);
        aStage.show();
        root.requestFocus();
    }

    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }

    @Override
    public void startAplication(String[] args) {
        ui = this;
        launch(args);
    }
    
}
