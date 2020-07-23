package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the print shop!");
        System.out.println();

        Shop shop = new Shop();

        shop.newPrinter("HPsuperfast", true, true, PaperSize.Large, PaperColour.Blue, InkColour.Black);
        shop.newPrinter("SAMSUNG01", false, false, PaperSize.Medium, PaperColour.Yellow, InkColour.Red);
        shop.newPrinter("SONYportable254", true, false, PaperSize.Small, PaperColour.Blue, InkColour.Red);
        shop.newPrinter("CANON3000", true, false, PaperSize.Medium, PaperColour.White, InkColour.Blue);
        shop.newPrinter("HPoriginals01", false, true, PaperSize.Large, PaperColour.White, InkColour.Black);
        System.out.println();
        shop.newJob("Sue", true, true, PaperSize.Large, PaperColour.Blue, InkColour.Black, 40);
        shop.newJob("John",false, true, PaperSize.Medium, PaperColour.White, InkColour.Red, 100);
        shop.newJob("Mark",true, false, PaperSize.Small, PaperColour.Yellow, InkColour.Black, 20);
        shop.newJob("Dean",false, false, PaperSize.Medium, PaperColour.Blue, InkColour.Blue, 60);
        shop.newJob("Ben",true, false, PaperSize.Large, PaperColour.White, InkColour.Blue, 70);
        shop.newJob("Charlie",true, false, PaperSize.Large, PaperColour.White, InkColour.Blue, 70);

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
