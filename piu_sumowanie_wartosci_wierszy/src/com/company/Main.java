package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("wprowadź ilosć wierszy");
        int w = (new Scanner(System.in)).nextInt();
        System.out.println("wprowadź ilosć kolumn");
        int k = (new Scanner(System.in)).nextInt();
        int suma = 0;
        int[][] tab = new int[w][k];
        for(int i = 0; i < w; ++i) {
            suma = 0;
            for(int j = 0; j < k; ++j) {
                System.out.print("tablica[" + i + "][" + j + "]= ");
                tab[i][j] = (new Scanner(System.in)).nextInt();
                suma += tab[i][j];
            }
            System.out.println(suma);
        }
        System.out.println();
    }
}