/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author paul
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Label HighScore1;
    @FXML
    private Label HighScore2;
    @FXML
    private Label HighScore3;
    @FXML
    private Label HighScore4;
    @FXML
    private Label HighScore5;
    @FXML
    private Label Time1;
    @FXML
    private Label Time2;
    @FXML
    private Label Time3;
    @FXML
    private Label Time4;
    @FXML
    private Label Time5;
    @FXML
    private Label Time51;
    @FXML
    private Button buttonNorth;
    @FXML
    private Button buttonWest;
    @FXML
    private Button buttonSouth;
    @FXML
    private Button buttonWait;
    @FXML
    private Button buttonEast;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonEast.setDisable(true);
        buttonNorth.setDisable(true);
        buttonSouth.setDisable(true);
        buttonWait.setDisable(true);
        buttonWest.setDisable(true);
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
                System.out.println("You used the button to go West");
                break;
            case RIGHT:
                System.out.println("You used the button to go East");
                break;
            case UP:
                System.out.println("You used the button to go North");
                break;
            case DOWN:
                System.out.println("You used the button to go South");
                break;
        }

    }

    @FXML
    private void saveGame(ActionEvent event) {
    }

    @FXML
    private void exitGame(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void startNewGame(ActionEvent event) {
    }

    @FXML
    private void loadGame(ActionEvent event) {
    }

}
