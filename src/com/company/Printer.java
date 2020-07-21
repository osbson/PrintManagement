package com.company;

public class Printer {
    boolean stapling;
    boolean isFast;
    int paperSize;
    int paperColour;
    int inkColour;
    boolean busy;

    public Printer(boolean stapling, boolean isFast, int paperSize, int paperColour, int inkColour) {
        this.stapling = stapling;
        this.isFast = isFast;
        this.paperSize = paperSize;
        this.paperColour = paperColour;
        this.inkColour = inkColour;
        this.busy = false;
    }

    public boolean hasStapling() {
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

    public boolean isBusy() {
        return busy;
    }

    public void setPaperColour(int paperColour) {
        this.paperColour = paperColour;
    }

    public void setInkColour(int inkColour) {
        this.inkColour = inkColour;
    }

    public void print(Job job){
        this.busy = true;
    }



}
