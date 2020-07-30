package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Shop {
    List<JobQueue> queues;
    List<Printer> printers;
    int step;

    public Shop() {
        this.queues = new ArrayList<JobQueue>();
        this.printers = new ArrayList<Printer>();
        this.step = 1;
    }

    public List getQueues() {
        //return list of queues, each shown as a list of names of customers
        return null;
    }

    public void newJob(String customerName, boolean stapling, boolean isFast, PaperSize paperSize, PaperColour paperColour, InkColour inkColour, int pageCount) {
        Job job = new Job(customerName, stapling, isFast, paperSize, paperColour, inkColour, pageCount);
        //assign job to correct queue
        //find appropriate queue and add job to queue
        boolean added = false;
        for (JobQueue queue : this.queues) {
            if (queue.checkJob(job)) {
                queue.addJob(job);
                added = true;
                break;
            }
        }
        //if no queues exist with config for job/no queues exist at all, create queue with correct config and add job
        if (!added) {
            JobQueue queue = job.createQueue();
            this.queues.add(queue);
            queue.addJob(job);
        }
    }

    public void newPrinter(String name, boolean stapling, boolean isFast, PaperSize paperSize, PaperColour paperColour, InkColour inkColour) {
        Printer printer = new Printer(name, stapling, isFast, paperSize, paperColour, inkColour);
        this.printers.add(printer);
        //Assigns queue to printer if queue with config exists
        boolean added = false;
        for (JobQueue queue : this.queues) {
            if (printer.checkQueue(queue)) {
                printer.setQueue(queue);
                added = true;
                break;
            }
        }
        //Creates new queue and assigns to printer if queue with config doesn't exist
        if (!added) {
            JobQueue queue = printer.createQueue();
            this.queues.add(queue);
            printer.setQueue(queue);
        }
    }

    public void startTick() {
        System.out.println("Starting step: " + this.step);
    }

    public void endTick() {
        System.out.println("Ending step: " + this.step);
        step += 1;
        System.out.println();
    }

    public void tick(String[] values) {
        if (values[0].equals("printer")) {
            String name = values[1];
            Boolean stapling = Boolean.parseBoolean(values[2]);
            Boolean isFast = Boolean.parseBoolean(values[3]);
            PaperSize paperSize = PaperSize.valueOf(values[4]);
            PaperColour paperColour = PaperColour.valueOf(values[5]);
            InkColour inkColour = InkColour.valueOf(values[6]);
            this.newPrinter(name, stapling, isFast, paperSize, paperColour, inkColour);
        } else if (values[0].equals("job")) {
            String name = values[1];
            Boolean stapling = Boolean.parseBoolean(values[2]);
            Boolean isFast = Boolean.parseBoolean(values[3]);
            PaperSize paperSize = PaperSize.valueOf(values[4]);
            PaperColour paperColour = PaperColour.valueOf(values[5]);
            InkColour inkColour = InkColour.valueOf(values[6]);
            int pageCount = Integer.parseInt(values[7]);
            this.newJob(name, stapling, isFast, paperSize, paperColour, inkColour, pageCount);
        } else if (values[0].equals("change")) {
            String name = values[1];
            PaperColour paperColour = PaperColour.valueOf(values[5]);
            InkColour inkColour = InkColour.valueOf(values[6]);
            for (Printer printer : this.printers) {
                if (printer.getName().equals(name)) {
                    printer.change(paperColour, inkColour);
                    //Assigns queue to printer if queue with config exists
                    boolean added = false;
                    for (JobQueue queue : this.queues) {
                        if (printer.checkQueue(queue)) {
                            printer.setQueue(queue);
                            added = true;
                            break;
                        }
                    }
                    //Creates new queue and assigns to printer if queue with config doesn't exist
                    if (!added) {
                        JobQueue queue = printer.createQueue();
                        this.queues.add(queue);
                        printer.setQueue(queue);
                    }
                    break;
                }
            }
        } else if (values[0].equals("idle")) {
            System.out.println("idle");
        } else {
            System.out.println("Entry not recognised " + values[0]);
        }
        for (Printer printer : this.printers) {
            if (printer.isBusy()) {
                printer.print();
            } else {
                printer.nextJob();
            }
        }
    }

    /* private void createQueues(){
        boolean stapling = false;
        boolean isFast = false;
        PaperSize pSize = null;
        PaperColour pColour = null;
        InkColour iColour = null;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        for(int m = 0; m < 3; m++){
                            if(i == 1){stapling = true;}
                            if(j == 1){isFast = true;}
                            if(k == 0){pSize = PaperSize.Small;}
                            if(k == 1){pSize = PaperSize.Medium;}
                            if(k == 2){pSize = PaperSize.Large;}
                            if(l == 0){pColour = PaperColour.Blue;}
                            if(l == 1){pColour = PaperColour.White;}
                            if(l == 2){pColour = PaperColour.Yellow;}
                            if(m == 0){iColour = InkColour.Black;}
                            if(m == 1){iColour = InkColour.Red;}
                            if(m == 2){iColour = InkColour.Blue;}
                            JobQueue queue = new JobQueue(stapling, isFast, pSize, pColour, iColour);
                            this.queues.add(queue);
                        }
                    }
                }
            }
        }
    } */
}
