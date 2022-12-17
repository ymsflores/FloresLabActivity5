package SimpleCalc;

import FoodOrdering.FoodOrderGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class SimpleCalcGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    DecimalFormat df = new DecimalFormat("#.#####", otherSymbols);

    public SimpleCalcGUI() {
        lblResult.setEditable(false);
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String op = cbOperations.getSelectedItem().toString();
                try {
                    float x = Float.parseFloat(tfNumber1.getText());
                    float y = Float.parseFloat(tfNumber2.getText());
                    float result = 0;
                    switch (op) {
                        case "+":
                            result = x + y;
                            break;
                        case "-":
                            result = x - y;
                            break;
                        case "*":
                            result = x * y;
                            break;
                        case "/":
                            if (y == 0) {
                                throw new ArithmeticException();
                            }
                            result = x / y;
                            break;
                    }

                    lblResult.setText(df.format(result));
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number in both fields.");
                } catch (ArithmeticException e1) {
                    JOptionPane.showMessageDialog(null, "Cannot divide by 0");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setContentPane(new SimpleCalcGUI().panel1);
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
