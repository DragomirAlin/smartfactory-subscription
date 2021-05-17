package ro.dragomialin.monitor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.Monitor;
import ro.dragomialin.monitor.service.filter.Filter;
import ro.dragomialin.monitor.service.impl.RabbitMQSender;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageGateway {
    private final MonitorService monitorService;
    private final RabbitMQSender rabbitMQSender;
    private final ApplicationContext applicationContext;
    private Map<String, Filter> filterList;

    @PostConstruct
    public void addFilters() {
        this.filterList = applicationContext.getBeansOfType(Filter.class);
    }

    public void processData(Data data) {
        monitorService.getAllMonitors()
                .forEach(monitor -> this.handle(data, monitor));
    }

    private boolean applyFilters(Data data, Monitor monitor) {
        return filterList.values().stream()
                .allMatch(f -> f.apply(data, monitor));
    }

    private void handle(Data data, Monitor monitor) {
        boolean isAlert = this.applyFilters(data, monitor);

        if (isAlert) {
            log.info("Send notification for monitor={}.", monitor.getId());
            rabbitMQSender.send(monitor);
        }
    }
}
