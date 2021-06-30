package com.mafei.webfluxdemo.utils;

/*
  @Author mafei
  @Created 6/30/2021 5:13 PM  
*/
public class SleepUtil {
    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
