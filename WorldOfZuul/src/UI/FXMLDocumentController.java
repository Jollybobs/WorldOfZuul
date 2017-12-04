/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Business.BusinessFacede;
import java.util.ArrayList;
import javafx.scene.layout.GridPane;

/**
 *
 * @author paul
 */
public class FXMLDocumentController implements Initializable {

    BusinessFacede busFace = new BusinessFacede();

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
    private ImageView tile00;
    private ImageView tile01;
    private ImageView tile02;
    private ImageView tile03;
    private ImageView tile04;
    private ImageView tile05;
    private ImageView tile06;
    private ImageView tile07;
    private ImageView tile08;
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
    @FXML
    private MenuItem menuSave;
    @FXML
    private MenuItem menuExit;
    @FXML
    private MenuItem menuAbout;
    @FXML
    private MenuItem menuControls;
    @FXML
    private GridPane highscorePane;
    @FXML
    private Button buttonNewgame;
    @FXML
    private Button buttonLoadgame;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonEast.setDisable(true);
        buttonNorth.setDisable(true);
        buttonSouth.setDisable(true);
        buttonWait.setDisable(true);
        buttonWest.setDisable(true);
        //setHighscore((ArrayList) busFace.loadHighscore()); //TODO: no file to load yet
    }

    private void setHighscore(ArrayList aList) {
        for (int i = 0; i < 10; i++) {
            switch (i+1) { //i did not wante to change all 10 case's
                case 1:
                    HighScore1.setText((String)aList.get(i));
                case 2:
                    Time1.setText((String)aList.get(i));
                case 3:
                    HighScore2.setText((String)aList.get(i));
                case 4:
                    Time2.setText((String)aList.get(i));
                case 5:
                    HighScore3.setText((String)aList.get(i));
                case 6:
                    Time3.setText((String)aList.get(i));
                case 7:
                    HighScore4.setText((String)aList.get(i));
                case 8:
                    Time4.setText((String)aList.get(i));
                case 9:
                    HighScore5.setText((String)aList.get(i));
                case 10:
                    Time5.setText((String)aList.get(i));
            }
        }
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
        System.out.println("click");
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
        busFace.saveGame();
    }

    @FXML
    private void exitGame(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

//    @FXML
//    private void startNewGame(ActionEvent event) throws IOException {
//        System.out.println("new game");
//        drawRoom();
//        Stage stage = UI.getStage();
//        Scene gameScene = UI.getGameScene();
//        stage.setScene(gameScene);        
//        drawRoom();
//    }
    @FXML
    private void startNewGame(ActionEvent event) throws IOException {
        System.out.println("new game");
        Stage stage = UI.getStage();
        Scene gameScene = UI.getGameScene();

        Image image = new Image("/UI/background.png");
        ImageView iv1 = new ImageView(image);
        ImageView iv2 = new ImageView(image);
        ImageView iv3 = new ImageView(image);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        HBox box = new HBox();
        box.getChildren().add(iv1);
        box.getChildren().add(iv2);
        box.getChildren().add(iv3);
        root.getChildren().add(box);

        stage.setScene(scene);
        drawRoom();
    }

    private void drawRoom(/*Room room*/) {
        tile00 = new ImageView(new Image("/UI/background.png"));
        tile01 = new ImageView(new Image("/UI/background.png"));
        tile02 = new ImageView(new Image("/UI/background.png"));
        tile03 = new ImageView(new Image("/UI/background.png"));
        tile04 = new ImageView(new Image("/UI/background.png"));
        tile05 = new ImageView(new Image("/UI/background.png"));
        tile06 = new ImageView(new Image("/UI/background.png"));
        tile07 = new ImageView(new Image("/UI/background.png"));
        tile08 = new ImageView(new Image("/UI/background.png"));
    }

    @FXML
    private void loadGame(ActionEvent event) {
        busFace.loadGame();
    }

    @FXML
    private void about(ActionEvent event) {
    }

    @FXML
    private void controls(ActionEvent event) {
    }
}
