package ro.dragomialin.monitor.service.filter;

import ro.dragomialin.monitor.common.Monitor;

public class FilterUtils {

    private FilterUtils(){

    }

    public static boolean applyOperator(double firstValue, double secondValue, Monitor.Operator operator){
        return switch (operator){
            case LESS -> firstValue < secondValue;
            case EQUALTO -> firstValue == secondValue;
            case GREATHER -> firstValue > secondValue;
            case None -> true;
        };
    }
}
