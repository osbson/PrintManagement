package com.company;

public class Printer {
    boolean stapling;
    boolean isFast;
    PaperSize paperSize;
    PaperColour paperColour;
    InkColour inkColour;
    boolean busy;

    public Printer(boolean stapling, boolean isFast, PaperSize paperSize, PaperColour paperColour, InkColour inkColour) {
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

    public void print(Job job){
        this.busy = true;
    }



}
