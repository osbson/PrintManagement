package com.company;

import com.sun.javafx.scene.control.InputField;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Shop shop;

    @FXML
    TextField jobName;
    @FXML
    CheckBox jobStapling;
    @FXML
    CheckBox jobIsFast;
    @FXML
    ToggleGroup jobPaperSize;
    @FXML
    ToggleGroup jobPaperColour;
    @FXML
    ToggleGroup jobInkColour;
    @FXML
    TextField jobPageCount;
    @FXML
    ListView<String> printQueueGeneral;
    @FXML
    ListView<String> printQueue1;
    @FXML
    ListView<String> printQueue2;
    @FXML
    ListView<String> printQueue3;
    @FXML
    ListView<String> printQueue4;
    @FXML
    ListView<String> printQueue5;

    ListView[] printQueues ;

    public Controller() {
        shop = new Shop();
        shop.startTick();
        shop.tick(new String[]{"printer", "printer1", "TRUE", "TRUE", "Large", "Blue", "Black"});
        shop.endTick();
        shop.startTick();
        shop.tick(new String[]{"printer", "printer2", "FALSE", "TRUE", "Large", "Blue", "Black"});
        shop.endTick();
        shop.startTick();
        shop.tick(new String[]{"printer", "printer3", "TRUE", "FALSE", "Small", "Blue", "Red"});
        shop.endTick();
        shop.startTick();
        shop.tick(new String[]{"printer", "printer4", "FALSE", "TRUE", "Medium", "White", "Blue"});
        shop.endTick();
        shop.startTick();
        shop.tick(new String[]{"printer", "printer5", "TRUE", "FALSE", "Large", "White", "Blue"});
        shop.endTick();

    }

    @FXML
    public void initialize(){
        printQueues = new ListView[]{printQueue1, printQueue2, printQueue3, printQueue4, printQueue5};
    }

    @FXML
    public void tickIdle(Event e) {
        shop.startTick();
        String[] values = {"idle"};
        shop.tick(values);
        shop.endTick();
        updateViews();
    }

    @FXML
    public void tickJob(Event e) {
        shop.startTick();
        String[] values = {
                "job",
                jobName.getText(),
                Boolean.toString(jobStapling.isSelected()),
                Boolean.toString(jobIsFast.isSelected()),
                ((RadioButton) jobPaperSize.getSelectedToggle()).getText(),
                ((RadioButton) jobPaperColour.getSelectedToggle()).getText(),
                ((RadioButton) jobInkColour.getSelectedToggle()).getText(),
                jobPageCount.getText()
        };
        shop.tick(values);
        shop.endTick();
        updateViews();
    }

    @FXML
    public void tickPrinter(){
        System.out.println("Tick Printer");
    }

    @FXML
    public void tickChange(){
        System.out.println("Tick Change");
    }

    public void updateViews() {
        printQueueGeneral.getItems().clear();
        for (JobQueue jQueue : shop.getQueues()) {
            Boolean free = true;
            for (Printer p : shop.getPrinters()) {
                if (p.checkQueue(jQueue)) {
                    free = false;
                    break;
                }
            }
            if (free) {
                for (Job j : jQueue.getJobs()) {
                    printQueueGeneral.getItems().add(j.getCustomerName() + " " + j.getPagesLeft());
                }
            }
        }
        //update printer queue list views
        for(int j = 0; j < printQueues.length; j++){
            printQueues[j].getItems().clear();
        }
        int i = 0;
        for (Printer p : shop.getPrinters()) {
            JobQueue currentQueues = p.getQueue();
            for(Job j: currentQueues.getJobs()){
                printQueues[i].getItems().add(j.getCustomerName() + " " + j.getPagesLeft());
            }
            i++;
        }
    }
}
