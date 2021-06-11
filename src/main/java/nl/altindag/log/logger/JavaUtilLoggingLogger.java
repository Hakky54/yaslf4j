package nl.altindag.log.logger;

import nl.altindag.log.Logger;

import java.util.logging.Level;

public final class JavaUtilLoggingLogger implements Logger {

    private final java.util.logging.Logger logger;

    public JavaUtilLoggingLogger(String name) {
        logger = java.util.logging.Logger.getLogger(name);
    }

    @Override
    public String getName() {
        return logger.getName();
    }

    @Override
    public void trace(String message) {
        logger.log(Level.FINEST, message);
    }

    @Override
    public void trace(String format, Object... arguments) {
        logger.log(Level.FINEST, format, arguments);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        logger.log(Level.FINEST, message, throwable);
    }

    @Override
    public void debug(String message) {
        logger.log(Level.FINER, message);
    }

    @Override
    public void debug(String format, Object... arguments) {
        logger.log(Level.FINER, format, arguments);
    }

    @Override
    public void debug(String message, Throwable throwable) {
        logger.log(Level.FINER, message, throwable);
    }

    @Override
    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    @Override
    public void info(String format, Object... arguments) {
        logger.log(Level.INFO, format, arguments);
    }

    @Override
    public void info(String message, Throwable throwable) {
        logger.log(Level.INFO, message, throwable);
    }

    @Override
    public void warn(String message) {
        logger.log(Level.WARNING, message);
    }

    @Override
    public void warn(String format, Object... arguments) {
        logger.log(Level.WARNING, format, arguments);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        logger.log(Level.WARNING, message, throwable);
    }

    @Override
    public void error(String message) {
        logger.log(Level.SEVERE, message);
    }

    @Override
    public void error(String format, Object... arguments) {
        logger.log(Level.SEVERE, format, arguments);
    }

    @Override
    public void error(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isLoggable(Level.FINEST);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isLoggable(Level.FINER);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isLoggable(Level.INFO);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isLoggable(Level.WARNING);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isLoggable(Level.SEVERE);
    }

}
