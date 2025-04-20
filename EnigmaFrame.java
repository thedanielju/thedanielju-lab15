import java.awt.*;
import javax.swing.*;

public class EnigmaFrame extends JFrame {
    private int id;

    private JComboBox<Integer> innerRotorComboBox;
    private JComboBox<Integer> middleRotorComboBox;
    private JComboBox<Integer> outRotorComboBox;
    private JTextField initialPosField;

    private JButton encryptButton;
    private JButton decryptButton;

    public EnigmaFrame(int id) {
        this.id = id;
        this.setTitle("Enigma GUI"); //set title
        this.setSize(800, 800); //set size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close
        this.setLocationRelativeTo(null); //centers on screen
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); //check

        JLabel innerLabel = new JLabel("Inner");
        Integer[] rotorNumbers = {1, 2, 3, 4, 5};
        innerRotorComboBox = new JComboBox<>(rotorNumbers);
        
        JLabel middleLabel = new JLabel("Middle");
        middleRotorComboBox = new JComboBox<>(rotorNumbers);

        JLabel outLabel = new JLabel("Out");
        outRotorComboBox = new JComboBox<>(rotorNumbers);

        // initial positions
        JLabel positionsLabel = new JLabel("Initial Positions");
        initialPosField = new JTextField("...", 5);

        // add all components
        panel.add(innerLabel);
        panel.add(innerRotorComboBox);
        panel.add(middleLabel);
        panel.add(middleRotorComboBox);
        panel.add(outLabel);
        panel.add(outRotorComboBox);
        panel.add(positionsLabel);
        panel.add(initialPosField);

        // add control panel to frame
        this.add(panel, BorderLayout.NORTH);

    }

    public static void main(String[] args) {
        EnigmaFrame frame = new EnigmaFrame(1);
        frame.setVisible(true);
    }
}
