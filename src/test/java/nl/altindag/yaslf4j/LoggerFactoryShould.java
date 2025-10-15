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
package nl.altindag.yaslf4j;

import nl.altindag.yaslf4j.logger.JavaUtilLoggingLogger;
import nl.altindag.yaslf4j.logger.Log4j2Logger;
import nl.altindag.yaslf4j.logger.Slf4jLogger;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;

/**
 * @author Hakan Altindag
 */
class LoggerFactoryShould {

    @Test
    void getLoggerForSlf4jIfSlf4jIsPresentOnTheClasspath() {
        Logger logger = LoggerFactory.getLogger("nl.altindag.log");
        assertThat(logger).isInstanceOf(Slf4jLogger.class);
    }

    @Test
    void getLoggerForLog4j2IfSlf4jIsNotPresentOnTheClasspath() {
        try (MockedStatic<Slf4jLogger> slf4jLoggerMockedStatic = mockStatic(Slf4jLogger.class)) {
            slf4jLoggerMockedStatic.when(() -> Slf4jLogger.getLogger(anyString())).thenThrow(new NoClassDefFoundError());

            Logger logger = LoggerFactory.getLogger("nl.altindag.log");
            assertThat(logger).isInstanceOf(Log4j2Logger.class);
        }
    }

    @Test
    void getLoggerForJavaUtilLoggingLoggerIfSlf4jAndLog4j2IsNotPresentOnTheClasspath() {
        try (MockedStatic<Slf4jLogger> slf4jLoggerMockedStatic = mockStatic(Slf4jLogger.class);
             MockedStatic<Log4j2Logger> log4j2LoggerMockedStatic = mockStatic(Log4j2Logger.class)) {

            slf4jLoggerMockedStatic.when(() -> Slf4jLogger.getLogger(anyString())).thenThrow(new NoClassDefFoundError());
            log4j2LoggerMockedStatic.when(() -> Log4j2Logger.getLogger(anyString())).thenThrow(new NoClassDefFoundError());

            Logger logger = LoggerFactory.getLogger(this.getClass());
            assertThat(logger).isInstanceOf(JavaUtilLoggingLogger.class);
        }
    }

}
