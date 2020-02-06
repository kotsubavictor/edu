package koviiv.jul.package1;


import java.util.logging.Logger;
import java.util.logging.Level;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class JulLoggerBridgeExample {

    private static final Logger LOGGER = Logger.getLogger(JulLoggerBridgeExample.class.getName());

    public static void main(String ... args) {
        SLF4JBridgeHandler.install();
        LOGGER.log(Level.WARNING,"Debug Message from a class {0}", JulLoggerBridgeExample.class.getSimpleName());
        LOGGER.log(Level.INFO, "INFO Message from a class {0}", JulLoggerBridgeExample.class.getSimpleName());
    }
}
