package com.company;

public class Job {
    String customerName;
    boolean stapling;
    boolean isFast;
    PaperSize paperSize;
    PaperColour paperColour;
    InkColour inkColour;
    int pageCount;
    int pagesLeft;

    public Job(String customerName, boolean stapling, boolean isFast, PaperSize paperSize, PaperColour paperColour, InkColour inkColour, int pageCount) {
        this.customerName = customerName;
        this.stapling = stapling;
        this.isFast = isFast;
        this.paperSize = paperSize;
        this.paperColour = paperColour;
        this.inkColour = inkColour;
        this.pageCount = pageCount;
        this.pagesLeft = pageCount;
    }

    public String getCustomerName(){ return customerName; }

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
