import javax.swing.JOptionPane;
/**
 * CS180 lab02 
 * This program creates a GUI for the user to input data into a window and then display calculated results
 * @ Aakash Ranga, aranga@purdue.edu, lab - 01
 */
public class PythagorasSimpleGUI {
    public static void main(String[] args) {
        Pythagoras p = new Pythagoras();
        String input1 = JOptionPane.showInputDialog("Enter the length of the first side i.e side 'a'");
        int a = Integer.parseInt(input1);
        String input2 = JOptionPane.showInputDialog("Enter the length of the second side i.e. side 'b'");
        int b = Integer.parseInt(input2);
        double hyp = p.getHypotenuse(a, b);
        JOptionPane.showMessageDialog(null, "The hypotenuse is: " + hyp);
    }
}