import javax.swing.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {
    private int id;

    public EngimaFrame(int id) {
        this.id = id;
        this.setTitle("EngimaGUI"); //set title
        this.setSize(800, 800); //set size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close
        this.setLocationRelativeTo(null); //centers on screen
    }

    public static void main(String[] args) {
        
    }
}
