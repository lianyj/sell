package com.lianyanjie.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lyj
 * @since: 2018/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void tests() {
        String name ="lyj";
        String password ="12345";
        logger.debug("debug....");
        logger.info("name :{},password:{}",name,password);
        logger.error("error...name :{},password:{}",name,password);
    }

}
