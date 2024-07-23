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
                System.out.print("Error! Insert a valid number: ");
                scan.nextLine();
            }
        }
        return rta;
    }

    public static double scanDouble(){
        Double rta = 0.0;
        while(true){
            try {
                scan.useLocale(java.util.Locale.US);
                rta = scan.nextDouble();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.print("Error! Insert a valid number(ex: 100.5): ");
                scan.nextLine();
            }
        }
        return rta;
    }

    public static Long scanLong(){
        return scan.nextLong();
    }
}
