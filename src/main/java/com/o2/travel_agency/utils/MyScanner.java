package com.o2.travel_agency.utils;

import java.util.Scanner;

public class MyScanner {
    static Scanner scan = new Scanner(System.in);

    public static String scan() {
        return scan.next();
    }

    public static String scanLine() {
        return scan.nextLine();
    }

    public static int scanInt() {
        int rta = 0;
        while(true){
            try {
                rta = scan.nextInt();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.print("Insert a valid number: ");
            }
        }
        return rta;
    }

    public static Long scanLong(){
        return scan.nextLong();
    }
}
