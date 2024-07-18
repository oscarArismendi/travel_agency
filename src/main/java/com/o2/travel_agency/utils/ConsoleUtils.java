package com.o2.travel_agency.utils;

import java.sql.Date;

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

        while (true) {
            try {
                System.out.print(statement);
                int option = MyScanner.scanInt();
                if (option >= lower && option <= upper) {
                    return option;
                } else {
                    System.out.println(String.format("You didn't choose a number within these boundaries: %1$d-%2$d",
                            lower, upper));
                }

            } catch (Exception e) {
                System.out.println("Digit a valid number." + e.getMessage());
            }
        }
    }

    public  static int yesOrNo(String message) {
        int option = 0;
        while (true) {
            System.out.println(message);
            System.out.println("1. Yes");
            System.out.println("2. No");
            option = MyScanner.scanInt();
            if (option != 1 && option != 2) {
                System.out.print("Input a valid option, 1 or 2:");
            } else {
                break;
            }
        }
        return option;
    }

    public static Date validateDate(String mensaje) {
        Date date = null;
        System.out.print(mensaje);
        while (date == null) {
            String input = MyScanner.scanLine();
            try {
                date = Date.valueOf(input);
            } catch (Exception e) {
                System.out.println("Fecha inválida. Formato correcto: YYYY-MM-DD.");
            }
        }
        return date;
    }

}
