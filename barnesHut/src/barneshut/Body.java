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

    public void update(double dt) {
        for (int i = 0; i < this.velocity.length; i++) {
            this.velocity[i] += dt * (this.force[i] / mass);
            this.position[i] += dt * this.velocity[i];
        }
    }

    public double distanceTo(Body b) {
        return Math.sqrt((this.position[0] - b.position[0]) * (this.position[0] - b.position[0]) + (this.position[1] - b.position[1]) * (this.position[1] - b.position[1]));
    }

    public double[] resetForce() {
        this.force[0] = 0.0;
        this.force[0] = 0.0;
        return this.force;
    }

    public double[] addForce(Body b) {
        double softener = 3E4; //acts as a dampener to prevent infinity values
        double[] distanceVector = {b.position[0] - this.position[0], b.position[1] - this.position[1]};
        double distance = distanceTo(b);
        double F = (G * this.mass * b.mass) / (distance * distance + softener * softener);
        this.force[0] = F * distanceVector[0] / distance;
        this.force[1] = F * distanceVector[0] / distance;
        return this.force;
    }

    @Override
    public String toString() {
        return this.position[0] + ", " + this.position[1] + ", " + this.velocity[0] + ", " + this.velocity[1] + ", " + this.mass;
    }

}
