package io.heimen;

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

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);

        f.setLayout(new GridLayout(2,2));
        f.setSize(300, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}