package koviiv.slf4j.package2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jExample.class);

    public static void main(String ... args) {
        LOGGER.debug("Debug Message from a class {}", Slf4jExample.class.getSimpleName());
        LOGGER.info("INFO Message from a class {}", Slf4jExample.class.getSimpleName());
    }
}
