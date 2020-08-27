/*
 *
 * Author: Ore Benson
 *
 * */

package com.company;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Welcome to the print shop!");
        System.out.println();

        String simFile = "D:\\Users\\ore\\Print_Management\\IdeaProjects\\simulation.csv";
        File file = new File(simFile);

        try {
            Scanner scanner = new Scanner(file);
            scanner.next();
            Shop shop = new Shop();
            while (scanner.hasNext()) {
                shop.startTick();
                String entry = scanner.next();
                String[] values = entry.split(",");
                shop.tick(values);
                shop.endTick();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Closing shop Ore.B Printing LTD");
        System.out.println();
    }
}
