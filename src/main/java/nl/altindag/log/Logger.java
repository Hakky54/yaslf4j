package nl.altindag.log;

public interface Logger {

    String getName();

    void trace(String message);

    void trace(String format, Object... arguments);

    void trace(String message, Throwable throwable);

    void debug(String message);

    void debug(String format, Object... arguments);

    void debug(String message, Throwable throwable);

    void info(String message);

    void info(String format, Object... arguments);

    void info(String message, Throwable throwable);

    void warn(String message);

    void warn(String format, Object... arguments);

    void warn(String message, Throwable throwable);

    void error(String message);

    void error(String format, Object... arguments);

    void error(String message, Throwable throwable);

    boolean isTraceEnabled();

    boolean isDebugEnabled();

    boolean isInfoEnabled();

    boolean isWarnEnabled();

    boolean isErrorEnabled();

}
