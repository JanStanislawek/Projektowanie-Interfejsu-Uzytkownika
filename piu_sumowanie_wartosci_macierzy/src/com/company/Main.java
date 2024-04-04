1package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sumadol = 0, sumagora = 0, wartosc;

        int [] [] macierz = new int [3] [3];

        for (int w = 0; w < 3; w++){
            for (int k = 0; k < 3; k++){
                System.out.println("Wpisz liczbe dla: "+ w +" "+k);
                wartosc = scan.nextInt();
                macierz[w][k] = wartosc;
            }
        }
        for (int w = 0; w < 3; w++){
            for (int k = 0; k < 3; k++){
                System.out.print(macierz[w][k]+ " ");
            }
            System.out.println();
        }
        for (int w = 0; w < 3; w++){
            for (int k = 0; k < 3; k++){
                if(w>k){
                    sumagora = macierz[0][1]+macierz[0][2]+macierz[1][2];
                }
                if(k>w) {
                    sumadol = macierz[2][0] + macierz[2][1] + macierz[1][0];
                }
            }
        }
        System.out.println("Suma liczb nad przekątną wynosi"+" "+sumagora);
        System.out.println("Suma liczb pod przekątną wynosi"+" "+sumadol);

        if(sumadol>sumagora){
            System.out.println("Suma liczb pod przekątną jest większa");
        }
        else if(sumagora>sumadol){
            System.out.println("Suma liczb nad przekątną jest większa");
        }
        else {
            System.out.println("Suma liczb nad i pod przekątną są równe ");
        }
    }
}
