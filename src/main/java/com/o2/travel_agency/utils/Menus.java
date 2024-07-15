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
}
