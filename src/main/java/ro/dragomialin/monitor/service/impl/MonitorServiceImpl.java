package ro.dragomialin.monitor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.exception.HttpError;
import ro.dragomialin.monitor.model.Monitor;
import ro.dragomialin.monitor.repository.MonitorRepository;
import ro.dragomialin.monitor.service.MonitorService;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitorService {
    private final MonitorRepository repository;

    @Override
    public Monitor add(Monitor monitor) {
        log.info("Add new subscription to system. Subscription type={}.", monitor.getAcquisitionType());
        return repository.save(monitor);
    }

    @Override
    public void delete(String id) {
        Monitor monitor = getById(id);
        log.info("Delete subscription with id={}.", monitor.getId());
        repository.delete(monitor);
    }

    @Override
    public List<Monitor> getAll() {
        log.info("Get all subscriptions.");
        return repository.findAll();
    }

    @Override
    public Monitor getById(String id) {
        log.info("Get subscription by id={}.", id);
        return repository.findById(id)
                .orElseThrow(() -> HttpError.notFound(String.format("Monitor with id %s was not found.", id)));
    }
}
