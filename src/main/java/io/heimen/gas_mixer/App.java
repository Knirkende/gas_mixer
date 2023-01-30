package io.heimen.gas_mixer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LayoutTest f = new LayoutTest();
    }
}

class LayoutTest {
    JFrame f;

    public LayoutTest() {
        f = new JFrame("Test layout");
        InputRowPanel row1 = new InputRowPanel();

        JButton b1=new JButton("Test");
        b1.addActionListener(row1);

        JPanel panelTest = new JPanel(new GridLayout(2, 1));
        panelTest.add(b1);

        f.add(row1);
        f.add(b1);

        f.setLayout(new GridLayout(2,1));
        f.setSize(300, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class InputRowPanel extends JPanel implements ActionListener {
    private static Validator validator;
    private JTextField inputField;

    public InputRowPanel() {
        super(new GridLayout(1, 2));
        this.validator = validator;
        this.inputField = new JTextField();
        inputField.setBounds(50, 50, 150, 20);
        add(inputField);
    }

    public InputRowPanel(Validator validator, String defaultValue) {
        super(new GridLayout(1, 2));
        this.validator = validator;
        this.inputField = new JTextField(defaultValue);
        add(inputField);
    }

    public void actionPerformed(ActionEvent e) {
        String val = inputField.getText();
        System.out.println(val);
    }

    public int getInput() {
        return -1;
    }
}