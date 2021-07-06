package com.longdb.prometheus;

import java.io.IOException;

/**
 * @author hongtao
 */
public class HDFSThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                PushMetrics.sendHDFSMetrics();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    PushMetrics.sendHDFSMetrics();
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
