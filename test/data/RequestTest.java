package data;

import model.Request;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RequestTest {
    
    public RequestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class Request.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Request actual = new Request("Mohammed", "Mohammed101", "Mohammed101@test.com", "01xxxxxxxxx");
        actual.create();
        int instanceId = actual.getId();
        Request expected = new Request(instanceId);
        boolean thrown = false;
        try {
            expected.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertEquals(expected.getUsername(), actual.getUsername());
        assertFalse(thrown);
    }

    /**
     * Test of update method, of class Request.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Request actual = new Request("Mohammed", "Mohammed102",  "Mohammed101@test.com", "010xxxxxxxxx");
        actual.create();
        String newName = "Ahmed";
        actual.setFullname(newName);
        actual.update();
        Request expected = new Request(actual.getId());
        boolean thrown = false;
        try {
            expected.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertEquals(expected.getFullname(), newName);
        assertFalse(thrown);
    }

    /**
     * Test of read method, of class Request.
     */
    @Test
    public void testReadForValidId() {
        System.out.println("readValid");
        Request instance = new Request(1);
        boolean thrown = false;
        try {
            instance.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertEquals(instance.getEmail(), "Mohammed");
        assertFalse(thrown);
    }

    @Test
    public void testReadForInvalidId(){
        System.out.println("readInvalid");
        Request instance = new Request(10);
        boolean thrown = false;
        try {
            instance.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    
    /**
     * Test of delete method, of class Request.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Request actual = new Request("Mohammed", "Mohammed103",  "Mohammed101@test.com", "01xxxxxxxxx");
        actual.create();
        int instanceId = actual.getId();
        actual.delete();
        Request expected = new Request(instanceId);
        boolean thrown = false;
        try {
            expected.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    
    
}
