/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

/**
 *
 * @author orgho
 */
public class Quadrant {

    private double[] midpoint = new double[2];
    private double length;

    public Quadrant(double[] midpoint, double length) {
        this.midpoint = midpoint;
        this.length = length;
    }

    public boolean contains(double[] midpoint) {
        return (midpoint[0] <= this.midpoint[0] + this.length / 2.0 && midpoint[0] >= this.midpoint[0] - this.length / 2.0 && midpoint[1] <= this.midpoint[1] + this.length / 2.0 && midpoint[1] >= this.midpoint[1] - this.length / 2.0);

    }

    public Quadrant NW() {
        Quadrant newQuardant = new Quadrant(new double[]{this.midpoint[0] - this.length / 4.0, this.midpoint[1] + this.length / 4.0}, this.length / 2.0);
        return newQuardant;
    }

    public Quadrant NE() {
        Quadrant newQuardant = new Quadrant(new double[]{this.midpoint[0] + this.length / 4.0, this.midpoint[1] + this.length / 4.0}, this.length / 2.0);
        return newQuardant;
    }

    public Quadrant SE() {
        Quadrant newQuardant = new Quadrant(new double[]{this.midpoint[0] + this.length / 4.0, this.midpoint[1] - this.length / 4.0}, this.length / 2.0);
        return newQuardant;
    }

    public Quadrant SW() {
        Quadrant newQuardant = new Quadrant(new double[]{this.midpoint[0] - this.length / 4.0, this.midpoint[1] - this.length / 4.0}, this.length / 2.0);
        return newQuardant;
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
