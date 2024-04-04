package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static String zapisanie(int s) {
        ArrayList<Integer> Karty = new ArrayList<>();
        StringBuilder karty = new StringBuilder();
        for (int i = 0; i < s; i++) {
            int karta = (int) (Math.random() * (14 - 2 + 1) + 2);
            if(Karty.contains((Integer) karta)){
                i--;
            }else
                Karty.add((Integer) karta);
        }

        Collections.sort(Karty);
        Collections.reverse(Karty);
        for (int temp : Karty) {
            switch (temp) {
                case 14:
                    karty.append('A');
                    break;
                case 11:
                    karty.append('J');
                    break;
                case 12:
                    karty.append('Q');
                    break;
                case 13:
                    karty.append('K');
                    break;
                case 10:
                    karty.append('T');
                    break;
                default:
                    karty.append(temp);
                    break;
            }
        }
        return karty.toString();
    }

    public static String random() {
        String karty = "S";
        int min = 1;
        int max = 13;
        int s = (int) (Math.random() * (max - min + 1) + min);
        int h = (int) (Math.random() * ((max - s) - min + 1) + min);
        int d = (int) (Math.random() * ((max - s - h) - min + 1) + min);
        int c = 13 - s - h - d;

        karty += zapisanie(s);
        karty +="H";
        karty += zapisanie(h);
        karty +="D";
        karty += zapisanie(d);
        karty +="C";
        karty += zapisanie(c);
        return karty;
    }

    public static class Karty extends Frame implements ActionListener {
        Button losuj;
        TextField argument;
        Button zamiana;

        public Karty() {
            super("Licznik punktów kart? ver.1.0");
            setSize(600, 120);
            setLayout(new FlowLayout());
            setBackground(Color.LIGHT_GRAY);
            add(new Label("Twoje karty to: "));
            argument = new TextField(20);
            add(argument);
            zamiana = new Button("Punkty");
            zamiana.addActionListener(this);
            add(zamiana);
            losuj = new Button("Losuj");
            losuj.addActionListener(this);
            add(losuj);

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

            if (label.equals("Losuj")) {
                argument.setText(random());
            }

            if (label.equals("Punkty")) {
                try {
                    String karty = argument.getText();
                    int punkty = 0, licznik = 0;
                    karty = karty.replace("10", "T");

                    char[] kartytab = karty.toCharArray();

                    for (int i = 0; i < karty.length(); i++) {
                        if (kartytab[i] == 'S') {
                            continue;
                        } else if (kartytab[i] == 'D') {
                            if (licznik == 0) {
                                punkty += 3;
                            }
                            if (licznik == 1) {
                                punkty += 2;
                            }
                            if (licznik == 2) {
                                punkty += 1;
                            }
                            licznik = 0;
                            continue;
                        } else if (kartytab[i] == 'H') {
                            if (licznik == 0) {
                                punkty += 3;
                            }
                            if (licznik == 1) {
                                punkty += 2;
                            }
                            if (licznik == 2) {
                                punkty += 1;
                            }
                            licznik = 0;
                            continue;
                        } else if (kartytab[i] == 'C') {
                            if (licznik == 0) {
                                punkty += 3;
                            }
                            if (licznik == 1) {
                                punkty += 2;
                            }
                            if (licznik == 2) {
                                punkty += 1;
                            }
                            licznik = 0;
                            continue;
                        }
                        if (kartytab[i] == 'A') {
                            punkty += 4;
                        } else if (kartytab[i] == 'K') {
                            punkty += 3;
                        } else if (kartytab[i] == 'Q') {
                            punkty += 2;
                        } else if (kartytab[i] == 'J') {
                            punkty += 1;
                        }
                        licznik++;
                    }
                    String text = "Wynik: " + punkty;
                    JOptionPane.showMessageDialog(null, text);
                } catch (NumberFormatException ev) {
                    System.out.println("Wpisz poprawne wartości");
                }
            } else if (label.equals("Zamknij")) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new Karty();
        random();
    }
}
