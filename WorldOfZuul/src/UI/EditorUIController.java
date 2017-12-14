/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DataLayer.DataFacede;
import UI.Tiles.TileEnum;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
    @FXML
    private GridPane viewGrid;
    String setTile;
    HashMap<String, String> levelMap;
    DataFacede data;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        data = new DataFacede();
        levelMap = new HashMap<>();
        loadMap();
        updateView();
        
        ImageView iv01 = new ImageView(new Image(TileEnum.BACKGROUND.toString()));        iv01.setOnMouseClicked(e -> chooseImg(TileEnum.BACKGROUND.toString()));
        ImageView iv02 = new ImageView(new Image(TileEnum.DOOREASTEND.toString()));       iv02.setOnMouseClicked(e -> chooseImg(TileEnum.DOOREASTEND.toString()));
        ImageView iv03 = new ImageView(new Image(TileEnum.DOOREASTSTART.toString()));     iv03.setOnMouseClicked(e -> chooseImg(TileEnum.DOOREASTSTART.toString()));
        ImageView iv04 = new ImageView(new Image(TileEnum.DOORNORTHEND.toString()));      iv04.setOnMouseClicked(e -> chooseImg(TileEnum.DOORNORTHEND.toString()));
        ImageView iv05 = new ImageView(new Image(TileEnum.DOORNORTHSTART.toString()));    iv05.setOnMouseClicked(e -> chooseImg(TileEnum.DOORNORTHSTART.toString()));
        ImageView iv06 = new ImageView(new Image(TileEnum.DOORSOUTHEND.toString()));      iv06.setOnMouseClicked(e -> chooseImg(TileEnum.DOORSOUTHEND.toString()));
        ImageView iv07 = new ImageView(new Image(TileEnum.DOORSOUTHSTART.toString()));    iv07.setOnMouseClicked(e -> chooseImg(TileEnum.DOORSOUTHSTART.toString()));
        ImageView iv08 = new ImageView(new Image(TileEnum.DOORWESTEND.toString()));       iv08.setOnMouseClicked(e -> chooseImg(TileEnum.DOORWESTEND.toString()));
        ImageView iv09 = new ImageView(new Image(TileEnum.DOORWESTSRTART.toString()));    iv09.setOnMouseClicked(e -> chooseImg(TileEnum.DOORWESTSRTART.toString()));
        ImageView iv10 = new ImageView(new Image(TileEnum.HAMMER_CHISEL.toString()));     iv10.setOnMouseClicked(e -> chooseImg(TileEnum.HAMMER_CHISEL.toString()));
        ImageView iv11 = new ImageView(new Image(TileEnum.Key.toString()));               iv11.setOnMouseClicked(e -> chooseImg(TileEnum.Key.toString()));
        ImageView iv12 = new ImageView(new Image(TileEnum.LADDER.toString()));            iv12.setOnMouseClicked(e -> chooseImg(TileEnum.LADDER.toString()));
        ImageView iv13 = new ImageView(new Image(TileEnum.SAW.toString()));               iv13.setOnMouseClicked(e -> chooseImg(TileEnum.SAW.toString()));
        ImageView iv14 = new ImageView(new Image(TileEnum.SEWERFLOOR1.toString()));       iv14.setOnMouseClicked(e -> chooseImg(TileEnum.SEWERFLOOR1.toString()));
        ImageView iv15 = new ImageView(new Image(TileEnum.SEWERFLOOR2.toString()));       iv15.setOnMouseClicked(e -> chooseImg(TileEnum.SEWERFLOOR2.toString()));
        ImageView iv16 = new ImageView(new Image(TileEnum.SEWERFLOOR3.toString()));       iv16.setOnMouseClicked(e -> chooseImg(TileEnum.SEWERFLOOR3.toString()));
        ImageView iv17 = new ImageView(new Image(TileEnum.SEWERFLOOR4.toString()));       iv17.setOnMouseClicked(e -> chooseImg(TileEnum.SEWERFLOOR4.toString()));
        ImageView iv18 = new ImageView(new Image(TileEnum.SEWERFLOOR5.toString()));       iv18.setOnMouseClicked(e -> chooseImg(TileEnum.SEWERFLOOR5.toString()));
        ImageView iv19 = new ImageView(new Image(TileEnum.SEWERFLOORLADDER.toString()));  iv19.setOnMouseClicked(e -> chooseImg(TileEnum.SEWERFLOORLADDER.toString()));
        ImageView iv20 = new ImageView(new Image(TileEnum.SEWERFLOORPIPE1.toString()));   iv20.setOnMouseClicked(e -> chooseImg(TileEnum.SEWERFLOORPIPE1.toString()));
        ImageView iv21 = new ImageView(new Image(TileEnum.SEWERFLOORPIPE2.toString()));   iv21.setOnMouseClicked(e -> chooseImg(TileEnum.SEWERFLOORPIPE2.toString()));
        ImageView iv22 = new ImageView(new Image(TileEnum.WALL_EAST.toString()));         iv22.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_EAST.toString()));
        ImageView iv23 = new ImageView(new Image(TileEnum.WALL_NORTH.toString()));        iv23.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_NORTH.toString()));
        ImageView iv24 = new ImageView(new Image(TileEnum.WALL_NORTH_EAST.toString()));   iv24.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_NORTH_EAST.toString()));
        ImageView iv25 = new ImageView(new Image(TileEnum.WALL_NORTH_LADDER.toString())); iv25.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_NORTH_LADDER.toString()));
        ImageView iv26 = new ImageView(new Image(TileEnum.WALL_NORTH_WEST.toString()));   iv26.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_NORTH_WEST.toString()));
        ImageView iv27 = new ImageView(new Image(TileEnum.WALL_SOUTH.toString()));        iv27.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_SOUTH.toString()));
        ImageView iv28 = new ImageView(new Image(TileEnum.WALL_SOUTH_EAST.toString()));   iv28.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_SOUTH_EAST.toString()));
        ImageView iv29 = new ImageView(new Image(TileEnum.WALL_SOUTH_WEST.toString()));   iv29.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_SOUTH_WEST.toString()));
        ImageView iv30 = new ImageView(new Image(TileEnum.WALL_WEST.toString()));         iv30.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_WEST.toString()));
        ImageView iv31 = new ImageView(new Image(TileEnum.WALL_WITH_PIPE.toString()));    iv31.setOnMouseClicked(e -> chooseImg(TileEnum.WALL_WITH_PIPE.toString()));
        ImageView iv32 = new ImageView(new Image(TileEnum.GRASS.toString()));             iv32.setOnMouseClicked(e -> chooseImg(TileEnum.GRASS.toString()));
        
        iv01.fitHeightProperty().bind(box1.widthProperty()); iv01.fitWidthProperty().bind(box1.widthProperty());
        iv02.fitHeightProperty().bind(box1.widthProperty()); iv02.fitWidthProperty().bind(box1.widthProperty());
        iv03.fitHeightProperty().bind(box1.widthProperty()); iv03.fitWidthProperty().bind(box1.widthProperty());
        iv04.fitHeightProperty().bind(box1.widthProperty()); iv04.fitWidthProperty().bind(box1.widthProperty());
        iv05.fitHeightProperty().bind(box1.widthProperty()); iv05.fitWidthProperty().bind(box1.widthProperty());
        iv06.fitHeightProperty().bind(box1.widthProperty()); iv06.fitWidthProperty().bind(box1.widthProperty());
        iv07.fitHeightProperty().bind(box1.widthProperty()); iv07.fitWidthProperty().bind(box1.widthProperty());
        iv08.fitHeightProperty().bind(box1.widthProperty()); iv08.fitWidthProperty().bind(box1.widthProperty());
        iv09.fitHeightProperty().bind(box1.widthProperty()); iv09.fitWidthProperty().bind(box1.widthProperty());
        iv10.fitHeightProperty().bind(box1.widthProperty()); iv10.fitWidthProperty().bind(box1.widthProperty());
        iv11.fitHeightProperty().bind(box1.widthProperty()); iv11.fitWidthProperty().bind(box1.widthProperty());
        iv12.fitHeightProperty().bind(box1.widthProperty()); iv12.fitWidthProperty().bind(box1.widthProperty());
        iv13.fitHeightProperty().bind(box1.widthProperty()); iv13.fitWidthProperty().bind(box1.widthProperty());
        iv14.fitHeightProperty().bind(box1.widthProperty()); iv14.fitWidthProperty().bind(box1.widthProperty());
        iv15.fitHeightProperty().bind(box1.widthProperty()); iv15.fitWidthProperty().bind(box1.widthProperty());
        iv16.fitHeightProperty().bind(box1.widthProperty()); iv16.fitWidthProperty().bind(box1.widthProperty());
        iv17.fitHeightProperty().bind(box1.widthProperty()); iv17.fitWidthProperty().bind(box1.widthProperty());
        iv18.fitHeightProperty().bind(box1.widthProperty()); iv18.fitWidthProperty().bind(box1.widthProperty());
        iv19.fitHeightProperty().bind(box1.widthProperty()); iv19.fitWidthProperty().bind(box1.widthProperty());
        iv20.fitHeightProperty().bind(box1.widthProperty()); iv20.fitWidthProperty().bind(box1.widthProperty());
        iv21.fitHeightProperty().bind(box1.widthProperty()); iv21.fitWidthProperty().bind(box1.widthProperty());
        iv22.fitHeightProperty().bind(box1.widthProperty()); iv22.fitWidthProperty().bind(box1.widthProperty());
        iv23.fitHeightProperty().bind(box1.widthProperty()); iv23.fitWidthProperty().bind(box1.widthProperty());
        iv24.fitHeightProperty().bind(box1.widthProperty()); iv24.fitWidthProperty().bind(box1.widthProperty());
        iv25.fitHeightProperty().bind(box1.widthProperty()); iv25.fitWidthProperty().bind(box1.widthProperty());
        iv26.fitHeightProperty().bind(box1.widthProperty()); iv26.fitWidthProperty().bind(box1.widthProperty());
        iv27.fitHeightProperty().bind(box1.widthProperty()); iv27.fitWidthProperty().bind(box1.widthProperty());
        iv28.fitHeightProperty().bind(box1.widthProperty()); iv28.fitWidthProperty().bind(box1.widthProperty());
        iv29.fitHeightProperty().bind(box1.widthProperty()); iv29.fitWidthProperty().bind(box1.widthProperty());
        iv30.fitHeightProperty().bind(box1.widthProperty()); iv30.fitWidthProperty().bind(box1.widthProperty());
        iv31.fitHeightProperty().bind(box1.widthProperty()); iv31.fitWidthProperty().bind(box1.widthProperty());
        iv32.fitHeightProperty().bind(box1.widthProperty()); iv31.fitWidthProperty().bind(box1.widthProperty());
        
        box1.getChildren().add(iv01);
        box1.getChildren().add(iv02);
        box1.getChildren().add(iv03);
        box1.getChildren().add(iv04);
        box1.getChildren().add(iv05);
        box1.getChildren().add(iv06);
        box1.getChildren().add(iv07);
        box1.getChildren().add(iv08);
        box1.getChildren().add(iv09);
        box1.getChildren().add(iv10);
        box1.getChildren().add(iv11);
        box1.getChildren().add(iv12);
        box1.getChildren().add(iv13);
        box1.getChildren().add(iv14);
        box1.getChildren().add(iv15);
        box1.getChildren().add(iv16);
        box2.getChildren().add(iv17);
        box2.getChildren().add(iv18);
        box2.getChildren().add(iv19);
        box2.getChildren().add(iv20);
        box2.getChildren().add(iv21);
        box2.getChildren().add(iv22);
        box2.getChildren().add(iv23);
        box2.getChildren().add(iv24);
        box2.getChildren().add(iv25);
        box2.getChildren().add(iv26);
        box2.getChildren().add(iv27);
        box2.getChildren().add(iv28);
        box2.getChildren().add(iv29);
        box2.getChildren().add(iv30);
        box2.getChildren().add(iv31);
    }

    private void chooseImg(String s) {
        setTile = s;
        System.err.println("s: " + setTile);
    }

    @FXML
    private void setImg(MouseEvent e) {
        ImageView iv = (ImageView) e.getSource();
        String s = iv.getId().substring(1,5);
        Image i = new Image(setTile);
        iv.setImage(i);
        System.out.println("place: " + s + ", tile: " + setTile);
        levelMap.put(s, setTile);
    }
    
    private void setImg(String place, String tile) {
        // Worst performing hack ever ;)
        viewGrid.getChildren().forEach(e -> {
            ImageView iv = (ImageView) e;
            System.out.println("iv.getId() " + iv.getId());
            if(iv.getId().substring(1,5).equals(place)) {
                iv.setImage(new Image(tile));
            }
        });
        levelMap.put(place, tile);
    }
    
    @FXML
    private void saveMap() {
        boolean b = data.saveMap(levelMap);
        System.out.println("files saved = " + b);
    }
    
    @FXML
    private void loadMap() {
        if(data.loadMap() != null) {
            levelMap = data.loadMap();
        }
    }
    
    private void updateView() {
        levelMap.forEach((k,v) -> {
            setImg(k, v);
        });
    }
}
