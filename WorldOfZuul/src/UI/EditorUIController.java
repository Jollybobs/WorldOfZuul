/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.Tiles.TileEnum;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author paul
 */
public class EditorUIController implements Initializable {

    @FXML
    private VBox box1;
    @FXML
    private VBox box2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        box1.getChildren().add(new ImageView(new Image(TileEnum.BACKGROUND.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.DOOREASTEND.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.DOOREASTSTART.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.DOORNORTHEND.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.DOORNORTHSTART.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.DOORSOUTHEND.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.DOORSOUTHSTART.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.DOORWESTEND.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.DOORWESTSRTART.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.HAMMER_CHISEL.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.Key.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.LADDER.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.SAW.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.SEWERFLOOR1.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.SEWERFLOOR2.toString())));
        box1.getChildren().add(new ImageView(new Image(TileEnum.SEWERFLOOR3.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.SEWERFLOOR4.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.SEWERFLOOR5.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.SEWERFLOORLADDER.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.SEWERFLOORPIPE1.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.SEWERFLOORPIPE2.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_EAST.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_NORTH.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_NORTH_EAST.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_NORTH_LADDER.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_NORTH_WEST.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_SOUTH.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_SOUTH_EAST.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_SOUTH_WEST.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_WEST.toString())));
        box2.getChildren().add(new ImageView(new Image(TileEnum.WALL_WITH_PIPE.toString())));
    }

    
}
