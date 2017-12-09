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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

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
        if (busFace.saveGame() == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"There was an error during the saveing of the game!",ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void exitGame(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to exit the game?",ButtonType.YES,ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            Platform.exit();
            System.exit(0);
        }
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
        ImageView iv0 = new ImageView(image);
        ImageView iv1 = new ImageView(image);
        ImageView iv2 = new ImageView(image);
        ImageView iv3 = new ImageView(image);
        ImageView iv4 = new ImageView(image);
        ImageView iv5 = new ImageView(image);
        ImageView iv6 = new ImageView(image);
        ImageView iv7 = new ImageView(image);
        ImageView iv8 = new ImageView(image);
        ImageView iv9 = new ImageView(image);
        ImageView iv10 = new ImageView(image);
        ImageView iv11 = new ImageView(image);
        ImageView iv12 = new ImageView(image);
        ImageView iv13 = new ImageView(image);
        ImageView iv14 = new ImageView(image);
        ImageView iv15 = new ImageView(image);
        ImageView iv16 = new ImageView(image);
        ImageView iv17 = new ImageView(image);
        ImageView iv18 = new ImageView(image);
        ImageView iv19 = new ImageView(image);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        
        GridPane gridpane = new GridPane();

     // Set one constraint at a time...
     // Places the button at the first row and second column
     Button button = new Button();
     GridPane.setRowIndex(button, 0);
     GridPane.setColumnIndex(button, 1);

     // or convenience methods set more than one constraint at once...
     Label label = new Label();
     GridPane.setConstraints(label, 2, 0); // column=2 row=0

     // don't forget to add children to gridpane
     gridpane.getChildren().addAll(button, label);
        
        GridPane gp = new GridPane();
        
        VBox vbox = new VBox();
        
        HBox box = new HBox();
        gp.getChildren().add(iv0);
        gp.getChildren().add(iv1);
        gp.getChildren().add(iv2);
        gp.getChildren().add(iv3);
        gp.getChildren().add(iv4);
        gp.getChildren().add(iv5);
        
        vbox.getChildren().add(box);
        
        HBox box2 = new HBox();
        box2.getChildren().add(iv0);
        box2.getChildren().add(iv1);
        box2.getChildren().add(iv2);
        box2.getChildren().add(iv3);
        box2.getChildren().add(iv4);
        box2.getChildren().add(iv5);
        box2.getChildren().add(iv6);
        box2.getChildren().add(iv7);
        box2.getChildren().add(iv8);
        box2.getChildren().add(iv9);
        box2.getChildren().add(iv10);
        box2.getChildren().add(iv11);
        box2.getChildren().add(iv12);
        box2.getChildren().add(iv13);
        box2.getChildren().add(iv14);
        box2.getChildren().add(iv15);
        box2.getChildren().add(iv16);
        box2.getChildren().add(iv17);
        box2.getChildren().add(iv18);
        box2.getChildren().add(iv19);
        vbox.getChildren().add(box2);
        
//        root.getChildren().add(gridpane);

        Scene scene2 = new Scene(gp);
        stage.setScene(scene2);
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
