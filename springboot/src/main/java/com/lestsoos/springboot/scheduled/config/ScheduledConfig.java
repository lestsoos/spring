package com.lestsoos.springboot.scheduled.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

    @Value("${scheduled.threadNum}")
    private int threadNum;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //设定一个长度threadNum的定时任务线程池
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(threadNum));
    }
}
