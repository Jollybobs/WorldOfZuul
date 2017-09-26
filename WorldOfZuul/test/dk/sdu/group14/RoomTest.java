package dk.sdu.group14;

import org.junit.Before;
import org.junit.Test;

import com.framework.WorldOfZuul.Room;

/**
 *
 * @author jphj
 */
public class RoomTest {
    
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
    public void testRooms() throws Exception {
        aRoom1.setExit("east", aRoom1);
        aRoom1.getExit("east");
    }
    
}