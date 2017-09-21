package com.after;

import com.fasterxml.jackson.databind.ser.Serializers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
/**
 *1. 程序报这种错误 ==java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test==
 *
 *	不同分支branch的包名不同会导致这个错误，在本分支test下添加@SpringBootTest(classes=Base.class)//base.java位于本分支下或者将包名改为与其他分支一样的路径。就可以了！
 */
@SpringBootTest(classes=Serializers.Base.class)
@Slf4j
public class SpringbootApplicationTests {


	@Test
	public void contextLoads() {
		String test="!!!!";
		log.info("dddd+ dsa  ${}",test);
	}

}
