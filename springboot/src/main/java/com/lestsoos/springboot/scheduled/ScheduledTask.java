package com.lestsoos.springboot.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * （1）cron：cron表达式，指定任务在特定时间执行；
 * （2）fixedDelay：表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms；
 * （3）fixedDelayString：与fixedDelay含义一样，只是参数类型变为String；
 * （4）fixedRate：表示按一定的频率执行任务，参数类型为long，单位ms；
 * （5）fixedRateString: 与fixedRate的含义一样，只是将参数类型变为String；
 * （6）initialDelay：表示延迟多久再第一次执行任务，参数类型为long，单位ms；
 * （7）initialDelayString：与initialDelay的含义一样，只是将参数类型变为String；
 * （8）zone：时区，默认为当前时区，一般没有用到。
 */
@Slf4j
@Component
public class ScheduledTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelayString = "${scheduled.jobs.fixedDelay}")
    public void getTask1() {
        log.info("任务1,从配置文件加载任务信息，当前时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "${scheduled.jobs.cron}")
    public void getTask2() {
        log.info("任务2,从配置文件加载任务信息，当前时间：" + dateFormat.format(new Date()));
    }

    private int fixedDelayCount = 1;
    private int fixedRateCount = 1;
    private int initialDelayCount = 1;
    private int cronCount = 1;

     @Scheduled(fixedDelay = 5000)        //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    public void testFixDelay() {
        log.info("===fixedDelay: 第{}次执行方法", fixedDelayCount++);
    }

     @Scheduled(fixedRate = 5000)        //fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
    public void testFixedRate() {
        log.info("===fixedRate: 第{}次执行方法", fixedRateCount++);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5000)   //initialDelay = 1000表示延迟1000ms执行第一次任务
    public void testInitialDelay() {
        log.info("===initialDelay: 第{}次执行方法", initialDelayCount++);
    }

    @Scheduled(cron = "0 0/1 * * * ?")  //cron接受cron表达式，根据cron表达式确定定时规则
    public void testCron() {
        log.info("===cron: 第{}次执行方法", cronCount++);
    }
}
