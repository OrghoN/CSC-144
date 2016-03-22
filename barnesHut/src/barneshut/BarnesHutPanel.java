/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barneshut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author orgho
 */
public class BarnesHutPanel extends JPanel implements ActionListener {

    public static final Color BG_COLOR = Color.DARK_GRAY;

    public BarnesHutPanel() {
        this.setBackground(BG_COLOR);
    } // SpitfirePanel()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform scale = new AffineTransform();
        scale.setToScale(w / 2, h / 2);

        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(1.0, 1.0);

        AffineTransform transform = new AffineTransform();
        transform.concatenate(scale);
        transform.concatenate(translate);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }

}
