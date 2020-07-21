package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<JobQueue> queues;
    List<Printer> printers;

    public Shop() {
        this.queues = new ArrayList<JobQueue>();
        this.printers = new ArrayList<Printer>();
    }

    public void newJob(Job job){
        System.out.println("New job created");
    }
}
