package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;
public LeapYearGUI() {
    btnCheckYear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int year = Integer.parseInt(tfYear.getText());

                if (year < 0) {
                    throw new Exception();
                }

                if (year % 4 == 0) {
                    JOptionPane.showMessageDialog(null, "Leap year");
                } else {
                    JOptionPane.showMessageDialog(null, "Not a leap year");
                }
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "Input must be a whole number!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Input must not be negative!");
            }
        }
    });
}

public static void main(String[] args) {
    JFrame frame = new JFrame("Leap Year Checker");
    frame.setContentPane(new LeapYearGUI().panel1);
    frame.setSize(500, 700);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
}

}
