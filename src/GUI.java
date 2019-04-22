import javax.swing.*;

public class GUI {
    private JRadioButton repeatRadioButton;
    private JRadioButton repeatForRadioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton startButton;
    private JComboBox comboBox1;
    private JTextField secondsTextField;
    private JTextField secondsTextField1;
    private JPanel panelMain;

    public GUI() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Autoclicker");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
