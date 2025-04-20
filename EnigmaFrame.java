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

    private JTextArea inputText;
    private JTextArea outputText;

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
        initialPosField = new JTextField("EST", 5);

        // oops forgot encrypt decrypt buttons
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        // add all components
        panel.add(innerLabel);
        panel.add(innerRotorComboBox);
        panel.add(middleLabel);
        panel.add(middleRotorComboBox);
        panel.add(outLabel);
        panel.add(outRotorComboBox);
        panel.add(positionsLabel);
        panel.add(initialPosField);
        panel.add(encryptButton);
        panel.add(decryptButton);

        // add control panel to frame
        this.add(panel, BorderLayout.NORTH);

        // text areas panel
        JPanel textArea = new JPanel();
        textArea.setLayout(new BorderLayout());

        // text input
        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel inputLabel = new JLabel("Input");
        inputText = new JTextArea(10, 40); //shows 10 lines of text w/out scrolling, 40 characters per line
        inputText.setLineWrap(true);
        JScrollPane inputScroll = new JScrollPane(inputText);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScroll, BorderLayout.CENTER);

        // text output
        JPanel outputPanel = new JPanel(new BorderLayout());
        JLabel outputLabel = new JLabel("Output");
        outputText = new JTextArea(10, 40);
        outputText.setLineWrap(true);
        JScrollPane outputScroll = new JScrollPane(outputText);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScroll, BorderLayout.CENTER);

        textArea.add(inputPanel, BorderLayout.NORTH);
        textArea.add(outputPanel, BorderLayout.CENTER);

        this.add(textArea, BorderLayout.CENTER);
    }
}
