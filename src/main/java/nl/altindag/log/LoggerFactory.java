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

/**
 *  The {@link LoggerFactory} will construct an instance of {@link Logger}
 *  which will be a wrapper containing the actual Logger. The wrapper logger will be created
 *  based on the available classes on the classpath. If SLF4J API is present it will construct
 *  a wrapper Logger with SLF4J Logger wrapped in it or else it will try Log4j2 and if that is not available
 *  at runtime it will fallback to java-util-logging logger.
 *
 * @author Hakan Altindag
 */
public class LoggerFactory {

    private LoggerFactory() {}

    public static <T> Logger getLogger(Class<T> clazz) {
        return getLogger(clazz.getName());
    }

    public static Logger getLogger(String name) {
        try {
            return Slf4jLogger.getLogger(name);
        } catch (NoClassDefFoundError ignored) {}

        try {
            return Log4j2Logger.getLogger(name);
        } catch (NoClassDefFoundError ignored) {}

        return JavaUtilLoggingLogger.getLogger(name);
    }
}
