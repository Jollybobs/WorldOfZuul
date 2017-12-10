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
import java.util.HashMap;
import java.util.Map;
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
    private Button buttonShowInventory;
    @FXML
    private Button buttonPickUp;
    @FXML
    private Button buttonUseItem;
    @FXML
    private Button buttonLook;    
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
    
    
    Map<String, ImageView> levelMap;

    public void setControlButtonStatus(boolean boo){
        buttonEast.setDisable(boo);
        buttonNorth.setDisable(boo);
        buttonSouth.setDisable(boo);
        buttonWait.setDisable(boo);
        buttonWest.setDisable(boo);
        buttonPickUp.setDisable(boo);
        buttonShowInventory.setDisable(boo);
        buttonUseItem.setDisable(boo);
        buttonLook.setDisable(boo);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        levelMap = new HashMap<>();
        initViewPort();
        setControlButtonStatus(true);
        //gameView.setVisible(false);
        //setHighscore((ArrayList) busFace.loadHighscore()); //TODO: no file to load yet
        image = new Image(BGpng);
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
    private void eastClicked(MouseEvent event) {
        System.out.println("You used the mouse to move East");
        busFace.move("east");

    }

    @FXML
    private void southClicked(MouseEvent event) {
        System.out.println("You used the mouse to move South");
        busFace.move("south");
    }

    @FXML
    private void westClicked(MouseEvent event) {
        System.out.println("You used the mouse to move West");
        busFace.move("west");
    }

    @FXML
    private void northClicked(MouseEvent event) {
        System.out.println("You used the mouse to move North");
        busFace.move("north");
    }

    @FXML
    private void waitClicked(MouseEvent event) {
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
    }
    
    @FXML
    private void loadGame(ActionEvent event) {
        busFace.loadGame();
    }

    @FXML
    private void about(ActionEvent event) {
        //TODO: about
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"This game is about...",ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void controls(ActionEvent event) {
        //TODO: control list
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"The different control in the game...",ButtonType.OK);
        alert.showAndWait();
    }
    
    private void redrawViewPort() {
        levelMap.forEach((k, v) -> {
            System.out.println("k" + k + "v" + v.toString());
        });
    
    }

    // Only hardcoded junk for viewport tiles from here and down.
    // initViewPort(): Organizes the tiles in a HashMap called lavelMap.
    private void initViewPort() {
        levelMap.put("00", tile00);levelMap.put("01", tile01);levelMap.put("02", tile02);levelMap.put("03", tile03);
        levelMap.put("04", tile04);levelMap.put("05", tile05);levelMap.put("06", tile06);levelMap.put("07", tile07);
        levelMap.put("08", tile08);levelMap.put("09", tile09);levelMap.put("10", tile10);levelMap.put("11", tile11);
        levelMap.put("12", tile12);levelMap.put("13", tile13);levelMap.put("14", tile14);levelMap.put("15", tile15);
        levelMap.put("16", tile16);levelMap.put("17", tile17);levelMap.put("18", tile18);levelMap.put("19", tile19);
        levelMap.put("20", tile20);levelMap.put("21", tile21);levelMap.put("22", tile22);levelMap.put("23", tile23);
        levelMap.put("24", tile24);levelMap.put("25", tile25);levelMap.put("26", tile26);levelMap.put("27", tile27);
        levelMap.put("28", tile28);levelMap.put("29", tile29);levelMap.put("30", tile30);levelMap.put("31", tile31);
        levelMap.put("32", tile32);levelMap.put("33", tile33);levelMap.put("34", tile34);levelMap.put("35", tile35);
        levelMap.put("36", tile36);levelMap.put("37", tile37);levelMap.put("38", tile38);levelMap.put("39", tile39);
        levelMap.put("40", tile40);levelMap.put("41", tile41);levelMap.put("42", tile42);levelMap.put("43", tile43);
        levelMap.put("44", tile44);levelMap.put("45", tile45);levelMap.put("46", tile46);levelMap.put("47", tile47);
        levelMap.put("48", tile48);levelMap.put("49", tile49);levelMap.put("50", tile50);levelMap.put("51", tile51);
        levelMap.put("52", tile52);levelMap.put("53", tile53);levelMap.put("54", tile54);levelMap.put("55", tile55);
        levelMap.put("56", tile56);levelMap.put("57", tile57);levelMap.put("58", tile58);levelMap.put("59", tile59);
        levelMap.put("60", tile60);levelMap.put("61", tile61);levelMap.put("62", tile62);levelMap.put("63", tile63);
        levelMap.put("64", tile64);levelMap.put("65", tile65);levelMap.put("66", tile66);levelMap.put("67", tile67);
        levelMap.put("68", tile68);levelMap.put("69", tile69);levelMap.put("70", tile70);levelMap.put("71", tile71);
        levelMap.put("72", tile72);levelMap.put("73", tile73);levelMap.put("74", tile74);levelMap.put("75", tile75);
        levelMap.put("76", tile76);levelMap.put("77", tile77);levelMap.put("78", tile78);levelMap.put("79", tile79);
        levelMap.put("80", tile80);levelMap.put("81", tile81);levelMap.put("82", tile82);levelMap.put("83", tile83);
        levelMap.put("84", tile84);levelMap.put("85", tile85);levelMap.put("86", tile86);levelMap.put("87", tile87);
        levelMap.put("88", tile88);levelMap.put("89", tile89);levelMap.put("90", tile90);levelMap.put("91", tile91);
        levelMap.put("92", tile92);levelMap.put("93", tile93);levelMap.put("94", tile94);levelMap.put("95", tile95);
        levelMap.put("96", tile96);levelMap.put("97", tile97);levelMap.put("98", tile98);levelMap.put("99", tile99);
    }

    // FXML-pointer to tiles.
    @FXML private ImageView tile00;@FXML private ImageView tile01;@FXML private ImageView tile02;@FXML private ImageView tile03;
    @FXML private ImageView tile04;@FXML private ImageView tile05;@FXML private ImageView tile06;@FXML private ImageView tile07;
    @FXML private ImageView tile08;@FXML private ImageView tile09;@FXML private ImageView tile10;@FXML private ImageView tile11;
    @FXML private ImageView tile12;@FXML private ImageView tile13;@FXML private ImageView tile14;@FXML private ImageView tile15;
    @FXML private ImageView tile16;@FXML private ImageView tile17;@FXML private ImageView tile18;@FXML private ImageView tile19;
    @FXML private ImageView tile20;@FXML private ImageView tile21;@FXML private ImageView tile22;@FXML private ImageView tile23;
    @FXML private ImageView tile24;@FXML private ImageView tile25;@FXML private ImageView tile26;@FXML private ImageView tile27;
    @FXML private ImageView tile28;@FXML private ImageView tile29;@FXML private ImageView tile30;@FXML private ImageView tile31;
    @FXML private ImageView tile32;@FXML private ImageView tile33;@FXML private ImageView tile34;@FXML private ImageView tile35;
    @FXML private ImageView tile36;@FXML private ImageView tile37;@FXML private ImageView tile38;@FXML private ImageView tile39;
    @FXML private ImageView tile40;@FXML private ImageView tile41;@FXML private ImageView tile42;@FXML private ImageView tile43;
    @FXML private ImageView tile44;@FXML private ImageView tile45;@FXML private ImageView tile46;@FXML private ImageView tile47;
    @FXML private ImageView tile48;@FXML private ImageView tile49;@FXML private ImageView tile50;@FXML private ImageView tile51;
    @FXML private ImageView tile52;@FXML private ImageView tile53;@FXML private ImageView tile54;@FXML private ImageView tile55;
    @FXML private ImageView tile56;@FXML private ImageView tile57;@FXML private ImageView tile58;@FXML private ImageView tile59;
    @FXML private ImageView tile60;@FXML private ImageView tile61;@FXML private ImageView tile62;@FXML private ImageView tile63;
    @FXML private ImageView tile64;@FXML private ImageView tile65;@FXML private ImageView tile66;@FXML private ImageView tile67;
    @FXML private ImageView tile68;@FXML private ImageView tile69;@FXML private ImageView tile70;@FXML private ImageView tile71;
    @FXML private ImageView tile72;@FXML private ImageView tile73;@FXML private ImageView tile74;@FXML private ImageView tile75;
    @FXML private ImageView tile76;@FXML private ImageView tile77;@FXML private ImageView tile78;@FXML private ImageView tile79;
    @FXML private ImageView tile80;@FXML private ImageView tile81;@FXML private ImageView tile82;@FXML private ImageView tile83;
    @FXML private ImageView tile84;@FXML private ImageView tile85;@FXML private ImageView tile86;@FXML private ImageView tile87;
    @FXML private ImageView tile88;@FXML private ImageView tile89;@FXML private ImageView tile90;@FXML private ImageView tile91;
    @FXML private ImageView tile92;@FXML private ImageView tile93;@FXML private ImageView tile94;@FXML private ImageView tile95;
    @FXML private ImageView tile96;@FXML private ImageView tile97;@FXML private ImageView tile98;@FXML private ImageView tile99;
}
