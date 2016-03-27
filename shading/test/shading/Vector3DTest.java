
package shading;

import org.junit.Test;
import static org.junit.Assert.*;


public class Vector3DTest {
    private static final double EPSILON = 1E-8;
    
    public Vector3DTest() {
    } // Vector3DTest()

    /**
     * Test of getX method, of class Vector3D.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Vector3D instance = null;
        double expResult = 0.0;
        double result = instance.getX();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testGetX()

    /**
     * Test of getY method, of class Vector3D.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Vector3D instance = null;
        double expResult = 0.0;
        double result = instance.getY();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testGetY()

    /**
     * Test of getZ method, of class Vector3D.
     */
    @Test
    public void testGetZ() {
        System.out.println("getZ");
        Vector3D instance = null;
        double expResult = 0.0;
        double result = instance.getZ();
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testGetZ()

    /**
     * Test of add method, of class Vector3D.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector3D v = null;
        Vector3D instance = null;
        Vector3D expResult = null;
        Vector3D result = instance.add(v);
        
        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testAdd()

    /**
     * Test of subtract method, of class Vector3D.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Vector3D v = null;
        Vector3D instance = null;
        Vector3D expResult = null;
        Vector3D result = instance.subtract(v);
        
        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testSubtract()

    /**
     * Test of scale method, of class Vector3D.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        double s = 0.0;
        Vector3D instance = null;
        Vector3D expResult = null;
        Vector3D result = instance.scale(s);
        
        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testScale()

    /**
     * Test of dot method, of class Vector3D.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        Vector3D v = null;
        Vector3D instance = null;
        double expResult = 0.0;
        double result = instance.dot(v);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testDot()

    /**
     * Test of magnitude method, of class Vector3D.
     */
    @Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector3D instance = null;
        double expResult = 0.0;
        double result = instance.magnitude();        
        assertEquals(expResult, result, EPSILON);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testMagnitude()

    /**
     * Test of normalize method, of class Vector3D.
     */
    @Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector3D instance = null;
        Vector3D expResult = null;
        Vector3D result = instance.normalize();
        
        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testNormalize()

    /**
     * Test of cross method, of class Vector3D.
     */
    @Test
    public void testCross() {
        System.out.println("cross");
        Vector3D v = null;
        Vector3D instance = null;
        Vector3D expResult = null;
        Vector3D result = instance.cross(v);
        
        // To test equality of two vectors, test the equality
        // of the x, y, and z components of the two vectors.
        // Add 3 calls to assertEquals() here to test the equality
        // of the x, y, and z components of the two vectors.
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } // testCross()
    
} // Vector3DTest
