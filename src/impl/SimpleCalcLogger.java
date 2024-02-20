package impl;

import interfaces.Loggable;

public class SimpleCalcLogger implements Loggable {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

