package dk.sdu.group14;


import Business.ExitDirection;
import org.junit.Before;
import org.junit.Test;

import Business.Room;

/**
 *
 * @author group 14.
 */
public class Tests {
    
    Room aRoom1;
    Room aRoom2;
    
    @Before
    public void setup() {
        
        aRoom1 = new Room("roomStart");
        aRoom2 = new Room("roomEast");
    }
    
    /**
     * Testing rooms
     * 
     * @throws Exception 
     */
    @Test
    public void testRoom1() throws Exception {
        
//        aRoom1.setExit(ExitDirection.EAST, aRoom2);
//        aRoom1.getExit(ExitDirection.EAST);
    }
    
    /**
     * Testing rooms
     * 
     * @throws Exception 
     */
    @Test
    public void testRoom2() throws Exception {
        
//        aRoom2.setExit(ExitDirection.WEST, aRoom1);
//        aRoom2.getExit(ExitDirection.WEST);
    }
    
}