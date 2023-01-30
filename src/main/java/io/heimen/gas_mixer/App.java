package io.heimen.gas_mixer;

import javax.swing.*;
import java.awt.*;

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
        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        JButton b4=new JButton("4");

        JPanel panelTest = new JPanel(new GridLayout(1, 2));
        panelTest.add(b1);
        panelTest.add(b2);

        f.add(panelTest);

        f.setLayout(new GridLayout(2,1));
        f.setSize(300, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class InputRowPanel extends JPanel {
    public InputRowPanel() {
        super(new GridLayout(1, 2));
    }
}

