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

    /**
     * Constructor for a new Body object
     *
     * @param position the cartesian coordinates of the position [x,y]
     * @param velocity the velocity components [x,y]
     * @param mass the mass of the body
     * @param color the color of the orb drawn
     */
    public Body(double[] position, double[] velocity, double mass, Color color) {
        this.position = position;
        this.velocity = velocity;
        this.mass = mass;
        this.color = color;
    }

    /**
     * Update velocity and position of the body
     *
     * @param dt the timestamp used
     */
    public void update(double dt) {
        for (int i = 0; i < this.velocity.length; i++) {
            this.velocity[i] += dt * (this.force[i] / mass);
            this.position[i] += dt * this.velocity[i];
        }
    }

    /**
     * calculate distance between 2 bodies
     *
     * @param b the body to which distance is calculated
     * @return Distance to body b
     */
    public double distanceTo(Body b) {
        return Math.sqrt((this.position[0] - b.position[0]) * (this.position[0] - b.position[0]) + (this.position[1] - b.position[1]) * (this.position[1] - b.position[1]));
    }

    /**
     * Resets both components of the force to 0
     *
     * @return force acting on body
     */
    public double[] resetForce() {
        this.force[0] = 0.0;
        this.force[0] = 0.0;
        return this.force;
    }

    /**
     * add force acting between this and another body and add it to the net
     * force acting on this body
     *
     * @param b the body with regards to which force is calculated
     * @return force acting on this body
     */
    public double[] addForce(Body b) {
        double softener = 3E4; //acts as a dampener to prevent infinity values
        double[] distanceVector = {b.position[0] - this.position[0], b.position[1] - this.position[1]};
        double distance = distanceTo(b);
        double F = (G * this.mass * b.mass) / (distance * distance + softener * softener);
        this.force[0] = F * distanceVector[0] / distance;
        this.force[1] = F * distanceVector[1] / distance;
        return this.force;
    }

    /**
     * Checks if this body is in a quadrant
     *
     * @param q The quadrant to be checked against
     * @return A boolean reflecting if the body is in the quadrant
     */
    public boolean in(Quadrant q) {
        return q.contains(this.position);
    }

    @Override
    public String toString() {
        return this.position[0] + ", " + this.position[1] + ", " + this.velocity[0] + ", " + this.velocity[1] + ", " + this.mass;
    }

    /**
     * @return the position
     */
    public double[] getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(double[] position) {
        this.position = position;
    }

    /**
     * @return the velocity
     */
    public double[] getVelocity() {
        return velocity;
    }

    /**
     * @param velocity the velocity to set
     */
    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    /**
     * @return the force
     */
    public double[] getForce() {
        return force;
    }

    /**
     * @param force the force to set
     */
    public void setForce(double[] force) {
        this.force = force;
    }

    /**
     * @return the mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
