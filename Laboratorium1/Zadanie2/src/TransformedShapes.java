import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;


public class TransformedShapes extends JPanel {

    //------- For drawing ONLY while paintComponent is being executed! --------

    private Graphics2D g2; // A copy of the graphics context from paintComponent.

    /**
     * Removes any transformations that have been applied to g2, so that
     * it is back to the standard default coordinate system.
     */
    private void resetTransform() {
        g2.setTransform(new AffineTransform());
    }

    /**
     * Draws a filled circle of radius 50 (diameter 100) centered at (0,0),
     * subject to whatever transform(s) have been applied to g2.
     */
    private void circle() {
        g2.fillOval(-50,-50,100,100);
    }

    /**
     * Draws a filled square with side 100 centered at (0,0), subject
     * to whatever transform(s) have been applied to g2.
     */
    private void square() {
        g2.fillRect(-50,-50,100,100);
    }

    /**
     * Draws a filled triangle with vertices at (-50,50), (50,50), and
     * (0,-50), subject to whatever transform(s) have been applied to g2.
     */
    private void triangle() {
        g2.fillPolygon(new int[] {-50,50,0}, new int[] {50,50,-50}, 3);
    }

    //-----------------------------------------------------------------------------------


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // TODO Draw the required image, using ONLY the four methods defined above,
        // along with g2.setColor, g1.scale, g2.translate, and g2.rotate.

        /* ----------------------------------------------------------------------- */
        g2.translate(400, 300);
        g2.scale(1, 2);
        g2.setColor(Color.green);
        g2.rotate(Math.toRadians(270));
        triangle();
        resetTransform();


        g2.translate(300, 300);
        g2.scale(1,2);
        g2.setColor(Color.green);
        g2.rotate(Math.toRadians(90));
        triangle();
        resetTransform();

        g2.translate(350, 250);
        g2.scale(2,1);
        g2.setColor(Color.green);
        g2.rotate(Math.toRadians(180));
        triangle();
        resetTransform();


        // reset the transform, so changes don't apply to subsequent drawing

        resetTransform();

        /* ----------------------------------------------------------------------- */

    } // end paintComponent()


    //--------------------------------------------------------------------------------------

    public TransformedShapes() {
        setPreferredSize(new Dimension(600,600) );
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
    }

    public static void main(String[] args)  {
        JFrame window = new JFrame("Drawing With Transforms");
        window.setContentPane(new TransformedShapes());
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
        window.setVisible(true);
    }

}