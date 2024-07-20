package com.o2.travel_agency.utils;

import java.util.List;


public class Menus {

    public static int listMenu(List<?> objects, String text){
        int rta = -1;
        System.out.println(text);
            for (int i = 0; i < objects.size(); i++) {
                System.out.println((i + 1) + ". " + objects.get(i).toString());
        }
        rta = ConsoleUtils.option_validation("Please choose an option: ", 1, objects.size());
        System.out.println("You selected: " + objects.get(rta - 1).toString());

        return rta-1;
    }

    public static int classAttributeMenu(Class<?> clazz, String text) {
        int rta = -1;
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        System.out.println(text);
        for (int i = 1; i < fields.length; i++) {//We start in one because we don't want the id field
            
            System.out.println((i) + ". " + fields[i].getName());
        }
        rta = ConsoleUtils.option_validation("Please choose an option: ", 1, fields.length-1);
        System.out.println("You selected: " + fields[rta].getName());
        return rta - 1;
    }

    public static String mainMenu(List<String> textOptions, String text){
        String rta = "";
        System.out.println(text);
        int i = 0;
        for (; i < textOptions.size(); i++) {
            System.out.println((i + 1) + ". " + textOptions.get(i));
        }
        int op = ConsoleUtils.option_validation("Please choose an option: ", 1, textOptions.size());
        rta = textOptions.get(op-1);
        System.out.println("You selected: " + rta);
        return rta;
    }
}
