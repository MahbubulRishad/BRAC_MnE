package com.binsight.streamstech.utill;

public class General {
    public static final int  WAIT_TIME = 40;

    public static final String GROUP_MANAGEMENT_HOME_PAGE = "https://binsight.streamstech.com/group/Group";

    public static void getLoadTime(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
