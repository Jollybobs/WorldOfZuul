/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author paul
 */
public class FXMLDocumentController implements Initializable {

    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void EastClicked(MouseEvent event) {
        System.out.println("You used the mouse to move East");

    }

    @FXML
    private void SouthClicked(MouseEvent event) {
        System.out.println("You used the mouse to move South");
    }

    @FXML
    private void WestClicked(MouseEvent event) {
        System.out.println("You used the mouse to move West");
    }

    @FXML
    private void NorthClicked(MouseEvent event) {
        System.out.println("You used the mouse to move North");
    }

    @FXML
    private void WaitClicked(MouseEvent event) {
        System.out.println("You used the mouse to Wait");
    }

    private void HandelKeyMove(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
                System.out.println("LEFT");
                break;
            case RIGHT:
                System.out.println("RIGHT");
                break;
            case UP:
                System.out.println("Up");
                break;
            case DOWN:
                System.out.println("Down");
                break;
        }

    }

    private void CloseApp(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

}
