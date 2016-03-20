/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

import java.awt.Color;

/**
 * Class defining each body in the universe
 *
 * @author orgho
 */
public class Body {

    private static final double G = 6.673e-11; //gravitational constant
    private static final double SOLAR_MASS = 1.98892e30; //standard unit equal to mass of sun

    private double[] position = new double[2];
    private double[] velocity = new double[2];
    private double[] force = new double[2];
    private double mass;
    private Color color;

    public Body(double[] position, double[] velocity, double mass, Color color) {
        this.position = position;
        this.velocity = velocity;
        this.mass = mass;
        this.color = color;
    }

    public double[] update(double dt) {

        return new double[]{this.position[0], this.position[1], this.velocity[0], this.velocity[1]};
    }

    public double distanceTo(Body b) {
        return 0.0;
    }

    public double[] resetForce() {
        return this.force;
    }

    public double[] addForce(Body b) {
        return this.force;
    }

    @Override
    public String toString() {
        return "";
    }

}
