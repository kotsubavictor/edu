package koviiv.slf4j.package2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util2.class);

    public static void run() {
        LOGGER.debug("Debug Message from a class {}", Util2.class.getSimpleName());
        LOGGER.info("INFO Message from a class {}", Util2.class.getSimpleName());
    }
}
