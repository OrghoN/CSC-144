/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleframe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author oneogi19
 */
public class CirclePanel extends JPanel implements ActionListener {

    public static final Color BG_COLOR = new Color(180, 224, 248);
    private double nearness = 0.5;

    public CirclePanel() {
        this.setBackground(BG_COLOR);
    } // CirclePanel()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;


        int w = this.getWidth();
        int h = this.getHeight();

        double MAX_RADIUS = 0.25;
        double MIN_RADIUS = 0.01;

        AffineTransform scale = new AffineTransform();
        scale.setToScale(w / 2, h / 2);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(1.0, 1.0);
        AffineTransform transform = new AffineTransform();
        transform.concatenate(scale);
        transform.concatenate(translate);


        List<Circle> circles = new ArrayList<>();
        Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

        int j = 0;
        for (double radius = MAX_RADIUS; radius > MIN_RADIUS; radius -= 0.01) {
            double max = 1 - radius;
            double min = radius - 1;
            int i = 0;
            j++;
            if (j >= colors.length) {
                j = 0;
            }
            while (i < 1000) {
                boolean check = false;
                Circle New = new Circle((Math.random() * (max - min) + min), (Math.random() * (max - min) + min), radius, colors[j]);
                for (Circle s : circles) {
                    System.out.println(New.intersects(s));
                    if (New.intersects(s)) {
                        i++;
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    circles.add(New);
                    New.draw(g2D, transform);
                }
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        this.repaint();
    } // actionPerformed( ActionEvent )
}
