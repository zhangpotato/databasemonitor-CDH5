package com.longdb.prometheus;

import java.io.IOException;

/**
 * @author hongtao
 */
public class HBaseThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                PushMetrics.sendHBaseMetrics();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    PushMetrics.sendHBaseMetrics();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
