package ro.dragomialin.monitor.service;

import ro.dragomialin.monitor.model.Monitor;

public interface SenderService {
    void send(Monitor monitor);
}
