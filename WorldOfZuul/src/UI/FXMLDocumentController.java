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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
    HashMap<String, Image> backgroundMap;
    HashMap<String, Image> dynamicMap;
    
    
    
    HashMap<String, ImageView> levelMap;
    int intX;
    int intY;
    boolean gameStarted;
    @FXML
    private TextArea textArea;
  
    @FXML
    private MenuItem menuPause;
    
    @FXML
    private BorderPane viewPort;
    @FXML
    private AnchorPane viewGrid;
    //@FXML
    //private AnchorPane anchor;
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameStarted = false;
        intX = 0;
        intY = 0;
        levelMap = new HashMap<>();
        initViewPort();
        BackgroundMap gm = new BackgroundMap();
        backgroundMap = gm.getMap();
        DynamicMap dm = new DynamicMap();
        dynamicMap = dm.getMap();
        redrawViewPort();
        setControlButtonStatus(true);
        //gameView.setVisible(false);
        //setHighscore((ArrayList) busFace.loadHighscore()); //TODO: no file to load yet

        setViewScaleable();

        
        
    }
    
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
        textArea.setDisable(boo);
        textArea.setVisible(!boo);
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
    
    // Handles arrow keys user input.
    @FXML
    private void handleOnKeyPressed(KeyEvent e) {
        if(gameStarted){
            switch(e.getCode()) {
                case UP:
                    setPlacer(0,-1);
                    break;
                case RIGHT:
                    setPlacer(1,0);
                    break;
                case DOWN:
                    setPlacer(0,1);
                    break;
                case LEFT:
                    setPlacer(-1,0);
                    break;
            }
        }
    }

    @FXML
    private void eastClicked(MouseEvent event) {
//        System.out.println("You used the mouse to move East");
        setPlacer(1,0);
        busFace.move("east");
    }

    @FXML
    private void southClicked(MouseEvent event) {
//        System.out.println("You used the mouse to move South");
        setPlacer(0,1);
        busFace.move("south");
    }

    @FXML
    private void westClicked(MouseEvent event) {
//        System.out.println("You used the mouse to move West");
        setPlacer(-1,0);
        busFace.move("west");
    }

    @FXML
    private void northClicked(MouseEvent event) {
//        System.out.println("You used the mouse to move North");
        setPlacer(0,-1);
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
        
        if(busFace.miniGameConditionCheck()){
            //set textfield on
            buttonWait.setFocusTraversable(false);
                while(busFace.miniGameRuns()){
                textArea.appendText("press: "+busFace.miniGameGetChar());
                //get input
                    if (miniGameCheckInput(input)){
                    textArea.appendText("Right");  
                    }
                    else{textArea.appendText("Wrong!");
                    }
            }//Runs
            buttonWait.setFocusTraversable(true);
            %WRITEBOXHOLDER%.requestFocus();
            
        }//conditionCheck
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
        gameStarted = false;
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
        gameStarted = true;
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
    
    private void setPlacer(int x, int y) {
        if(x > 0 && intX < 10 || x < 0 && intX > 0) {
            intX = intX +x;
            redrawViewPort();
        }
        if(y > 0 && intY < 10 || y < 0 && intY > 0) {
            intY = intY +y;
            redrawViewPort();
        }
    }
    
    private void redrawViewPort() {
        levelMap.forEach((String k, ImageView v) -> {
            int x = Integer.parseInt(k.substring(1,2));
            int y = Integer.parseInt(k.substring(0,1));
            String dynamicplacement = new String(Integer.toString(y) + Integer.toString(x));
            
            x = x + intX;
            y = y + intY;
            String placement = new String(Integer.toString(y) + Integer.toString(x));
            
            v.setImage(backgroundMap.get(placement));
            if(dynamicMap.get(dynamicplacement) != null) {
                v.setImage(dynamicMap.get(dynamicplacement));
            }
        });
    }

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
        
        levelMap.put("001", tile001);levelMap.put("011", tile011);levelMap.put("021", tile021);levelMap.put("031", tile031);
        levelMap.put("041", tile041);levelMap.put("051", tile051);levelMap.put("061", tile061);levelMap.put("071", tile071);
        levelMap.put("081", tile081);levelMap.put("091", tile091);levelMap.put("101", tile101);levelMap.put("111", tile111);
        levelMap.put("121", tile121);levelMap.put("131", tile131);levelMap.put("141", tile141);levelMap.put("151", tile151);
        levelMap.put("161", tile161);levelMap.put("171", tile171);levelMap.put("181", tile181);levelMap.put("191", tile191);
        levelMap.put("201", tile201);levelMap.put("211", tile211);levelMap.put("221", tile221);levelMap.put("231", tile231);
        levelMap.put("241", tile241);levelMap.put("251", tile251);levelMap.put("261", tile261);levelMap.put("271", tile271);
        levelMap.put("281", tile281);levelMap.put("291", tile291);levelMap.put("301", tile301);levelMap.put("311", tile311);
        levelMap.put("321", tile321);levelMap.put("331", tile331);levelMap.put("341", tile341);levelMap.put("351", tile351);
        levelMap.put("361", tile361);levelMap.put("371", tile371);levelMap.put("381", tile381);levelMap.put("391", tile391);
        levelMap.put("401", tile401);levelMap.put("411", tile411);levelMap.put("421", tile421);levelMap.put("431", tile431);
        levelMap.put("441", tile441);levelMap.put("451", tile451);levelMap.put("461", tile461);levelMap.put("471", tile471);
        levelMap.put("481", tile481);levelMap.put("491", tile491);levelMap.put("501", tile501);levelMap.put("511", tile511);
        levelMap.put("521", tile521);levelMap.put("531", tile531);levelMap.put("541", tile541);levelMap.put("551", tile551);
        levelMap.put("561", tile561);levelMap.put("571", tile571);levelMap.put("581", tile581);levelMap.put("591", tile591);
        levelMap.put("601", tile601);levelMap.put("611", tile611);levelMap.put("621", tile621);levelMap.put("631", tile631);
        levelMap.put("641", tile641);levelMap.put("651", tile651);levelMap.put("661", tile661);levelMap.put("671", tile671);
        levelMap.put("681", tile681);levelMap.put("691", tile691);levelMap.put("701", tile701);levelMap.put("711", tile711);
        levelMap.put("721", tile721);levelMap.put("731", tile731);levelMap.put("741", tile741);levelMap.put("751", tile751);
        levelMap.put("761", tile761);levelMap.put("771", tile771);levelMap.put("781", tile781);levelMap.put("791", tile791);
        levelMap.put("801", tile801);levelMap.put("811", tile811);levelMap.put("821", tile821);levelMap.put("831", tile831);
        levelMap.put("841", tile841);levelMap.put("851", tile851);levelMap.put("861", tile861);levelMap.put("871", tile871);
        levelMap.put("881", tile881);levelMap.put("891", tile891);levelMap.put("901", tile901);levelMap.put("911", tile911);
        levelMap.put("921", tile921);levelMap.put("931", tile931);levelMap.put("941", tile941);levelMap.put("951", tile951);
        levelMap.put("961", tile961);levelMap.put("971", tile971);levelMap.put("981", tile981);levelMap.put("991", tile991);
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
    
    @FXML private ImageView tile001;@FXML private ImageView tile011;@FXML private ImageView tile021;@FXML private ImageView tile031;
    @FXML private ImageView tile041;@FXML private ImageView tile051;@FXML private ImageView tile061;@FXML private ImageView tile071;
    @FXML private ImageView tile081;@FXML private ImageView tile091;@FXML private ImageView tile101;@FXML private ImageView tile111;
    @FXML private ImageView tile121;@FXML private ImageView tile131;@FXML private ImageView tile141;@FXML private ImageView tile151;
    @FXML private ImageView tile161;@FXML private ImageView tile171;@FXML private ImageView tile181;@FXML private ImageView tile191;
    @FXML private ImageView tile201;@FXML private ImageView tile211;@FXML private ImageView tile221;@FXML private ImageView tile231;
    @FXML private ImageView tile241;@FXML private ImageView tile251;@FXML private ImageView tile261;@FXML private ImageView tile271;
    @FXML private ImageView tile281;@FXML private ImageView tile291;@FXML private ImageView tile301;@FXML private ImageView tile311;
    @FXML private ImageView tile321;@FXML private ImageView tile331;@FXML private ImageView tile341;@FXML private ImageView tile351;
    @FXML private ImageView tile361;@FXML private ImageView tile371;@FXML private ImageView tile381;@FXML private ImageView tile391;
    @FXML private ImageView tile401;@FXML private ImageView tile411;@FXML private ImageView tile421;@FXML private ImageView tile431;
    @FXML private ImageView tile441;@FXML private ImageView tile451;@FXML private ImageView tile461;@FXML private ImageView tile471;
    @FXML private ImageView tile481;@FXML private ImageView tile491;@FXML private ImageView tile501;@FXML private ImageView tile511;
    @FXML private ImageView tile521;@FXML private ImageView tile531;@FXML private ImageView tile541;@FXML private ImageView tile551;
    @FXML private ImageView tile561;@FXML private ImageView tile571;@FXML private ImageView tile581;@FXML private ImageView tile591;
    @FXML private ImageView tile601;@FXML private ImageView tile611;@FXML private ImageView tile621;@FXML private ImageView tile631;
    @FXML private ImageView tile641;@FXML private ImageView tile651;@FXML private ImageView tile661;@FXML private ImageView tile671;
    @FXML private ImageView tile681;@FXML private ImageView tile691;@FXML private ImageView tile701;@FXML private ImageView tile711;
    @FXML private ImageView tile721;@FXML private ImageView tile731;@FXML private ImageView tile741;@FXML private ImageView tile751;
    @FXML private ImageView tile761;@FXML private ImageView tile771;@FXML private ImageView tile781;@FXML private ImageView tile791;
    @FXML private ImageView tile801;@FXML private ImageView tile811;@FXML private ImageView tile821;@FXML private ImageView tile831;
    @FXML private ImageView tile841;@FXML private ImageView tile851;@FXML private ImageView tile861;@FXML private ImageView tile871;
    @FXML private ImageView tile881;@FXML private ImageView tile891;@FXML private ImageView tile901;@FXML private ImageView tile911;
    @FXML private ImageView tile921;@FXML private ImageView tile931;@FXML private ImageView tile941;@FXML private ImageView tile951;
    @FXML private ImageView tile961;@FXML private ImageView tile971;@FXML private ImageView tile981;@FXML private ImageView tile991;
    
    
    //Other FXML-pointers.
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

    @FXML
    private void pause(ActionEvent event) {
    }

    private void setViewScaleable() {
              tile00.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile01.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile02.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile03.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile04.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile05.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile06.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile07.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile08.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile09.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile10.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile11.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile12.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile13.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile14.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile15.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile16.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile17.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile18.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile19.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile20.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile21.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile22.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile23.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile24.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile25.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile26.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile27.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile28.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile29.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile30.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile31.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile32.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile33.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile34.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile35.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile36.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile37.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile38.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile39.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile40.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile41.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile42.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile43.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile44.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile45.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile46.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile47.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile48.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile49.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile50.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile51.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile52.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile53.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile54.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile55.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile56.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile57.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile58.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile59.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile60.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile61.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile62.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile63.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile64.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile65.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile66.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile67.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile68.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile69.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile70.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile71.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile72.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile73.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile74.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile75.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile76.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile77.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile78.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile79.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile80.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile81.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile82.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile83.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile84.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile85.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile86.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile87.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile88.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile89.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile90.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile91.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile92.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile93.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile94.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile95.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile96.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile97.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile98.fitHeightProperty().bind(viewGrid.widthProperty());
//        tile99.fitHeightProperty().bind(viewGrid.widthProperty());
    }
}
