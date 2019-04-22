import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GUI {
    private JRadioButton repeatRadioButton;
    private JRadioButton repeatForRadioButton;
    private JTextField timesTextField;
    private JTextField secondsTextField2;
    private JButton startButton;
    private JComboBox comboBox1;
    private JTextField secondsTextField;
    private JTextField secondsTextField1;
    private JPanel panelMain;

    private GUI() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Autoclicker");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            frame.setIconImage(ImageIO.read(new File("src/icon.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
        frame.pack();
        frame.setVisible(true);
    }
}
