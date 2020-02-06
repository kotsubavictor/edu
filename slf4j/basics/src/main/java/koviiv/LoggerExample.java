package koviiv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import koviiv.slf4j.package1.Slf4jMDCExample;
import koviiv.slf4j.package2.Slf4jExample;
import koviiv.jul.package1.JulLoggerBridgeExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggerExample
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerExample.class);

    public static void main(String ... args) throws Exception {
        MDC.put("uuid", "#0");
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        LOGGER.debug("Debug Message from a class {}", LoggerExample.class.getSimpleName());
        LOGGER.info("INFO Message from a class {}", LoggerExample.class.getSimpleName());

        Future f1 = executorService.submit(() -> Slf4jMDCExample.main());
        Future f2 = executorService.submit(() -> Slf4jExample.main());
        Future f3 = executorService.submit(() -> JulLoggerBridgeExample.main());

        f1.get();
        f2.get();
        f3.get();

        executorService.shutdown();
        MDC.clear();
    }

}
