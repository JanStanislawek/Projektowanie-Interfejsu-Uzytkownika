package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int liczba, suma = 0;
        System.out.println("Podaj liczbę");
        liczba = scan.nextInt();

        for (int i = 1; i <liczba; i++) {
            if (liczba % i == 0)
                suma += i;
        }
        if (suma == liczba) {
            System.out.println(liczba+" "+"jest liczbą doskonałą");
        }
        else
            System.out.println(liczba+" "+"nie jest liczbą doskonałą");
    }
}
