import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JRadioButton repeatRadioButton;
    private JRadioButton repeatForRadioButton;
    private boolean repeatBool;
    private boolean repeatForBool;
    private JTextField textField1;
    private JTextField textField2;
    private JButton startButton;
    private JComboBox comboBox1;
    private JTextField secondsTextField;
    private JTextField secondsTextField1;
    private JPanel panelMain;
    private ButtonGroup group;

    public GUI() {
        group = new ButtonGroup();
        group.add(repeatRadioButton);
        group.add(repeatForRadioButton);
        repeatBool = false;
        repeatForBool = false;

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double interval = Double.parseDouble(secondsTextField.getText());
                    double delay = Double.parseDouble(secondsTextField1.getText());
                }
                catch(Exception exc) {
                    JOptionPane.showMessageDialog(null,"Invalid values entered!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        repeatRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repeatBool = true;
                repeatForBool = false;
            }
        });
        repeatForRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repeatBool = false;
                repeatForBool = true;
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Autoclicker");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

