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
    private String BGpng = "/UI/background.png";
    Image image;
    @FXML
    private Label Time0;
    @FXML
    private Label HighScore0;
    @FXML
    private Button buttonShowInventory;
    @FXML
    private Button buttonPickUp;
    @FXML
    private Button buttonUseItem;
    @FXML
    private Button buttonLook;

    public void setControlButtonStatus(boolean boo){
        buttonEast.setDisable(boo);
        buttonNorth.setDisable(boo);
        buttonSouth.setDisable(boo);
        buttonWait.setDisable(boo);
        buttonWest.setDisable(boo);
        buttonPickUp.setDisable(boo);
        buttonShowInventory.setDisable(boo);
        buttonUseItem.setDisable(boo);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setControlButtonStatus(true);
        //gameView.setVisible(false);
        //setHighscore((ArrayList) busFace.loadHighscore()); //TODO: no file to load yet
        image = new Image(BGpng);
        drawRoom();
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
        busFace.move("east");

    }

    @FXML
    private void SouthClicked(MouseEvent event) {
        System.out.println("You used the mouse to move South");
        busFace.move("south");
    }

    @FXML
    private void WestClicked(MouseEvent event) {
        System.out.println("You used the mouse to move West");
        busFace.move("west");
    }

    @FXML
    private void NorthClicked(MouseEvent event) {
        System.out.println("You used the mouse to move North");
        busFace.move("north");
    }

    @FXML
    private void WaitClicked(MouseEvent event) {
        System.out.println("You used the mouse to Wait");
        busFace.waitGuard();
    }
    
    @FXML
    private void inventoryClicked(MouseEvent event) {
        System.out.println("You used the mouse to check the inventory");
        System.out.println(busFace.showInventory());
    }

    @FXML
    private void useClicked(MouseEvent event) {
        System.out.println("You used the mouse to use an item from the inventory");
        busFace.useItem();
    }

    @FXML
    private void pickUpClicked(MouseEvent event) {
        busFace.pickUpItem();
    }
    
    @FXML
    private void lookClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,busFace.look(),ButtonType.OK);
        alert.showAndWait();
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
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"The game was succsesfully saved.",ButtonType.OK);
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
        
        setControlButtonStatus(false);
        buttonNewgame.setVisible(false);
        buttonLoadgame.setVisible(false);
        HighScore0.setVisible(false);
        HighScore1.setVisible(false);
        HighScore2.setVisible(false);
        HighScore3.setVisible(false);
        HighScore4.setVisible(false);
        HighScore5.setVisible(false);
        Time0.setVisible(false);
        Time1.setVisible(false);
        Time2.setVisible(false);
        Time3.setVisible(false);
        Time4.setVisible(false);
        Time5.setVisible(false);
        //gameView.setVisible(true);

        
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
        ImageView iv20 = new ImageView(image);
        ImageView iv21 = new ImageView(image);
        ImageView iv22 = new ImageView(image);
        ImageView iv23 = new ImageView(image);
        ImageView iv24 = new ImageView(image);
        ImageView iv25 = new ImageView(image);
        ImageView iv26 = new ImageView(image);
        ImageView iv27 = new ImageView(image);
        ImageView iv28 = new ImageView(image);
        ImageView iv29 = new ImageView(image);
        ImageView iv30 = new ImageView(image);
        ImageView iv31 = new ImageView(image);
        ImageView iv32 = new ImageView(image);
        ImageView iv33 = new ImageView(image);
        ImageView iv34 = new ImageView(image);
        ImageView iv35 = new ImageView(image);
        ImageView iv36 = new ImageView(image);
        ImageView iv37 = new ImageView(image);
        ImageView iv38 = new ImageView(image);
        ImageView iv39 = new ImageView(image);
        ImageView iv40 = new ImageView(image);
        ImageView iv41 = new ImageView(image);
        ImageView iv42 = new ImageView(image);
        ImageView iv43 = new ImageView(image);
        ImageView iv44 = new ImageView(image);
        ImageView iv45 = new ImageView(image);
        ImageView iv46 = new ImageView(image);
        ImageView iv47 = new ImageView(image);
        ImageView iv48 = new ImageView(image);
        ImageView iv49 = new ImageView(image);
        ImageView iv50 = new ImageView(image);
        ImageView iv51 = new ImageView(image);
        ImageView iv52 = new ImageView(image);
        ImageView iv53 = new ImageView(image);
        ImageView iv54 = new ImageView(image);
        ImageView iv55 = new ImageView(image);
        ImageView iv56 = new ImageView(image);
        ImageView iv57 = new ImageView(image);
        ImageView iv58 = new ImageView(image);
        ImageView iv59 = new ImageView(image);
        ImageView iv60 = new ImageView(image);
        ImageView iv61 = new ImageView(image);
        ImageView iv62 = new ImageView(image);
        ImageView iv63 = new ImageView(image);
        ImageView iv64 = new ImageView(image);
        ImageView iv65 = new ImageView(image);
        ImageView iv66 = new ImageView(image);
        ImageView iv67 = new ImageView(image);
        ImageView iv68 = new ImageView(image);
        ImageView iv69 = new ImageView(image);
        ImageView iv70 = new ImageView(image);
        ImageView iv71 = new ImageView(image);
        ImageView iv72 = new ImageView(image);
        ImageView iv73 = new ImageView(image);
        ImageView iv74 = new ImageView(image);
        ImageView iv75 = new ImageView(image);
        ImageView iv76 = new ImageView(image);
        ImageView iv77 = new ImageView(image);
        ImageView iv78 = new ImageView(image);
        ImageView iv79 = new ImageView(image);
        ImageView iv80 = new ImageView(image);
        ImageView iv81 = new ImageView(image);
        ImageView iv82 = new ImageView(image);
        ImageView iv83 = new ImageView(image);
        ImageView iv84 = new ImageView(image);
        ImageView iv85 = new ImageView(image);
        ImageView iv86 = new ImageView(image);
        ImageView iv87 = new ImageView(image);
        ImageView iv88 = new ImageView(image);
        ImageView iv89 = new ImageView(image);
        ImageView iv90 = new ImageView(image);
        ImageView iv91 = new ImageView(image);
        ImageView iv92 = new ImageView(image);
        ImageView iv93 = new ImageView(image);
        ImageView iv94 = new ImageView(image);
        ImageView iv95 = new ImageView(image);
        ImageView iv96 = new ImageView(image);
        ImageView iv97 = new ImageView(image);
        ImageView iv98 = new ImageView(image);
        ImageView iv99 = new ImageView(image);

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
       // stage.setScene(scene2);
        drawRoom();
        
        
    }

    private void drawRoom(/*Room room*/) {
        tile00.setImage(image);
        tile01.setImage(image);
        tile02.setImage(image);
        tile03.setImage(image);
        tile04.setImage(image);
        tile05.setImage(image);
        tile06.setImage(image);
        tile07.setImage(image);
        tile08.setImage(image);
        tile09.setImage(image);
        tile10.setImage(image);
        tile11.setImage(image);
        tile12.setImage(image);
        tile13.setImage(image);
        tile14.setImage(image);
        tile15.setImage(image);
        tile16.setImage(image);
        tile17.setImage(image);
        tile18.setImage(image);
        tile19.setImage(image);
        tile20.setImage(image);
        tile21.setImage(image);
        tile22.setImage(image);
        tile23.setImage(image);
        tile24.setImage(image);
        tile25.setImage(image);
        tile26.setImage(image);
        tile27.setImage(image);
        tile28.setImage(image);
        tile29.setImage(image);
        tile30.setImage(image);
        tile31.setImage(image);
        tile32.setImage(image);
        tile33.setImage(image);
        tile34.setImage(image);
        tile35.setImage(image);
        tile36.setImage(image);
        tile37.setImage(image);
        tile38.setImage(image);
        tile39.setImage(image);
        tile40.setImage(image);
        tile41.setImage(image);
        tile42.setImage(image);
        tile43.setImage(image);
        tile44.setImage(image);
        tile45.setImage(image);
        tile46.setImage(image);
        tile47.setImage(image);
        tile48.setImage(image);
        tile49.setImage(image);
        tile50.setImage(image);
        tile51.setImage(image);
        tile52.setImage(image);
        tile53.setImage(image);
        tile54.setImage(image);
        tile55.setImage(image);
        tile56.setImage(image);
        tile57.setImage(image);
        tile58.setImage(image);
        tile59.setImage(image);
        tile60.setImage(image);
        tile61.setImage(image);
        tile62.setImage(image);
        tile63.setImage(image);
        tile64.setImage(image);
        tile65.setImage(image);
        tile66.setImage(image);
        tile67.setImage(image);
        tile68.setImage(image);
        tile69.setImage(image);
        tile70.setImage(image);
        tile71.setImage(image);
        tile72.setImage(image);
        tile73.setImage(image);
        tile74.setImage(image);
        tile75.setImage(image);
        tile76.setImage(image);
        tile77.setImage(image);
        tile78.setImage(image);
        tile79.setImage(image);
        tile80.setImage(image);
        tile81.setImage(image);
        tile82.setImage(image);
        tile83.setImage(image);
        tile84.setImage(image);
        tile85.setImage(image);
        tile86.setImage(image);
        tile87.setImage(image);
        tile88.setImage(image);
        tile89.setImage(image);
        tile90.setImage(image);
        tile91.setImage(image);
        tile92.setImage(image);
        tile93.setImage(image);
        tile94.setImage(image);
        tile95.setImage(image);
        tile96.setImage(image);
        tile97.setImage(image);
        tile98.setImage(image);
        tile99.setImage(image);
    }

    @FXML
    private void loadGame(ActionEvent event) {
        busFace.loadGame();
    }

    @FXML
    private void about(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"This game is about...",ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void controls(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"The different control in the game...",ButtonType.OK);
        alert.showAndWait();
    }
    
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
    private ImageView tile00;
    @FXML
    private ImageView tile01;
    @FXML
    private ImageView tile02;
    @FXML
    private ImageView tile03;
    @FXML
    private ImageView tile04;
    @FXML
    private ImageView tile05;
    @FXML
    private ImageView tile06;
    @FXML
    private ImageView tile07;
    @FXML
    private ImageView tile08;
    @FXML
    private ImageView tile09;
    @FXML
    private ImageView tile10;
    @FXML
    private ImageView tile11;
    @FXML
    private ImageView tile12;
    @FXML
    private ImageView tile13;
    @FXML
    private ImageView tile14;
    @FXML
    private ImageView tile15;
    @FXML
    private ImageView tile16;
    @FXML
    private ImageView tile17;
    @FXML
    private ImageView tile18;
    @FXML
    private ImageView tile19;
    @FXML
    private ImageView tile20;
    @FXML
    private ImageView tile21;
    @FXML
    private ImageView tile22;
    @FXML
    private ImageView tile23;
    @FXML
    private ImageView tile24;
    @FXML
    private ImageView tile25;
    @FXML
    private ImageView tile26;
    @FXML
    private ImageView tile27;
    @FXML
    private ImageView tile28;
    @FXML
    private ImageView tile29;
    @FXML
    private ImageView tile30;
    @FXML
    private ImageView tile31;
    @FXML
    private ImageView tile32;
    @FXML
    private ImageView tile33;
    @FXML
    private ImageView tile34;
    @FXML
    private ImageView tile35;
    @FXML
    private ImageView tile36;
    @FXML
    private ImageView tile37;
    @FXML
    private ImageView tile38;
    @FXML
    private ImageView tile39;
    @FXML
    private ImageView tile40;
    @FXML
    private ImageView tile41;
    @FXML
    private ImageView tile42;
    @FXML
    private ImageView tile43;
    @FXML
    private ImageView tile44;
    @FXML
    private ImageView tile45;
    @FXML
    private ImageView tile46;
    @FXML
    private ImageView tile47;
    @FXML
    private ImageView tile48;
    @FXML
    private ImageView tile49;
    @FXML
    private ImageView tile50;
    @FXML
    private ImageView tile51;
    @FXML
    private ImageView tile52;
    @FXML
    private ImageView tile53;
    @FXML
    private ImageView tile54;
    @FXML
    private ImageView tile55;
    @FXML
    private ImageView tile56;
    @FXML
    private ImageView tile57;
    @FXML
    private ImageView tile58;
    @FXML
    private ImageView tile59;
    @FXML
    private ImageView tile60;
    @FXML
    private ImageView tile61;
    @FXML
    private ImageView tile62;
    @FXML
    private ImageView tile63;
    @FXML
    private ImageView tile64;
    @FXML
    private ImageView tile65;
    @FXML
    private ImageView tile66;
    @FXML
    private ImageView tile67;
    @FXML
    private ImageView tile68;
    @FXML
    private ImageView tile69;
    @FXML
    private ImageView tile70;
    @FXML
    private ImageView tile71;
    @FXML
    private ImageView tile72;
    @FXML
    private ImageView tile73;
    @FXML
    private ImageView tile74;
    @FXML
    private ImageView tile75;
    @FXML
    private ImageView tile76;
    @FXML
    private ImageView tile77;
    @FXML
    private ImageView tile78;
    @FXML
    private ImageView tile79;
    @FXML
    private ImageView tile80;
    @FXML
    private ImageView tile81;
    @FXML
    private ImageView tile82;
    @FXML
    private ImageView tile83;
    @FXML
    private ImageView tile84;
    @FXML
    private ImageView tile85;
    @FXML
    private ImageView tile86;
    @FXML
    private ImageView tile87;
    @FXML
    private ImageView tile88;
    @FXML
    private ImageView tile89;
    @FXML
    private ImageView tile90;
    @FXML
    private ImageView tile91;
    @FXML
    private ImageView tile92;
    @FXML
    private ImageView tile93;
    @FXML
    private ImageView tile94;
    @FXML
    private ImageView tile95;
    @FXML
    private ImageView tile96;
    @FXML
    private ImageView tile97;
    @FXML
    private ImageView tile98;
    @FXML
    private ImageView tile99;
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
    private Button buttonNewgame;
    @FXML
    private Button buttonLoadgame;
}
