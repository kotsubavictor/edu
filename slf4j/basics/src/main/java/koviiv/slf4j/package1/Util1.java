package koviiv.slf4j.package1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Util1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util1.class);

    public static void run() {
        MDC.put("uuid", "#1");
        LOGGER.debug("Debug Message from a class {}", Util1.class.getSimpleName());
        LOGGER.info("INFO Message from a class {}", Util1.class.getSimpleName());
        MDC.clear();
    }
}
