package koviiv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import koviiv.slf4j.package1.Util1;
import koviiv.slf4j.package2.Util2;
import koviiv.jul.package1.Util3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class LoggerExample
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerExample.class);

    public static void main(String[] args) throws Exception {
        MDC.put("uuid", "#0");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        SLF4JBridgeHandler.install();

        LOGGER.debug("Debug Message from a class {}", LoggerExample.class.getSimpleName());
        LOGGER.info("INFO Message from a class {}", LoggerExample.class.getSimpleName());

        Future f1 = executorService.submit(() -> Util1.run());
        Future f2 = executorService.submit(() -> Util2.run());
        Future f3 = executorService.submit(() -> Util3.run());

        f1.get();
        f2.get();
        f3.get();

        executorService.shutdown();
        MDC.clear();
    }

}
