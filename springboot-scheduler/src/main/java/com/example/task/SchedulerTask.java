package com.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    private int count = 0;
    @Scheduled(cron = "0 57 0 16 9 7")
    private void process(){
        System.out.println("定时器运行中："+(count++));
    }
}
