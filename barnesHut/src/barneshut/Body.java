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
    private static final double solarMass = 1.98892e30; //standard unit equal to mass of sun

    private double[] position = new double[2];
    private double[] velocity = new double[2];
    private double[] force = new double[2];
    private double mass;
    private Color color;

}
