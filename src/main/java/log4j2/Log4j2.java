package log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2.class);

    public static void main(String[] args) {
    	LOGGER.info("a test message");
    }
}