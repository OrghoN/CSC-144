
package shading;

import java.awt.Container;
import javax.swing.JFrame;


public class Shading extends JFrame {

    private static final int FRAME_WIDTH = 512;
    private static final int FRAME_HEIGHT = 512;
    private static final String FRAME_TITLE = "Shading";
    
    public Shading() {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        this.setTitle( FRAME_TITLE );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = this.getContentPane();
        Container panel = new ShadingPanel();
        pane.add( panel );
        this.setVisible(true);
    } // Shading()
    
    public static void main(String[] args) {
        Shading shading = new Shading();
    } // main( String [] )
    
} // Shading
