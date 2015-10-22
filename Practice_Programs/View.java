import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class View extends Canvas {
    Model model;
    
    View(Model model) {
        this.model = model;
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        frame.add(this);
        frame.setVisible(true);
    }
/**
     * The paint method is called on the EDT in response to a call to
     * repaint().
     */
    public void paint(Graphics g) {
        int x = model.getX();
        int y = model.getY();
        int width = model.getWidth();
        int height = model.getHeight();
        
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
}