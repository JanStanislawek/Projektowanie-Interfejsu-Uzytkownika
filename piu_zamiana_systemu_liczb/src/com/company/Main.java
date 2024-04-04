package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadz swoją liczbe w systemie dziesietnym\n");
        double input = scan.nextDouble();
        System.out.println("Wprowadz system liczbowy");
        int system = scan.nextInt();
        int output;

        List<Integer> list = new ArrayList<>();

        do {
            output = (int) (input % system);
            list.add((output));
            input = (int) (input / system);
        } while (input != 0);

        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
