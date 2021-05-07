package ro.dragomialin.monitor.service.filtering;

import ro.dragomialin.monitor.common.Data;

public interface Filter {

    boolean apply(Data data);
}
