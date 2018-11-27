package com.lestsoos.springboot.scheduled.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Slf4j
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {

    @Value("${scheduled.threadNum}")
    private int threadNum;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //设定一个长度threadNum的定时任务线程池
        log.info("-------------线程数:{}",threadNum);
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(threadNum));
    }
}
