package com.after00;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * 项目启动开始后执行
 * @author wangbiao
 *
 */
@Component
@Slf4j
public class StartBegin implements CommandLineRunner {
	@Value("${fruit.apple}")
	private String apple;
	@Override
	public void run(String... args) throws Exception {
        System.out.println("1111111111111111"+apple);
	}

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    //每10分钟执行一次
    @Scheduled(fixedRate = 3000)
    private void doSomething() {
      System.out.println(sdf.format(new Date()));
	  log.info(apple+"..");
    }

}
