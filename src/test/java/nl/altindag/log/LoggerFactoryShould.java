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
package nl.altindag.log;

import nl.altindag.log.logger.JavaUtilLoggingLogger;
import nl.altindag.log.logger.Log4j2Logger;
import nl.altindag.log.logger.Slf4jLogger;
import nl.altindag.log.util.ClassLoaderUtils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
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
        try (MockedStatic<ClassLoaderUtils> classLoaderUtilsMockedStatic = mockStatic(ClassLoaderUtils.class)) {
            classLoaderUtilsMockedStatic.when(() -> ClassLoaderUtils.isClassPresent("org.slf4j.Logger")).thenReturn(false);
            classLoaderUtilsMockedStatic.when(() -> ClassLoaderUtils.isClassPresent("org.apache.logging.log4j.Logger")).thenReturn(true);

            Logger logger = LoggerFactory.getLogger("nl.altindag.log");
            assertThat(logger).isInstanceOf(Log4j2Logger.class);
        }
    }

    @Test
    void getLoggerForJavaUtilLoggingLoggerIfSlf4jAndLog4j2IsNotPresentOnTheClasspath() {
        try (MockedStatic<ClassLoaderUtils> classLoaderUtilsMockedStatic = mockStatic(ClassLoaderUtils.class)) {
            classLoaderUtilsMockedStatic.when(() -> ClassLoaderUtils.isClassPresent("org.slf4j.Logger")).thenReturn(false);
            classLoaderUtilsMockedStatic.when(() -> ClassLoaderUtils.isClassPresent("org.apache.logging.log4j.Logger")).thenReturn(false);

            Logger logger = LoggerFactory.getLogger(this.getClass());
            assertThat(logger).isInstanceOf(JavaUtilLoggingLogger.class);
        }
    }

}
