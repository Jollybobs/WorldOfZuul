package dk.sdu.group14;

import org.junit.Before;
import org.junit.Test;

import com.framework.WorldOfZuul.Room;

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
        
        aRoom1.setExit("east", aRoom2);
        aRoom1.getExit("east");
    }
    
    /**
     * Testing rooms
     * 
     * @throws Exception 
     */
    @Test
    public void testRoom2() throws Exception {
        
        aRoom2.setExit("west", aRoom1);
        aRoom2.getExit("west");
    }
    
}