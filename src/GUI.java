import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI {
    private JRadioButton repeatRadioButton;
    private JRadioButton repeatForRadioButton;
    private boolean repeatBool;
    private boolean repeatForBool;
    private JTextField repeatTextField;
    private JTextField repeatForTextField;
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

        comboBox1.addItem("Left Click");
        comboBox1.addItem("Right Click");
        comboBox1.addItem("Middle Click");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double interval, delay, time;
                int count, clickType;

                interval = delay = time = count = clickType = 0;

                try {
                    interval = Double.parseDouble(secondsTextField.getText());
                    delay = Double.parseDouble(secondsTextField1.getText());

                }
                catch(Exception exc) {
                    JOptionPane.showMessageDialog(null,"Invalid values entered!", "Error", JOptionPane.WARNING_MESSAGE);
                }

                switch((String)comboBox1.getSelectedItem())
                {
                    case "Left Click":
                        clickType = 1;
                        break;
                    case "Right Click":
                        clickType = 2;
                        break;
                    case "Middle Click":
                        clickType = 3;
                        break;
                    default:
                        clickType = 0;
                        break;
                }

                if(repeatBool)
                {
                    try{
                        count = Integer.parseInt(repeatTextField.getText());
                        Clicker.clickCount(clickType, count, interval, delay);
                    }
                    catch(Exception exc) {
                        JOptionPane.showMessageDialog(null,"Invalid values entered!", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
                if(repeatForBool)
                {
                    try{
                        time = Double.parseDouble(repeatForTextField.getText());
                        Clicker.clickTime(clickType, time, interval, delay);
                    }
                    catch(Exception exc) {
                        JOptionPane.showMessageDialog(null,"Invalid values entered!", "Error", JOptionPane.WARNING_MESSAGE);
                    }
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
        try{
            frame.setIconImage(ImageIO.read(new File("src/icon.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        frame.pack();
        frame.setVisible(true);
    }
}

