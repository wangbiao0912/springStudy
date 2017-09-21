import com.fasterxml.jackson.databind.ser.Serializers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Serializers.Base.class)
@Slf4j
public class SpringbootApplicationTests {


	@Test
	public void contextLoads() {
		String test="!!!!";
		log.info("dddd+ dsa  ${}",test);
	}

}
