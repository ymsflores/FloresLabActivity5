package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;
public LeapYearGUI() {

}

public static void main(String[] args) {
    JFrame frame = new JFrame("Leap Year Checker");
    frame.setContentPane(new LeapYearGUI().panel1);
    frame.setSize(500, 700);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
}

}
