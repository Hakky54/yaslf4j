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
package nl.altindag.yaslf4j.logger;

import nl.altindag.yaslf4j.Logger;

import java.util.logging.Level;

/**
 * @author Hakan Altindag
 */
public final class JavaUtilLoggingLogger implements Logger {

    private final java.util.logging.Logger logger;

    private JavaUtilLoggingLogger(String name) {
        logger = java.util.logging.Logger.getLogger(name);
    }

    public static Logger getLogger(String name) {
        return new JavaUtilLoggingLogger(name);
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
    public void trace(String message, Throwable throwable) {
        logger.log(Level.FINEST, message, throwable);
    }

    @Override
    public void debug(String message) {
        logger.log(Level.FINER, message);
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
    public void info(String message, Throwable throwable) {
        logger.log(Level.INFO, message, throwable);
    }

    @Override
    public void warn(String message) {
        logger.log(Level.WARNING, message);
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
