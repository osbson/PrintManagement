package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {
    boolean stapling;
    boolean isFast;
    int paperSize;
    int paperColour;
    int inkColour;
    Queue<Job> jobs;

    public JobQueue(boolean stapling, boolean isFast, int paperSize, int paperColour, int inkColour) {
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

    public int getPaperSize() {
        return paperSize;
    }

    public int getPaperColour() {
        return paperColour;
    }

    public int getInkColour() {
        return inkColour;
    }

    public void addJob(Job job){
        jobs.add(job);
    }

    public Job removeJob(){
        return jobs.remove();
    }
}
