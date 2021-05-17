package ro.dragomialin.monitor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.Monitor;
import ro.dragomialin.monitor.service.filter.FilterService;
import ro.dragomialin.monitor.service.impl.RabbitMQSender;


@Slf4j
@Service
@RequiredArgsConstructor
public class MessageGateway {
    private final MonitorService monitorService;
    private final RabbitMQSender rabbitMQSender;
    private final FilterService filterService;

    public void processData(Data data) {
        monitorService.getAllMonitors()
                .forEach(monitor -> this.handle(data, monitor));
    }

    private void handle(Data data, Monitor monitor) {
        boolean isAlert = filterService.applyFilters(data, monitor);

        if (isAlert) {
            log.info("Send notification for monitor={}.", monitor.getId());
            rabbitMQSender.send(monitor);
        }
    }
}
