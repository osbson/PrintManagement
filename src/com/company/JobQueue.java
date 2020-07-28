package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {
    boolean stapling;
    boolean isFast;
    PaperSize paperSize;
    PaperColour paperColour;
    InkColour inkColour;
    Queue<Job> jobs;

    public JobQueue(boolean stapling, boolean isFast, PaperSize paperSize, PaperColour paperColour, InkColour inkColour) {
        this.stapling = stapling;
        this.isFast = isFast;
        this.paperSize = paperSize;
        this.paperColour = paperColour;
        this.inkColour = inkColour;
        this.jobs = new LinkedList<Job>();
        System.out.println("Created " + this);
    }

    public boolean needsStapling() {
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

    public void addJob(Job job){
        this.jobs.add(job);
    }

    public Job removeJob(){
        return this.jobs.remove();
    }

    public boolean checkJob(Job job){
        boolean stapling = this.stapling == job.needsStapling();
        boolean fast = this.isFast == job.isFast();
        boolean paperSize = this.paperSize == job.getPaperSize();
        boolean paperColour = this.paperColour == job.getPaperColour();
        boolean inkColour = this.inkColour == job.getInkColour();
        return (stapling && fast && paperSize && paperColour && inkColour);
    }

    public String toString(){
        String s = "Queue(";
        s += "stapling: "     + this.stapling     + ", ";
        s += "isFast: "       + this.isFast       + ", ";
        s += "paperSize: "    + this.paperSize    + ", ";
        s += "paperColour: "  + this.paperColour  + ", ";
        s += "inkColor: "     + this.inkColour    + "";
        s += ")";
        return s;
    }

    public int getSize(){
        return this.jobs.size();
    }

    public boolean isEmpty(){
        return this.jobs.isEmpty();
    }
}
