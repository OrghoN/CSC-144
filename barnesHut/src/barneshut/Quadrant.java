/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

import edu.princeton.cs.StdDraw;

/**
 *
 * @author orgho
 */
public class Quadrant {

    private double[] midpoint = new double[2];
    private double length;

    /**
     * Create a New quadrant of Space
     *
     * @param midpoint The midpoint of the quadrant [x,y]
     * @param length The length of the Quadrant
     */
    public Quadrant(double[] midpoint, double length) {
        this.midpoint = midpoint;
        this.length = length;
    }

    /**
     * Checks if a given point is in a quadrant
     *
     * @param point the point to be checked against
     * @return a boolean indicating whether the point is in the quadrant
     */
    public boolean contains(double[] point) {
        return (point[0] <= this.midpoint[0] + this.length / 2.0 && point[0] >= this.midpoint[0] - this.length / 2.0 && point[1] <= this.midpoint[1] + this.length / 2.0 && point[1] >= this.midpoint[1] - this.length / 2.0);
    }

    /**
     * Returns the NorthWest Quadrant of the Larger Quadrant
     *
     * @return the NorthWest Quadrant of the Larger Quadrant
     */
    public Quadrant NW() {
        Quadrant newQuardant = new Quadrant(new double[]{this.midpoint[0] - this.length / 4.0, this.midpoint[1] + this.length / 4.0}, this.length / 2.0);
        return newQuardant;
    }

    /**
     * Returns the NorthEast Quadrant of the Larger Quadrant
     *
     * @return the NorthEast Quadrant of the Larger Quadrant
     */
    public Quadrant NE() {
        Quadrant newQuardant = new Quadrant(new double[]{this.midpoint[0] + this.length / 4.0, this.midpoint[1] + this.length / 4.0}, this.length / 2.0);
        return newQuardant;
    }

    /**
     * Returns the SouthhEast Quadrant of the Larger Quadrant
     *
     * @return the SouthEast Quadrant of the Larger Quadrant
     */
    public Quadrant SE() {
        Quadrant newQuardant = new Quadrant(new double[]{this.midpoint[0] + this.length / 4.0, this.midpoint[1] - this.length / 4.0}, this.length / 2.0);
        return newQuardant;
    }

    /**
     * Returns the SouthWest Quadrant of the Larger Quadrant
     *
     * @return the SouthWest Quadrant of the Larger Quadrant
     */
    public Quadrant SW() {
        Quadrant newQuardant = new Quadrant(new double[]{this.midpoint[0] - this.length / 4.0, this.midpoint[1] - this.length / 4.0}, this.length / 2.0);
        return newQuardant;
    }

    public void draw() {
        StdDraw.rectangle(this.midpoint[0], this.midpoint[1], this.length / 2, this.length / 2);
    }

    /**
     * @return the midpoint
     */
    public double[] getMidpoint() {
        return midpoint;
    }

    /**
     * @param midpoint the midpoint to set
     */
    public void setMidpoint(double[] midpoint) {
        this.midpoint = midpoint;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

}
