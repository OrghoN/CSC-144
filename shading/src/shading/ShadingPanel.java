package shading;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class ShadingPanel extends JPanel {

    private static final Color BG_COLOR = new Color(172, 224, 180);
    private static final int RED = 180;
    private static final int GREEN = 192;
    private static final int BLUE = 248;

    public ShadingPanel() {
        this.setBackground(BG_COLOR);
    } // ShadingPanel()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(1, 1);

        AffineTransform scale = new AffineTransform();
        scale.setToScale(w / 2, h / 2);

        AffineTransform transform = new AffineTransform();
        transform.concatenate(scale);
        transform.concatenate(translate);

        Vector3D illumination = new Vector3D(1.0, 2.0, 3.0);
        illumination = illumination.normalize();

        for (Triangle t : makeTriangles()) {
            double dotProduct = t.getNormal().dot(illumination);
            if (dotProduct < 0.0) {
                dotProduct = 0.0;
            } // if

            int redValue = (int) (RED * dotProduct);
            int greenValue = (int) (GREEN * dotProduct);
            int blueValue = (int) (BLUE * dotProduct);

            Color color = new Color(redValue, greenValue, blueValue);
            g2D.setColor(color);
            Shape shape = t.getShape();
            g2D.fill(transform.createTransformedShape(shape));
        } // for
    } // paintComponent( Graphics )

    private List<Triangle> makeTriangles() {
        List<Triangle> triangles = new LinkedList<>();

        double x = -1.0;
        double y = 0.0;
        double z = 0.0;
        Vector3D west = new Vector3D(x, y, z);

        x = 0.0;
        y = 0.0;
        z = 1.0;
        Vector3D center = new Vector3D(x, y, z);

        x = 0.0;
        y = 1.0;
        z = 0.0;
        Vector3D north = new Vector3D(x, y, z);

        x = 1.0;
        y = 0.0;
        z = 0.0;
        Vector3D east = new Vector3D(x, y, z);

        x = 0.0;
        y = -1.0;
        z = 0.0;
        Vector3D south = new Vector3D(x, y, z);

        Triangle triangle = new Triangle(west, center, north);
        triangles.addAll(triangle.subdivide());

        triangle = new Triangle(center, east, north);
        triangles.addAll(triangle.subdivide());

        triangle = new Triangle(south, center, west);
        triangles.addAll(triangle.subdivide());

        triangle = new Triangle(south, east, center);
        triangles.addAll(triangle.subdivide());

        return triangles;
    } // makeTriangles()

} // ShadingPanel
