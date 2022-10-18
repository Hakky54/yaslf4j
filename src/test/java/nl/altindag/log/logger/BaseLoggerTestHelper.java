/*
 * Copyright 2021 Thunderberry.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.altindag.log.logger;

import nl.altindag.log.LogCaptor;
import nl.altindag.log.Logger;
import nl.altindag.log.model.LogEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Hakan Altindag
 */
abstract class BaseLoggerTestHelper {

    static final String LOGGER_NAME = "nl.altindag.log";
    private LogCaptor logCaptor;

    abstract Logger getLoggerImplementation();

    @BeforeEach
    void setupLogCaptor() {
        logCaptor = LogCaptor.forName(getLoggerImplementation().getName());
        logCaptor.setLogLevelToTrace();
    }

    @AfterEach
    void tearDown() {
        logCaptor.close();
    }

    @Test
    void getName() {
        Logger logger = getLoggerImplementation();
        assertThat(logger.getName()).isEqualTo(LOGGER_NAME);
    }

    @Test
    void logTraceMessage() {
        Logger logger = getLoggerImplementation();
        logger.trace("Hello");

        assertThat(logCaptor.getTraceLogs())
                .hasSize(1)
                .contains("Hello");
    }

    @Test
    void logTraceMessageWithException() {
        Logger logger = getLoggerImplementation();
        logger.trace("Hello", new RuntimeException("KABOOM!"));

        assertThat(logCaptor.getLogEvents()).hasSize(1);

        LogEvent logEvent = logCaptor.getLogEvents().get(0);
        assertThat(logEvent.getLevel()).isEqualTo("TRACE");
        assertThat(logEvent.getFormattedMessage()).isEqualTo("Hello");

        assertThat(logEvent.getThrowable()).isPresent();
        assertThat(logEvent.getThrowable().get())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("KABOOM!");
    }

    @Test
    void logDebugMessage() {
        Logger logger = getLoggerImplementation();
        logger.debug("Hello");

        assertThat(logCaptor.getDebugLogs())
                .hasSize(1)
                .contains("Hello");
    }

    @Test
    void logDebugMessageWithException() {
        Logger logger = getLoggerImplementation();
        logger.debug("Hello", new RuntimeException("KABOOM!"));

        assertThat(logCaptor.getLogEvents()).hasSize(1);

        LogEvent logEvent = logCaptor.getLogEvents().get(0);
        assertThat(logEvent.getLevel()).isEqualTo("DEBUG");
        assertThat(logEvent.getFormattedMessage()).isEqualTo("Hello");

        assertThat(logEvent.getThrowable()).isPresent();
        assertThat(logEvent.getThrowable().get())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("KABOOM!");
    }

    @Test
    void logInfoMessage() {
        Logger logger = getLoggerImplementation();
        logger.info("Hello");

        assertThat(logCaptor.getInfoLogs())
                .hasSize(1)
                .contains("Hello");
    }

    @Test
    void logInfoMessageWithException() {
        Logger logger = getLoggerImplementation();
        logger.info("Hello", new RuntimeException("KABOOM!"));

        assertThat(logCaptor.getLogEvents()).hasSize(1);

        LogEvent logEvent = logCaptor.getLogEvents().get(0);
        assertThat(logEvent.getLevel()).isEqualTo("INFO");
        assertThat(logEvent.getFormattedMessage()).isEqualTo("Hello");

        assertThat(logEvent.getThrowable()).isPresent();
        assertThat(logEvent.getThrowable().get())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("KABOOM!");
    }

    @Test
    void logWarnMessage() {
        Logger logger = getLoggerImplementation();
        logger.warn("Hello");

        assertThat(logCaptor.getWarnLogs())
                .hasSize(1)
                .contains("Hello");
    }

    @Test
    void logWarnMessageWithException() {
        Logger logger = getLoggerImplementation();
        logger.warn("Hello", new RuntimeException("KABOOM!"));

        assertThat(logCaptor.getLogEvents()).hasSize(1);

        LogEvent logEvent = logCaptor.getLogEvents().get(0);
        assertThat(logEvent.getLevel()).isEqualTo("WARN");
        assertThat(logEvent.getFormattedMessage()).isEqualTo("Hello");

        assertThat(logEvent.getThrowable()).isPresent();
        assertThat(logEvent.getThrowable().get())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("KABOOM!");
    }

    @Test
    void logErrorMessage() {
        Logger logger = getLoggerImplementation();
        logger.error("Hello");

        assertThat(logCaptor.getErrorLogs())
                .hasSize(1)
                .contains("Hello");
    }

    @Test
    void logErrorMessageWithException() {
        Logger logger = getLoggerImplementation();
        logger.error("Hello", new RuntimeException("KABOOM!"));

        assertThat(logCaptor.getLogEvents()).hasSize(1);

        LogEvent logEvent = logCaptor.getLogEvents().get(0);
        assertThat(logEvent.getLevel()).isEqualTo("ERROR");
        assertThat(logEvent.getFormattedMessage()).isEqualTo("Hello");

        assertThat(logEvent.getThrowable()).isPresent();
        assertThat(logEvent.getThrowable().get())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("KABOOM!");
    }

    @Test
    void returnIsTraceEnabled() {
        assertThat(getLoggerImplementation().isTraceEnabled()).isTrue();
    }

    @Test
    void returnIsDebugEnabled() {
        assertThat(getLoggerImplementation().isDebugEnabled()).isTrue();
    }

    @Test
    void returnIsInfoEnabled() {
        assertThat(getLoggerImplementation().isInfoEnabled()).isTrue();
    }

    @Test
    void returnIsWarnEnabled() {
        assertThat(getLoggerImplementation().isWarnEnabled()).isTrue();
    }

    @Test
    void returnIsErrorEnabled() {
        assertThat(getLoggerImplementation().isErrorEnabled()).isTrue();
    }
}
