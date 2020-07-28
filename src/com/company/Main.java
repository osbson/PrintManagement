package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the print shop!");
        System.out.println();

        Shop shop = new Shop();

        System.out.println("#########################################");
        System.out.println("Entering Printers:");
        System.out.println("#########################################");
        System.out.println();

        shop.newPrinter("HPsuperfast", true, true, PaperSize.Large, PaperColour.Blue, InkColour.Black);
        shop.newPrinter("SAMSUNG01", false, false, PaperSize.Medium, PaperColour.Yellow, InkColour.Red);
        shop.newPrinter("SONYportable254", true, false, PaperSize.Small, PaperColour.Blue, InkColour.Red);
        shop.newPrinter("CANON3000", true, false, PaperSize.Medium, PaperColour.White, InkColour.Blue);
        shop.newPrinter("HPoriginals01", true, false, PaperSize.Large, PaperColour.White, InkColour.Blue);

        System.out.println();
        System.out.println("#########################################");
        System.out.println("Entering jobs:");
        System.out.println("#########################################");
        System.out.println();

        for(int i = 0; i < 3; i++) shop.tick();
        shop.newJob("Sue", true, true, PaperSize.Large, PaperColour.Blue, InkColour.Black, 4);
        for(int i = 0; i < 3; i++) shop.tick();
        shop.newJob("John",false, true, PaperSize.Medium, PaperColour.White, InkColour.Red, 2);
        for(int i = 0; i < 1; i++) shop.tick();
        shop.newJob("Mark",true, false, PaperSize.Small, PaperColour.Yellow, InkColour.Black, 5);
        for(int i = 0; i < 2; i++) shop.tick();
        shop.newJob("Dean",false, false, PaperSize.Medium, PaperColour.Blue, InkColour.Blue, 3);
        for(int i = 0; i < 2; i++) shop.tick();
        shop.newJob("Ben",true, false, PaperSize.Large, PaperColour.White, InkColour.Blue, 2);
        for(int i = 0; i < 2; i++) shop.tick();
        shop.newJob("Charlie",true, false, PaperSize.Large, PaperColour.White, InkColour.Blue, 3);
        for(int i = 0; i < 10; i++) shop.tick();

        System.out.println();
        System.out.println("Closing shop Ore.B Printing LTD");




//        Job a = new Job("Sue", true, true, PaperSize.Large, PaperColour.Blue, InkColour.Black, 40);
//        Job b = new Job("John",false, true, PaperSize.Medium, PaperColour.White, InkColour.Red, 100);
//        Job c = a;
//        System.out.println(a.getPagesLeft());
//        System.out.println(c.getPagesLeft());
//        c.printPage();
//        System.out.println(a.getPagesLeft());
//        System.out.println(c.getPagesLeft());
    }
}
