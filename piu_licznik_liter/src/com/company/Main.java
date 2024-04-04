package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("wprowadz tekst :");
        String s1=sc.nextLine();
        int zliczanie,j=1;
        char var='a';
        char ch[]=s1.toCharArray();
        while(j<=26)
        {
            zliczanie=0;
            for(int i=0; i<s1.length(); i++)
            {
                if(ch[i]==var || ch[i]==var-32)
                {
                    zliczanie++;
                }
            }
            if(zliczanie>0){
                System.out.println("ilosc "+var+" = "+zliczanie);
            }
            var++;
            j++;
            }
        }
    }

