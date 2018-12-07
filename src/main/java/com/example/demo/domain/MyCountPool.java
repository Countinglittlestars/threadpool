package com.example.demo.domain;

import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component(value = "myCountPool")
public class MyCountPool extends ThreadPoolTaskExecutor {

    Semaphore semaphore;

    private int limit;

    public MyCountPool(){
        super();
    }

    @Override
    public void execute(Runnable task) {
        ThreadPoolExecutor executor = this.getThreadPoolExecutor();

        try {
            semaphore.acquire();
            executor.execute(task);
        } catch (RejectedExecutionException var4) {
            throw new TaskRejectedException("Executor [" + executor + "] did not accept task: " + task, var4);
        } catch (InterruptedException e) {
            e.printStackTrace();
            semaphore.release();
        }

        semaphore.release();
    }







    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}
