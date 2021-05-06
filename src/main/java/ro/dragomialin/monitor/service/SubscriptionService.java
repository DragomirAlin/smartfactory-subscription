package ro.dragomialin.monitor.service;

import ro.dragomialin.monitor.model.Monitor;

import java.util.List;

public interface SubscriptionService {
    Monitor add(Monitor monitor);
    void delete(String id);
    List<Monitor> getAll();
    Monitor getById(String id);

}
