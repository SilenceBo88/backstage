package com.zb.backstage.core.systemlog;

import com.zb.backstage.model.SystemLog;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zb
 * @Date: Created in 2018/5/31 21:21
 * @Description:
 */
@Component
public class SystemLogQueue {

    private BlockingQueue<SystemLog> blockingQueue = new LinkedBlockingQueue<>();

    public void add(SystemLog systemLog) {
        blockingQueue.add(systemLog);
    }

    public SystemLog poll() throws InterruptedException {
        return blockingQueue.poll(1, TimeUnit.SECONDS);
    }
}
