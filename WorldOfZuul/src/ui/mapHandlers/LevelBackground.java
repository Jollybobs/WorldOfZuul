/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.mapHandlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.ImageIcon;

/**
 *
 * @author jollybob
 */
public class LevelBackground {
    
    public LevelBackground() {
    
    }
    
    Stage prevStage;

    public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }
    
    public void drawRoom() throws IOException {
        String[][] roomData = new String[4][4];
        roomData[0][0] = "/Tiles/background.png";
        roomData[0][1] = "/Tiles/background.png";
        roomData[0][2] = "/Tiles/background.png";
        roomData[0][3] = "/Tiles/background.png";
        roomData[1][0] = "/Tiles/background.png";
        roomData[1][1] = "/Tiles/background.png";
        roomData[1][2] = "/Tiles/background.png";
        roomData[1][3] = "/Tiles/background.png";
        roomData[2][0] = "/Tiles/background.png";
        roomData[2][1] = "/Tiles/background.png";
        roomData[2][2] = "/Tiles/background.png";
        roomData[2][3] = "/Tiles/background.png";
        roomData[3][0] = "/Tiles/background.png";
        roomData[3][1] = "/Tiles/background.png";
        roomData[3][2] = "/Tiles/background.png";
        roomData[3][3] = "/Tiles/background.png";
        
        Canvas canvas = new Canvas(300, 300);
        //GraphicsContext gc = GraphicsContext(); 
//        GraphicsContext gc = canvas.getGraphicsContext2D();
        
//        ImageIcon icon = new ImageIcon(LevelBackground.class.getResource(roomData[0][0]));
//        Image image = icon.getImage();
             
//        gc.drawImage(image, 0, 0, 30, 30);
        

       Stage stage = new Stage();
       stage.setTitle("Shop Management");
       Pane myPane = null;
       myPane = FXMLLoader.load(getClass().getResource("map.fxml"));
       Scene scene = new Scene(myPane);
       stage.setScene(scene);

//       prevStage.close();

       stage.show();


//        return canvas;
    }   
}