package FoodOrdering;

import LeapYear.LeapYearGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Arrays;

public class FoodOrderGUI extends JFrame {
    private JPanel panel1;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;


    public FoodOrderGUI(){
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rbNone);
        btnGroup.add(rb5);
        btnGroup.add(rb10);
        btnGroup.add(rb15);
        rbNone.setSelected(true);

        List<JCheckBox> chkList = Arrays.asList(cPizza, cBurger, cFries,  cSoftDrinks, cTea, cSundae);
        int[] priceList = new int[]{100, 80, 65, 55, 50, 40};

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float total = 0;

                try {
                    for (JCheckBox c : chkList) {
                        if (c.isSelected()) {
                            total += (float) priceList[chkList.indexOf(c)];
                        }
                    }

                    if (total == 0) {
                        throw new Exception("None selected");
                    }

                    if (rb5.isSelected()) {
                        total *= 0.95;
                    } else if (rb10.isSelected()) {
                        total *= 0.9;
                    } else if (rb15.isSelected()) {
                        total *= 0.85;
                    }
                    JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", total));
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Please select one or more items to order.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        frame.setContentPane(new FoodOrderGUI().panel1);
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
