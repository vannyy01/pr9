package com.GuiApplication;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import javax.swing.JPanel;

public class ConcatForm {
    private JLabel label = new JLabel("Введіть розмір узору:");
    private JLabel label_1 = new JLabel("Узор:");
    private JTextArea textAreaTracery = new JTextArea();
    private JSpinner spinnerSize = new JSpinner();
    private JFrame frame;
    private JPanel panel;

    private ConcatForm() {
        this.initialize();
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ConcatForm window = new ConcatForm();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        frame = new JFrame("Concat");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(null);

        label.setBounds(24, 27, 145, 24);
        container.add(label);

        label_1.setBounds(24, 96, 109, 14);
        container.add(label_1);

        textAreaTracery.setForeground(new Color(0, 0, 0));
        textAreaTracery.setBackground(new Color(191, 205, 219));
        textAreaTracery.setBounds(114, 60, 200, 169);
        container.add(textAreaTracery);
        spinnerSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int size = (Integer) spinnerSize.getValue();

                String str = "";
                String temp = "";
                int t = 0;
                for (int i = size; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        if (i != size) {
                            str += temp.substring(t, temp.length() - 1);
                            break;
                        } else {
                            str += j + " ";
                        }
                    }
                    if (i == size) temp += str;
                    t += 2;
                    str += "\n";
                }
                textAreaTracery.setText(str);

            }
        });

        spinnerSize.setModel(new SpinnerNumberModel(0, 0, 9, 1));
        spinnerSize.setBounds(160, 29, 64, 20);
        container.add(spinnerSize);
    }

}
