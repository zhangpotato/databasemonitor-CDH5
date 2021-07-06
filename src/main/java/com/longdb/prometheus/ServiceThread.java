package com.longdb.prometheus;

import java.io.IOException;

/**
 * @author hongtao
 */
public class ServiceThread implements Runnable {
    @Override
    public void run() {
        while (true) {

            try {
                PushMetrics.sendServiceStatus();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    PushMetrics.sendServiceStatus();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
