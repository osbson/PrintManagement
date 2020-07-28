package com.company;

public class Printer {
    String name;
    boolean stapling;
    boolean isFast;
    PaperSize paperSize;
    PaperColour paperColour;
    InkColour inkColour;
    boolean busy;
    JobQueue queue;
    Job currentJob;

    public Printer(String name, boolean stapling, boolean isFast, PaperSize paperSize, PaperColour paperColour, InkColour inkColour) {
        this.name = name;
        this.stapling = stapling;
        this.isFast = isFast;
        this.paperSize = paperSize;
        this.paperColour = paperColour;
        this.inkColour = inkColour;
        this.busy = false;
        System.out.println("Created " + this);
    }

    public String getName() {
        return name;
    }

    public boolean hasStapling() {
        return stapling;
    }

    public boolean isFast() {
        return isFast;
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public PaperColour getPaperColour() {
        return paperColour;
    }

    public InkColour getInkColour() {
        return inkColour;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setPaperColour(PaperColour paperColour) {
        this.paperColour = paperColour;
    }

    public void setInkColour(InkColour inkColour) {
        this.inkColour = inkColour;
    }

    public void print() {
        if (this.currentJob.getPagesLeft() > 0) {
            this.busy = true;
            this.currentJob.printPage();
            System.out.println("Printed " + this.currentJob);
        } else {
            this.busy = false;
            System.out.println("Completed " + this.currentJob);
            this.currentJob = null;
        }
    }

    public void nextJob() {
        if (!this.queue.isEmpty()) {
            this.currentJob = this.queue.removeJob();
            this.busy = true;
            System.out.println("Assigned " + this.currentJob + " to " + this);
        }
    }

    public boolean checkQueue(JobQueue queue) {
        boolean stapling = this.stapling == queue.needsStapling();
        boolean fast = this.isFast == queue.isFast();
        boolean paperSize = this.paperSize == queue.getPaperSize();
        boolean paperColour = this.paperColour == queue.getPaperColour();
        boolean inkColour = this.inkColour == queue.getInkColour();
        return (stapling && fast && paperSize && paperColour && inkColour);
    }

    public JobQueue createQueue() {
        return (new JobQueue(this.stapling, this.isFast, this.paperSize, this.paperColour, this.inkColour));
    }

    public void setQueue(JobQueue queue) {
        this.queue = queue;
        System.out.println("Assigned " + this.queue + " to " + this);
    }

    public String toString() {
        String s = "Printer(";
        s += "name: " + this.name + ", ";
        s += "stapling: " + this.stapling + ", ";
        s += "isFast: " + this.isFast + ", ";
        s += "paperSize: " + this.paperSize + ", ";
        s += "paperColour: " + this.paperColour + ", ";
        s += "inkColor: " + this.inkColour + "";
        s += ")";
        return s;
    }

}
