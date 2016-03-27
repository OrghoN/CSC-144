/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

import edu.princeton.cs.In;
import edu.princeton.cs.StdDraw;
import java.awt.Color;

/**
 * A Class that simulates the universe using a barnes hut tree
 *
 * @author orgho
 */
public class BarnesHut {

    /**
     * Draws the actual universe
     *
     * @param args[0] The rate at which time progresses in the universe
     * @param args[1] The size of the planets
     * @param args[2] The Text File Describing the sequence of planets
     */
    public static void main(String[] args) {

//        final double dt = Double.parseDouble(args[0]);
//        final double PLANET_SIZE = Double.parseDouble(args[1]);
//        In console = new In(args[2]);
        final double dt = 0.1;
        final double PLANET_SIZE = 0.004;
        In console = new In("galaxy3.txt");

        int N = console.readInt();
        double radius = console.readDouble();

        StdDraw.show(0);
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        Body[] bodies = new Body[N];
        for (int i = 0; i < N; i++) {
            double px = console.readDouble();
            double py = console.readDouble();
            double vx = console.readDouble();
            double vy = console.readDouble();
            double mass = console.readDouble();
            int red = console.readInt();
            int green = console.readInt();
            int blue = console.readInt();
            Color color = new Color(red, green, blue);
            bodies[i] = new Body(new double[]{px, py}, new double[]{vx, vy}, mass, color);
        }

        for (double t = 0.0; true; t = t + dt) {

            Quadrant quad = new Quadrant(new double[]{0, 0}, radius * 2);
            BHTree tree = new BHTree(quad);

            // build the Barnes-Hut tree
            for (int i = 0; i < N; i++) {
                if (bodies[i].in(quad)) {
                    tree.insert(bodies[i]);
                }
            }

            for (int i = 0; i < N; i++) {
                bodies[i].resetForce();
                tree.updateForce(bodies[i]);
                bodies[i].update(dt);
            }

            StdDraw.clear(StdDraw.BLACK);
            for (int i = 0; i < N; i++) {
                bodies[i].draw(PLANET_SIZE);
            }

            StdDraw.show(10);
        }
    }
}
