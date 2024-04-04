package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Kalkulator();

        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj wagę[kg]: \n");
        double waga = scan.nextDouble();
        System.out.println("Podaj wzrost[m]: \n");
        double wzrost = scan.nextDouble();
        System.out.println("Podaj wzrost[cm]: \n");
        int wzrostcm = scan.nextInt();
        System.out.println("Podaj wiek: \n");
        int wiek = scan.nextInt();
        double dzk;

        double bmi = waga / (Math.pow(wzrost, 2));
        System.out.println("Twoje BMI wynosi: " + bmi);
        if (bmi < 16) {
            System.out.println("Wygłodzenie\n");
        } else if (bmi > 16 && bmi < 16.99) {
            System.out.println("Wychudzenie\n");
        } else if (bmi > 17 && bmi < 18.49) {
            System.out.println("Niedowaga\n");
        } else if (bmi > 18.5 && bmi < 24.99) {
            System.out.println("Optymalnie\n");
        } else if (bmi > 25 && bmi < 29.99) {
            System.out.println("Nadwaga\n");
        } else if (bmi > 30 && bmi < 34.99) {
            System.out.println("Otyłość 1-ego stopnia\n");
        } else if (bmi > 35 && bmi < 39.99) {
            System.out.println("Otyłość 2-ego stopnia\n");
        } else if (bmi >= 40) {
            System.out.println("Otyłość 3-ego stopnia\n");
        }

        System.out.println("Wybierz płeć");
        System.out.println("1) M");
        System.out.println("2) K");
        System.out.println("3) Quit");

        String options = null;
        do {
            options = scan.nextLine();
            switch (options) {
                case "1":
                    double m = 66 + (13.7 * waga) + (5 * wzrostcm) - (6.8 * wiek);
                    System.out.println("Wybierz tryb życia");
                    System.out.println("1) Siedzący");
                    System.out.println("2) Lekko aktywny");
                    System.out.println("3) Umiarkowanie aktywny");
                    System.out.println("4) Bardzo aktywny");
                    System.out.println("5) Extra aktywny");
                    System.out.println("6) Quit");

                    String opcje = null;
                    do {
                        opcje = scan.nextLine();
                        switch (opcje) {
                            case "1":
                                dzk = m * 1.2;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                            case "2":
                                dzk = m * 1.375;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                            case "3":
                                dzk = m * 1.55;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                            case "4":
                                dzk = m * 1.725;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                            case "5":
                                dzk = m * 1.9;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                        }
                    } while (!options.equals("6"));
                    break;
                case "2":
                    double k = 655 + (9.6 * waga) + (1.8 * wzrostcm) - (4.7 * wiek);
                    System.out.println("Wybierz tryb życia");
                    System.out.println("1) Siedzący");
                    System.out.println("2) Lekko aktywny");
                    System.out.println("3) Umiarkowanie aktywny");
                    System.out.println("4) Bardzo aktywny");
                    System.out.println("5) Extra aktywny");
                    System.out.println("6) Quit");

                    String opcje2 = null;
                    do {
                        opcje2 = scan.nextLine();
                        switch (opcje2) {
                            case "1":
                                dzk = k * 1.2;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                            case "2":
                                dzk = k * 1.375;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                            case "3":
                                dzk = k * 1.55;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                            case "4":
                                dzk = k * 1.725;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                            case "5":
                                dzk = k * 1.9;
                                System.out.println("Twoje dzienne zużycie kalori wynosi: " + dzk);
                                break;
                        }
                    } while (!options.equals("6"));
                    break;
            }
        } while (!options.equals("3"));
    }

    public static class Kalkulator extends Frame implements ActionListener, ListSelectionListener, ItemListener {
        Button bmi, bmr;
        TextField waga, wzrostM, wzrostCm, wiek;
        JLabel jlabSelected;
        JLabel jlabChanged;
        JCheckBox jcbK;
        JCheckBox jcbM;
        JList<String> jlst;
        JLabel jlab;
        JScrollPane jscrlp;

        String[] stylZycia = { "Siedzący", "Lekko aktywny",
                "Umiarkowanie aktywny", "Bardzo aktywny", "Extra aktywny" };

        public Kalkulator(){
            super("Kalkulator BMI i BMR");
            setSize(700, 300);
            setLayout(new FlowLayout());
            setBackground(Color.LIGHT_GRAY);

//wygląd
            add(new Label("Waga[kg]"));
            waga = new TextField(10);
            add(waga);
            add(new Label("Wzrost[m]"));
            wzrostM = new TextField(10);
            add(wzrostM);
            add(new Label("Wzrost[cm]"));
            wzrostCm = new TextField(10);
            add(wzrostCm);
            add(new Label("Wiek"));
            wiek = new TextField(10);
            add(wiek);
            bmi = new Button("BMI");
            bmi.addActionListener(this);
            bmi.setSize(50,50);
            add(bmi);
            bmr = new Button("BMR");
            bmr.addActionListener(this);
            bmr.setSize(50,50);
            add(bmr);

//checkboxy
            jlabSelected = new JLabel("");
            jlabChanged = new JLabel("");
            jcbK = new JCheckBox("Kobieta");
            jcbM = new JCheckBox("Mężczyzna");
            jcbK.addItemListener(this);
            jcbM.addItemListener(this);
            add(jcbK);
            add(jcbM);
            add(jlabChanged);
            add(jlabSelected);

//lista
            jlst = new JList<String>(stylZycia);
            jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jscrlp = new JScrollPane(jlst);
            jscrlp.setPreferredSize(new Dimension(150, 100));
            jlab = new JLabel("Wybierz styl życia");
            jlst.addListSelectionListener(this);
            add(jscrlp);
            add(jlab);

//menu
            MenuBar menuBar = new MenuBar();
            setMenuBar(menuBar);
            Menu menu = new Menu("Plik");
            MenuItem mi = new MenuItem("Zamknij", new MenuShortcut(1));
            menu.add(mi);
            menu.addActionListener(this);
            menuBar.add(menu);

            setVisible(true);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        }

        public void actionPerformed(ActionEvent e) {
            String label = e.getActionCommand();

            if (label.equals("BMI")) {

            }
        }

        public void valueChanged(ListSelectionEvent e) {
            int idx = jlst.getSelectedIndex();
            if(idx != -1) {
                jlab.setText("Aktualny wybór: " + stylZycia[idx]);
            }
            else{
                jlab.setText("Wybierz styl życia");
            }
        }

        public void itemStateChanged(ItemEvent e) {
            String str = "";
            JCheckBox cb = (JCheckBox) e.getItem();

            if(cb.isSelected())
                jlabChanged.setText(cb.getText() + " zostało zaznaczone.");
            else
                jlabChanged.setText(cb.getText() + ": zaznaczenie zostało usunięte.");

            if(jcbK.isSelected()) {
                str += "Kobieta ";
            }
            if(jcbM.isSelected()) {
                str += "Mężczyzna ";
            }
            jlabSelected.setText("Te pola są wybrane: " + str);
        }
    }
}
