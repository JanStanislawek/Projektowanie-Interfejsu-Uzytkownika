package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("wprowadź boki trójkąta");
	    int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        int c = new Scanner(System.in).nextInt();
        if ( a+b<c || a+c<b || c+b<a) {
            System.out.println("brak trójkąta");
        }
            else if (a==b && b==c && c==a){
                System.out.println("trójkąt równoboczny");
        }
            else if(a==b || b==c || a==c){
                System.out.println("trójkąt równoramienny");
        }
            else{
                System.out.println("trójkąt różnoboczny");
        }

    }
}
