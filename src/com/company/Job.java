package com.company;

public class Job {
    boolean stapling;
    boolean isFast;
    int paperSize;
    int paperColour;
    int inkColour;
    int pageCount;
    int pagesLeft;

    public Job(boolean stapling, boolean isFast, int paperSize, int paperColour, int inkColour, int pageCount) {
        this.stapling = stapling;
        this.isFast = isFast;
        this.paperSize = paperSize;
        this.paperColour = paperColour;
        this.inkColour = inkColour;
        this.pageCount = pageCount;
        this.pagesLeft = pageCount;
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

    public int getPageCount() {
        return pageCount;
    }

    public int getPagesLeft() {
        return pagesLeft;
    }

    public void printPage() {
        pagesLeft -= 1;
    }
}
