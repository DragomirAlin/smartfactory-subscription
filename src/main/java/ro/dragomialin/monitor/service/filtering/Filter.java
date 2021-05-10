package ro.dragomialin.monitor.service.filtering;

import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.model.Monitor;

public interface Filter {
    boolean apply(Data data, Monitor monitor);
}
