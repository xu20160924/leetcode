package com.john;

public class MonitorService {
    private volatile boolean starting;

    public void start() {
        System.out.println("尝试启动监控线程....");
        synchronized (this) {
            if (starting) {
                return;
            }
            starting = true;
        }
    }
}

