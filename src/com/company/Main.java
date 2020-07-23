package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the print shop!");
        Shop shop = new Shop();
        // List<Job> jobs = new ArrayList<Job>();
        shop.newJob(new Job("Sue", true, true, PaperSize.Large, PaperColour.Blue, InkColour.Black, 40));
        shop.newJob(new Job("John",false, true, PaperSize.Medium, PaperColour.White, InkColour.Red, 100));
        shop.newJob(new Job("Mark",true, false, PaperSize.Small, PaperColour.Yellow, InkColour.Black, 20));
        shop.newJob(new Job("Dean",false, false, PaperSize.Medium, PaperColour.Blue, InkColour.Blue, 60));
        shop.newJob(new Job("Ben",true, false, PaperSize.Large, PaperColour.White, InkColour.Blue, 70));
        System.out.println("Closing shop Ore.B Printing LTD");
    }
}
