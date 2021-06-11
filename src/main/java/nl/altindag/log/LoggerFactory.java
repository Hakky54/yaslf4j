package nl.altindag.log;

import nl.altindag.log.logger.JavaUtilLoggingLogger;
import nl.altindag.log.logger.Log4j2Logger;
import nl.altindag.log.logger.Slf4jLogger;

/**
 *  The {@link LoggerFactory} will construct an instance of {@link Logger}
 *  which will be a wrapper containing the actual Logger. The wrapper logger will be created
 *  based on the available classes on the classpath. If SLF4J API is present it will construct
 *  a wrapper Logger with SLF4J Logger wrapped in it or else it will try Log4j2 and if that is not available
 *  at runtime it will fallback to java-util-logging logger.
 */
public class LoggerFactory {

    public static <T> Logger getLogger(Class<T> clazz) {
        return getLogger(clazz.getName());
    }

    public static Logger getLogger(String name) {
        try {
            return new Slf4jLogger(name);
        } catch (NoClassDefFoundError ignored) { }

        try {
            return new Log4j2Logger(name);
        } catch (NoClassDefFoundError ignored) { }

        return new JavaUtilLoggingLogger(name);
    }

}
