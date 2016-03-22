/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleframe;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author oneogi19
 */
public class Circle implements Colorable {

    private double x;
    private double y;
    private double radius;
    private Color color;

    public Circle(double x, double y, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    /**
     * @return the color
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public boolean intersects(Circle C) {
        double distance = Math.sqrt((C.getX() - this.getX()) * (C.getX() - this.getX()) + (C.getY() - this.getY()) * (C.getY() - this.getY()));
        return (distance < (C.getRadius() + this.getRadius()));
    }

    public void draw(Graphics2D g, AffineTransform transform) {
        g.setColor(this.color);
        Ellipse2D circle = new Ellipse2D.Double((this.x - this.radius), (this.y - this.radius), (this.radius * 2), (this.radius * 2));
        Shape shape = transform.createTransformedShape(circle);
        g.fill(shape);

    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

}
