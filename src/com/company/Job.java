package com.company;

public class Job {
    String customerName;
    boolean stapling;
    boolean isFast;
    PaperSize paperSize;
    PaperColour paperColour;
    InkColour inkColour;
    int pageCount;
    private int pagesLeft;

    public Job(String customerName, boolean stapling, boolean isFast, PaperSize paperSize, PaperColour paperColour, InkColour inkColour, int pageCount) {
        this.customerName = customerName;
        this.stapling = stapling;
        this.isFast = isFast;
        this.paperSize = paperSize;
        this.paperColour = paperColour;
        this.inkColour = inkColour;
        this.pageCount = pageCount;
        this.pagesLeft = pageCount;
        System.out.println("Created " + this);
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

    public void printPages(int pages) {
        pagesLeft -= pages;
        if (pagesLeft < 0){
            pagesLeft = 0;
        }
    }

    public String toString(){
        String s = "Job(";
        s += "customerName: " + this.customerName + ", ";
        s += "stapling: "     + this.stapling     + ", ";
        s += "isFast: "       + this.isFast       + ", ";
        s += "paperSize: "    + this.paperSize    + ", ";
        s += "paperColour: "  + this.paperColour  + ", ";
        s += "inkColor: "     + this.inkColour    + ", ";
        s += "pageCount: "    + this.pageCount    + ", ";
        s += "pagesLeft: "    + this.pagesLeft    + "";
        s += ")";
        return s;
    }

    public JobQueue createQueue(){
        return (new JobQueue(this.stapling, this.isFast, this.paperSize, this.paperColour, this.inkColour));
    }
}
