package com.binsight.streamstech.utill;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class General {


    public static final int  WAIT_TIME = 50;

    public static final String GROUP_MANAGEMENT_HOME_PAGE = "https://binsight.streamstech.com/group/Group";

    public static void getLinkLoadTime(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getMiniWaitTime(){
        try{
            Thread.sleep(500);
        }catch (Exception e){
            System.out.println("Not Found");
        }
    }


}
