/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleframe;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author oneogi19
 */
public class CircleFrame extends JFrame {

    public static final int FRAME_WIDTH = 768;
    public static final int FRAME_HEIGHT = 768;
    public static final String TITLE = "Circles";

    public CircleFrame() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        CirclePanel panel = new CirclePanel();
        Timer timer = new Timer(40, panel);
        timer.start();
        pane.add(panel);

        this.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CircleFrame circles = new CircleFrame();
    }

}
