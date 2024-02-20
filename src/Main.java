import impl.CalcLogger;
import impl.ComplexCalculatorWithLog;
import interfaces.Loggable;
import util.View;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {

        Loggable logs = null;
        try {
            logs = new CalcLogger();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        Loggable logs = new SimpleCalcLogger();

        View view = new View(new ComplexCalculatorWithLog(logs));
        view.run();
    }
}
