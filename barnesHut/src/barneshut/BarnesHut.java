/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author orgho
 */
public class BarnesHut extends JFrame {

    public static final int FRAME_WIDTH = 768;
    public static final int FRAME_HEIGHT = 768;
    public static final String TITLE = "NBody SImulation";

    public BarnesHut() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        BarnesHutPanel panel = new BarnesHutPanel();
        Timer timer = new Timer(40, panel);
        timer.start();
        pane.add(panel);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        BarnesHut barnesHut = new BarnesHut();
    }
}
