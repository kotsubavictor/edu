package koviiv.jul.package1;


import java.util.logging.Logger;
import java.util.logging.Level;

public class Util3 {

    private static final Logger LOGGER = Logger.getLogger(Util3.class.getName());

    public static void run() {
        LOGGER.log(Level.WARNING,"Debug Message from a class {0}", Util3.class.getSimpleName());
        LOGGER.log(Level.INFO, "INFO Message from a class {0}", Util3.class.getSimpleName());
    }
}
