package com.longdb;

import com.longdb.prometheus.*;

/**
 * @author hongtao
 */
public class Tool {
    public static void main(String[] args) {
        HBaseThread hbaseThread = new HBaseThread();
        HDFSThread hdfsThread = new HDFSThread();
        LongDBThread longDBThread = new LongDBThread();
        YarnThread yarnThread = new YarnThread();
        ServiceThread serviceThread = new ServiceThread();

        new Thread(hbaseThread).start();
        new Thread(hdfsThread).start();
        new Thread(longDBThread).start();
        new Thread(yarnThread).start();
        new Thread(serviceThread).start();

    }
}
