import java.awt.*;
import java.awt.event.*;
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

    private void applyFunnyText(JComponent component) {
        Font comicSans = new Font("Comic Sans MS", Font.BOLD, 14);
        component.setFont(comicSans);
        component.setForeground(new Color(225,105,180));
    }

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
        initialPosField = new JTextField("", 5);

        // oops forgot encrypt decrypt buttons
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        // lol
        applyFunnyText(innerLabel);
        applyFunnyText(middleLabel);
        applyFunnyText(outLabel);
        applyFunnyText(positionsLabel);
        applyFunnyText(initialPosField);
        applyFunnyText(encryptButton);
        applyFunnyText(decryptButton);

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
        inputText = new JTextArea(1, 40); //change: one line allowed only (no annoying enter errors), 40 characters per line
        
        // just for fun
        applyFunnyText(inputText);

        inputText.setLineWrap(true);

        JScrollPane inputScroll = new JScrollPane(inputText);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScroll, BorderLayout.CENTER);

        // text output
        JPanel outputPanel = new JPanel(new BorderLayout());
        JLabel outputLabel = new JLabel("Output");
        outputText = new JTextArea(1, 40); //just one line for uniformity 
        
        applyFunnyText(outputText);

        outputText.setLineWrap(true);
        outputText.setRows(1);
        outputText.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputText);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScroll, BorderLayout.CENTER);

        textArea.add(inputPanel, BorderLayout.NORTH);
        textArea.add(outputPanel, BorderLayout.CENTER);

        applyFunnyText(initialPosField);

        this.add(textArea, BorderLayout.CENTER);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                process("encrypt");
            }
        });
        
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                process("decrypt");
            }
        });
    }

    private void process(String operation) {
        int innerRotor = (Integer)innerRotorComboBox.getSelectedItem();
        int middleRotor = (Integer)middleRotorComboBox.getSelectedItem();
        int outerRotor = (Integer)outRotorComboBox.getSelectedItem();

        String initialPositions = initialPosField.getText();

        if (initialPositions.length() < 3) {
            JOptionPane.showMessageDialog(this, "initial positions should make sense!! enter exactly 3 characters without quotations", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //get input
        String inputString = inputText.getText();
        if (inputString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter text ", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // create enigma with selected settings
        try {
            Enigma enigma = new Enigma(innerRotor, middleRotor, outerRotor, initialPositions);

            String result;
            if (operation.equals("encrypt")) {
                result = enigma.encrypt(inputString);
            } else {
                result = enigma.decrypt(inputString);
            }

            outputText.setText(result);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "something went wrong", "operation failed", JOptionPane.ERROR_MESSAGE);
        }

    }
}
