package com.springboot.springbootmybatisredis.logconfig;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Log4j2
public class Log4J2PropertiesConf {

    public void performSomeTask() {
        log.debug("This is a debug message,{}", 10);
        log.info("This is an info message");
        log.warn("This is a warn message");
        log.error("This is an error message");
        log.fatal("This is a fatal message");
    }
}