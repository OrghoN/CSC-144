package shading;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.LinkedList;
import java.util.List;

public class Triangle {

    private static final double RECURSION_LIMIT = 5;

    private final Vector3D p0;
    private final Vector3D p1;
    private final Vector3D p2;

    public Triangle(Vector3D p0, Vector3D p1, Vector3D p2) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
    } // Triangle( Vector3D, Vector3D, Vector3D )

    public List<Triangle> subdivide() {
        return subdivide(0);
    } // subdivide()

    public List<Triangle> subdivide(int recursionCount) {
        List<Triangle> triangles = new LinkedList<>();
        return subdivide(triangles, recursionCount);
    } // subdivide()

    public List<Triangle> subdivide(List<Triangle> triangles,
            int recursionCount) {
        recursionCount = recursionCount + 1;

        if (recursionCount > RECURSION_LIMIT) {
            triangles.add(this);
        } // if
        else {
            Vector3D p0p1 = (p0.add(p1)).scale(0.5);
            p0p1 = p0p1.normalize();

            Vector3D p1p2 = (p1.add(p2)).scale(0.5);
            p1p2 = p1p2.normalize();

            Vector3D p2p0 = (p2.add(p0)).scale(0.5);
            p2p0 = p2p0.normalize();

            Triangle lowerLeft = new Triangle(p0, p0p1, p2p0);
            Triangle lowerRight = new Triangle(p0p1, p1, p1p2);
            Triangle top = new Triangle(p2p0, p1p2, p2);
            Triangle center = new Triangle(p0p1, p1p2, p2p0);

            triangles.addAll(lowerLeft.subdivide(recursionCount));
            triangles.addAll(lowerRight.subdivide(recursionCount));
            triangles.addAll(top.subdivide(recursionCount));
            triangles.addAll(center.subdivide(recursionCount));
        } // else
        return triangles;
    } // subdivide( List<Triangle> )

    public double getSize() {
        double p0p1 = (p0.subtract(p1)).magnitude();
        double p1p2 = (p1.subtract(p2)).magnitude();
        double p2p0 = (p2.subtract(p0)).magnitude();

        return Math.max(p0p1, Math.max(p1p2, p2p0));
    } // getSize()

    public Vector3D getNormal() {
        Vector3D p0p1 = (p1.subtract(p0));
        Vector3D p0p2 = (p2.subtract(p0));

        return (p0p1.cross(p0p2)).normalize();
    } // getNormal()

    public Shape getShape() {
        GeneralPath path = new GeneralPath();
        double x = this.p0.getX();
        double y = this.p0.getY();
        path.moveTo(x, y);

        x = this.p1.getX();
        y = this.p1.getY();
        path.lineTo(x, y);

        x = this.p2.getX();
        y = this.p2.getY();
        path.lineTo(x, y);

        path.closePath();

        return path;
    } // getShape()

    @Override
    public String toString() {
        return "Triangle: [" + p0 + "," + p1 + "," + p2
                + "] normal = " + getNormal();
    } // toString()
} // Triangle
