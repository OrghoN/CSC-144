/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

import org.junit.Test;

/**
 *
 * @author orgho
 */
public class BHTreeTest {

    public BHTreeTest() {
    }

    /**
     * Test of isExternal method, of class BHTree.
     */
    @Test
    public void testIsExternal() {
        System.out.println("isExternal");
        BHTree tree = null;
        BHTree instance = null;
        Boolean expResult = null;
        Boolean result = instance.isExternal(tree);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class BHTree.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Body b = null;
        BHTree instance = null;
        instance.insert(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateForce method, of class BHTree.
     */
    @Test
    public void testUpdateForce() {
        System.out.println("updateForce");
        Body b = null;
        BHTree instance = null;
        instance.updateForce(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BHTree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BHTree instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
