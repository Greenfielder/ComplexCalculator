package impl;

import interfaces.Loggable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class CalcLogger implements Loggable {
    Logger logger = Logger.getLogger("Calc Log: ");
    private FileHandler fileHandler;
    public CalcLogger() throws FileNotFoundException {
        try {
            fileHandler = new FileHandler("log.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fileHandler);
    }
    @Override
    public void log(String message) {
        logger.info(message + "\n");
    }
}

