/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author orgho
 */
public class QuadrantTest {

    public QuadrantTest() {
    }

    /**
     * Test of contains method, of class Quadrant.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        double[] midpoint = {10.0, 10.0};
        Quadrant instance = new Quadrant(new double[]{5.0, 5.0}, 15.0);
        boolean expResult = true;
        boolean result = instance.contains(midpoint);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of NW method, of class Quadrant.
     */
    @Test
    public void testNW() {
        System.out.println("NW");
        Quadrant instance = new Quadrant(new double[]{5.0, 5.0}, 10.0);
        Quadrant expResult = new Quadrant(new double[]{2.5, 7.5}, 5.0);
        Quadrant result = instance.NW();
        assertEquals(expResult.getMidpoint()[0], result.getMidpoint()[0], 0.1);
        assertEquals(expResult.getMidpoint()[1], result.getMidpoint()[1], 0.1);
        assertEquals(expResult.getLength(), result.getLength(), 0.1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of NE method, of class Quadrant.
     */
    @Test
    public void testNE() {
        System.out.println("NE");
        Quadrant instance = new Quadrant(new double[]{5.0, 5.0}, 10.0);
        Quadrant expResult = new Quadrant(new double[]{7.5, 7.5}, 5.0);
        Quadrant result = instance.NE();
        assertEquals(expResult.getMidpoint()[0], result.getMidpoint()[0], 0.1);
        assertEquals(expResult.getMidpoint()[1], result.getMidpoint()[1], 0.1);
        assertEquals(expResult.getLength(), result.getLength(), 0.1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SE method, of class Quadrant.
     */
    @Test
    public void testSE() {
        System.out.println("SE");
        Quadrant instance = new Quadrant(new double[]{5.0, 5.0}, 10.0);
        Quadrant expResult = new Quadrant(new double[]{7.5, 2.5}, 5.0);
        Quadrant result = instance.SE();
        assertEquals(expResult.getMidpoint()[0], result.getMidpoint()[0], 0.1);
        assertEquals(expResult.getMidpoint()[1], result.getMidpoint()[1], 0.1);
        assertEquals(expResult.getLength(), result.getLength(), 0.1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SW method, of class Quadrant.
     */
    @Test
    public void testSW() {
        System.out.println("SW");
        Quadrant instance = new Quadrant(new double[]{5.0, 5.0}, 10.0);
        Quadrant expResult = new Quadrant(new double[]{2.5, 2.5}, 5.0);
        Quadrant result = instance.SW();
        assertEquals(expResult.getMidpoint()[0], result.getMidpoint()[0], 0.1);
        assertEquals(expResult.getMidpoint()[1], result.getMidpoint()[1], 0.1);
        assertEquals(expResult.getLength(), result.getLength(), 0.1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
