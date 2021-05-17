package ro.dragomialin.monitor.service.filter;

import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.Monitor;

public interface Filter {
    boolean apply(Data data, Monitor monitor);
}
