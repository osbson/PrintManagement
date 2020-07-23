package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<JobQueue> queues;
    List<Printer> printers;

    public Shop() {
        this.queues = new ArrayList<JobQueue>();
        // this.createQueues();
        this.printers = new ArrayList<Printer>();
        this.createPrinters();
    }

    public List getQueues() {
        //return list of queues, each shown as a list of names of customers
        return null;
    }

    public void newJob(Job job) {
        //assign job to correct queue
        //find appropriate queue and add job to queue
        boolean added = false;
        for(JobQueue queue: this.queues){
            if(queue.checkJob(job)){
                queue.addJob(job);
                added = true;
                break;
            }
        }
        //if no queues exist with config for job/no queues exist at all, create queue with correct config and add job
        if(!added){
            JobQueue queue = new JobQueue(job.needsStapling(), job.isFast(), job.getPaperSize(), job.getPaperColour(), job.getInkColour());
            this.queues.add(queue);
            queue.addJob(job);
            System.out.println(queue);
        }
        System.out.println(job);
    }

    private void createPrinters() {
        this.printers.add(new Printer("HPsuperfast", true, true, PaperSize.Large, PaperColour.Blue, InkColour.Black));
        this.printers.add(new Printer("SAMSUNG01", false, false, PaperSize.Medium, PaperColour.Yellow, InkColour.Red));
        this.printers.add(new Printer("SONYportable254", true, false, PaperSize.Small, PaperColour.Blue, InkColour.Red));
        this.printers.add(new Printer("CANON3000", true, false, PaperSize.Medium, PaperColour.White, InkColour.Blue));
        this.printers.add(new Printer("HPoriginals01", false, true, PaperSize.Large, PaperColour.White, InkColour.Black));
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
