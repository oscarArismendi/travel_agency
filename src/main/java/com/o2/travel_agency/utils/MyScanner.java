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

    public static int ScanInt() {
        return scan.nextInt();
    }

    public static Long ScanLong(){
        return scan.nextLong();
    }
}
