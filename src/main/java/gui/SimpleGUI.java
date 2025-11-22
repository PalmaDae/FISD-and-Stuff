package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimpleGUI {
    public static void main(String[] args) {
        Window[] window = JWindow.getWindows();

        JFrame frame = new JFrame("Simple GUI");

        frame.setLocation(400, 200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTextField field = new JTextField("0_0");

        JLabel label = new JLabel("It's just JLabel))");

        JPanel panel = new JPanel();
        JButton button = new JButton("Click Me");
        frame.setVisible(true);

        button.setPreferredSize(new Dimension(200,100));
        field.setPreferredSize(new Dimension(200,100));

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("mouseClicked");
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                System.out.println("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                System.out.println("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                System.out.println("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                System.out.println("mouseExited");
            }
        });

        label.setSize(new Dimension(200,100));
        panel.add(label);
        panel.add(field);
        frame.add(panel);
        panel.add(button);

        field.addActionListener(e -> {
            System.out.println(field.getText());
        });

        button.addActionListener(e -> {
            label.setText("You clicked Me!");
        });
    }
}
