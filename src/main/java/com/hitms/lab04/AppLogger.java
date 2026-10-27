package com.hitms.lab04;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Lab task showing structured logging. The println calls from earlier
 * labs become Logger calls written to app.log next to the project root.
 */
public final class AppLogger {

    /** Logger shared by the demo. */
    private static final Logger LOGGER = Logger.getLogger(AppLogger.class.getName());

    /** Prevents instantiation of this demo class. */
    private AppLogger() {
    }

    /**
     * Configures a file handler and writes two info records to app.log.
     *
     * @param args command line arguments, ignored
     * @throws IOException if app.log cannot be opened for writing
     */
    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler("app.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fileHandler);
        LOGGER.setLevel(Level.INFO);
        LOGGER.setUseParentHandlers(false);

        LOGGER.info("Starting process...");
        LOGGER.info("Step completed");
        fileHandler.close();
    }
}
