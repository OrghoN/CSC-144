/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author orgho
 */
public class BodyTest {

    public BodyTest() {
    }

    Body a = new Body(new double[]{0.0, 0.0}, new double[]{1.0, 0.0}, 1.98892e30, Color.GREEN);
    Body a2 = new Body(new double[]{3.0, 4.0}, new double[]{0.0, 0.0}, 1.98892e30, Color.RED);

    /**
     * Test of update method, of class Body.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        double dt = 5.0;
        Body instance = new Body(new double[]{0.0, 0.0}, new double[]{1.0, 0.0}, 1.98892e30, Color.GREEN);;
        instance.update(dt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distanceTo method, of class Body.
     */
    @Test
    public void testDistanceTo() {
        System.out.println("distanceTo");
        Body b = new Body(new double[]{3.0, 4.0}, new double[]{0.0, 0.0}, 1.98892e30, Color.RED);;
        Body instance = new Body(new double[]{0.0, 0.0}, new double[]{1.0, 0.0}, 1.98892e30, Color.GREEN);;
        double expResult = 5.0;
        double result = instance.distanceTo(b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail(expResult + "||" + result);
    }

    /**
     * Test of resetForce method, of class Body.
     */
    @Test
    public void testResetForce() {
        System.out.println("resetForce");
        Body instance = new Body(new double[]{0.0, 0.0}, new double[]{1.0, 0.0}, 1.98892e30, Color.GREEN);;
        double[] expResult = new double[]{0.0, 0.0};
        double[] result = instance.resetForce();
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addForce method, of class Body.
     */
    @Test
    public void testAddForce() {
        System.out.println("addForce");
        Body b = new Body(new double[]{3.0, 4.0}, new double[]{0.0, 0.0}, 1.98892e30, Color.RED);;
        Body instance = new Body(new double[]{0.0, 0.0}, new double[]{1.0, 0.0}, 1.98892e30, Color.GREEN);;
        double[] expResult = {1.76E10, 2.35E10};
        double[] result = instance.addForce(b);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Body.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Body instance = new Body(new double[]{0.0, 0.0}, new double[]{1.0, 0.0}, 1.98892e30, Color.GREEN);;
        String expResult = "0.0, 0.0, 1.0, 0.0, 1.98892E30";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail(expResult + "||" + result);
    }

}
