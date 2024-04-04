package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GUI extends Frame implements ActionListener {
    JButton button;
    JList list;
    JSpinner spinner;
    JLabel label, label2;

    public GUI() {
        JFrame frame = new JFrame("Prędkościomierz");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button = new JButton("Zmierz");
        button.addActionListener(this);

        spinner = new JSpinner();
        Dimension d = spinner.getPreferredSize();
        d.width = 50;
        spinner.setPreferredSize(d);

        label2 = new JLabel("Podaj limit");
        label = new JLabel("Wybierz zwierzę");

        String[] zwierzęta = {"słoń", "pies", "gepard", "krokodyl", "żółw"};
        list = new JList(zwierzęta);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();

        panel.add(label2);
        panel.add(spinner);
        panel.add(button);
        panel2.add(list);
        panel2.add(label);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);

        frame.setBackground(Color.CYAN);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = e.getActionCommand();
        if (Objects.equals(text, "Zmierz")) {
            if (list.isSelectedIndex(0)) {
                int limit = (int) spinner.getValue();
                int speed = 20;
                if (speed > limit) {
                    JOptionPane.showMessageDialog(null, "Mandat");
                } else {
                    JOptionPane.showMessageDialog(null, "Brak mandatu");
                }
            } else if (list.isSelectedIndex(1)) {
                int limit = (int) spinner.getValue();
                int speed = 40;
                if (speed > limit) {
                    JOptionPane.showMessageDialog(null, "Mandat");
                } else {
                    JOptionPane.showMessageDialog(null, "Brak mandatu");
                }
            } else if (list.isSelectedIndex(2)) {
                int limit = (int) spinner.getValue();
                int speed = 75;
                if (speed > limit) {
                    JOptionPane.showMessageDialog(null, "Mandat");
                } else {
                    JOptionPane.showMessageDialog(null, "Brak mandatu");
                }
            } else if (list.isSelectedIndex(3)) {
                int limit = (int) spinner.getValue();
                int speed = 20;
                if (speed > limit) {
                    JOptionPane.showMessageDialog(null, "Mandat");
                } else {
                    JOptionPane.showMessageDialog(null, "Brak mandatu");
                }
            } else if (list.isSelectedIndex(4)) {
                int limit = (int) spinner.getValue();
                int speed = 10;
                if (speed > limit) {
                    JOptionPane.showMessageDialog(null, "Mandat");
                } else {
                    JOptionPane.showMessageDialog(null, "Brak mandatu");
                }
            }
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}
