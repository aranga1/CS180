import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(); // defaults to FlowLayout
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }
        
        frame.add(panel);
        frame.setVisible(true);
    }
}