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
        boolean stapling = this.needsStapling() == job.needsStapling();
        boolean fast = this.isFast() == job.isFast();
        boolean paperSize = this.getPaperSize() == job.getPaperSize();
        boolean paperColour = this.getPaperColour() == job.getPaperColour();
        boolean inkColour = this.getInkColour() == job.getInkColour();
        return (stapling && fast && paperSize && paperColour && inkColour);
    }

    public String toString(){
        String s = "";
        s += "JobQueue with following details has been created: \n";
        s += " - stapling: " + this.stapling + ", ";
        s += "isFast: " + this.isFast + ", ";
        s += "paperSize: " + this.paperSize + ", ";
        s += "paperColour: " + this.paperColour + ", ";
        s += "inkColour: " + this.inkColour;
        return s;
    }
}
