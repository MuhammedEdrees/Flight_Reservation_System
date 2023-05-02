package data;

import model.Admin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AdminTest {
    public AdminTest() {
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
     * Test of create method, of class Admin.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Admin actual = new Admin("Mohammed", "Mohammed104", "Mohammed101", "Mohammed101@test.com");
        actual.create();
        int instanceId = actual.getId();
        Admin expected = new Admin(instanceId);
        boolean thrown = false;
        try {
            expected.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertEquals(expected, actual);
        assertFalse(thrown);
    }

    /**
     * Test of update method, of class Admin.
     */
    @Test
    public void testUpdate(){
        System.out.println("update");
        Admin actual = new Admin("Mohammed", "Mohammed102", "Mohammed101", "Mohammed101@test.com");
        actual.create();
        String newName = "Ahmed";
        actual.setFullname(newName);
        actual.update();
        Admin expected = new Admin(actual.getId());
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
     * Test of read method, of class Admin.
     */
    @Test
    public void testReadForExistingId(){
        System.out.println("read");
        Admin instance = new Admin(1);
        boolean thrown = false;
        try {
            instance.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertEquals(instance.getEmail(), "admin@test.com");
        assertFalse(thrown);
    }
    @Test
    public void testReadForNonExistingId(){
        System.out.println("read");
        Admin instance = new Admin(10);
        boolean thrown = false;
        try {
            instance.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Test of delete method, of class Admin.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Admin actual = new Admin("Mohammed", "Mohammed103", "Mohammed101", "Mohammed101@test.com");
        actual.create();
        int instanceId = actual.getId();
        actual.delete();
        Admin expected = new Admin(instanceId);
        boolean thrown = false;
        try {
            expected.read();
        } catch (Exception ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    
}
