package shading;

import static org.junit.Assert.*;
import org.junit.Test;

public class Vector3DTest {

    private static final double EPSILON = 1E-3;

    public Vector3DTest() {
    } // Vector3DTest()

    /**
     * Test of getX method, of class Vector3D.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Vector3D instance = new Vector3D(1, 2, 3);
        double expResult = 1;
        double result = instance.getX();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } // testGetX()

    /**
     * Test of getY method, of class Vector3D.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Vector3D instance = new Vector3D(1, 2, 3);
        double expResult = 2;
        double result = instance.getY();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    } // testGetY()

    /**
     * Test of getZ method, of class Vector3D.
     */
    @Test
    public void testGetZ() {
        System.out.println("getZ");
        Vector3D instance = new Vector3D(1, 2, 3);
        double expResult = 3;
        double result = instance.getZ();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    } // testGetZ()

    /**
     * Test of add method, of class Vector3D.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector3D v = new Vector3D(1, 2, 3);
        Vector3D instance = new Vector3D(1, 2, 3);
        Vector3D expResult = new Vector3D(2, 4, 6);
        Vector3D result = instance.add(v);
        assertEquals(expResult.getX(), result.getX(), EPSILON);
        assertEquals(expResult.getY(), result.getY(), EPSILON);
        assertEquals(expResult.getZ(), result.getZ(), EPSILON);
        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    } // testAdd()

    /**
     * Test of subtract method, of class Vector3D.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Vector3D v = new Vector3D(2, 4, 6);
        Vector3D instance = new Vector3D(1, 2, 3);
        Vector3D expResult = new Vector3D(-1, -2, -3);
        Vector3D result = instance.subtract(v);
        assertEquals(expResult.getX(), result.getX(), EPSILON);
        assertEquals(expResult.getY(), result.getY(), EPSILON);
        assertEquals(expResult.getZ(), result.getZ(), EPSILON);

        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } // testSubtract()

    /**
     * Test of scale method, of class Vector3D.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        double s = 2.0;
        Vector3D instance = new Vector3D(1, 2, 3);
        Vector3D expResult = new Vector3D(2, 4, 6);
        Vector3D result = instance.scale(s);
        assertEquals(expResult.getX(), result.getX(), EPSILON);
        assertEquals(expResult.getY(), result.getY(), EPSILON);
        assertEquals(expResult.getZ(), result.getZ(), EPSILON);

        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    } // testScale()

    /**
     * Test of dot method, of class Vector3D.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        Vector3D v = new Vector3D(3, 2, 3);
        Vector3D instance = new Vector3D(1, 2, 3);
        double expResult = 16;
        double result = instance.dot(v);
        assertEquals(expResult, result, EPSILON);

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    } // testDot()

    /**
     * Test of magnitude method, of class Vector3D.
     */
    @Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector3D instance = new Vector3D(1, 3, 4);
        double expResult = 5.0990;
        double result = instance.magnitude();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    } // testMagnitude()

    /**
     * Test of normalize method, of class Vector3D.
     */
    @Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector3D instance = new Vector3D(3, 1, 2);
        Vector3D expResult = new Vector3D(0.802, 0.267, 0.534);
        Vector3D result = instance.normalize();
        assertEquals(expResult.getX(), result.getX(), EPSILON);
        assertEquals(expResult.getY(), result.getY(), EPSILON);
        assertEquals(expResult.getZ(), result.getZ(), EPSILON);

        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    } // testNormalize()

    /**
     * Test of cross method, of class Vector3D.
     */
    @Test
    public void testCross() {
        System.out.println("cross");
        Vector3D v = new Vector3D(3, -3, 1);;
        Vector3D instance = new Vector3D(4, 9, 2);;
        Vector3D expResult = new Vector3D(15, 2, -39);;
        Vector3D result = instance.cross(v);
        assertEquals(expResult.getX(), result.getX(), EPSILON);
        assertEquals(expResult.getY(), result.getY(), EPSILON);
        assertEquals(expResult.getZ(), result.getZ(), EPSILON);

        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    } // testCross()

} // Vector3DTest
