package acquaintance;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 103020
 */
public interface IData {

    boolean save(List aList);

    List load();
    
    boolean saveMap(HashMap aMap);

    HashMap loadMap();

    boolean saveScore(List hList);

    List loadScore();
}
