package ro.dragomialin.monitor.service;

import ro.dragomialin.monitor.common.Monitor;

import java.util.List;

public interface MonitorService {
    Monitor add(Monitor monitor);
    void delete(String id);
    List<Monitor> getAll();
    Monitor getById(String id);

}
