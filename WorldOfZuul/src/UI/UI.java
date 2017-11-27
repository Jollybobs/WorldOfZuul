/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Acquaintance.IBusiness;
import Acquaintance.IUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author paul
 */
public class UI extends Application implements IUI {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        root.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public void StartAplication(String[] args) {
        launch(args);

    }

    IBusiness business;

    public void InjectBusiness(IBusiness business) {
        this.business = business;
    }

    public IBusiness GetBusiness() {
        return this.business;
    }
}
