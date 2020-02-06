package koviiv.slf4j.package1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Slf4jMDCExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jMDCExample.class);

    public static void main(String ... args) {
        MDC.put("uuid", "#1");
        LOGGER.debug("Debug Message from a class {}", Slf4jMDCExample.class.getSimpleName());
        LOGGER.info("INFO Message from a class {}", Slf4jMDCExample.class.getSimpleName());
        MDC.clear();
    }
}
