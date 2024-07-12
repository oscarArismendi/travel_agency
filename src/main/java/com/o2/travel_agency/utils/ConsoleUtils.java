package com.o2.travel_agency.utils;

public class ConsoleUtils {
    public static void pause() {
        System.out.println("press enter to continue");
        try {
            MyScanner.scanLine();
        } catch (Exception e) {
            System.out.println("Error at pausing : " + e.getMessage());
        }
    }

    public static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int option_validation(String statement, int lower, int upper) {// return a int >= lower and <= upper
        
        while(true) {
            try{
                System.out.println(statement);
                int option = MyScanner.ScanInt();
                MyScanner.scanLine();
                if (option >= lower && option <= upper) {
                    return option;
                } else {
                    System.out.println(String.format("You didn't choose a inverval in this boundaries: %1$d-%2$d",
                            lower, upper));
                            MyScanner.scanLine();
                    
                }

            } catch (Exception e) {
                System.out.println("Digit a valid number." + e.getMessage());
                MyScanner.scanLine(); // Consume the invalid input
            }
        }
    }
}
