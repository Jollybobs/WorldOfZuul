
package business;

import java.util.ArrayList;

/**
 *
 * @author 103020
 */
public class Guard {
    ArrayList<String> guardPath;
    String guardPosition;
    boolean iterateForward;
    int index;
    
    
    /**
     * A guard to patrol the map.
     * 
     */
    public Guard(){
        initGuardPath();
        guardPosition = "2207";
        iterateForward = true;
    }
    
    /**
     * Moves to the next room on the list but only if there was added a room to the Room[] patrol
     */
    public void move(){
        index = guardPath.indexOf(guardPosition);
        if(guardPosition.equals("2207")) {
            iterateForward = true;
        }
        if(guardPosition.equals("2117")) {
            iterateForward = false;
        }
        if(iterateForward) {
            guardPosition = guardPath.get(index+1);
        } else  {
            guardPosition = guardPath.get(index-1);
        }
    }
    
    /**
     *  Getter for the Guard's path.
     * 
     * @return ArrayList of positions.
     */
    public ArrayList getGuardPath() {
        return guardPath;
    }

    /**
     * Initiate an ArrayList of positions (a path) for the Guard to walk on.
     * 
     * @return ArrayList<String> of positions.
     */
    private ArrayList initGuardPath() {
        guardPath = new ArrayList();
        guardPath.add("2207");
        guardPath.add("2107");
        guardPath.add("2007");
        guardPath.add("1907");
        guardPath.add("1807");
        guardPath.add("1707");
        guardPath.add("1708");
        guardPath.add("1709");
        guardPath.add("1710");
        guardPath.add("1711");
        guardPath.add("1712");
        guardPath.add("1713");
        guardPath.add("1714");
        guardPath.add("1715");
        guardPath.add("1716");
        guardPath.add("1717");
        guardPath.add("1817");
        guardPath.add("1917");
        guardPath.add("2017");
        guardPath.add("2117");
        guardPath.add("2217");
        return guardPath;
    }
    
    /**
     * Guards current position.
     * 
     * @return String with position.
     */
    public String getPosition(){
        return guardPosition;
    }

    void stop() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
