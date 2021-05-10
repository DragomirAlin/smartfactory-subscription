package ro.dragomialin.monitor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.model.Monitor;
import ro.dragomialin.monitor.service.filtering.Filter;
import ro.dragomialin.monitor.service.filtering.MacAddressFilter;
import ro.dragomialin.monitor.service.impl.RabbitMQSender;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageGateway {
    private final MonitorService monitorService;
    private final Filter temperatureFilter;
    private final Filter humidityFilter;
    private final MacAddressFilter macAddressFilter;
    private final RabbitMQSender rabbitMQSender;

    public void applyFilters(Data data) {
        monitorService.getAll().forEach(m -> handle(data, m));
    }

    private boolean checkFilters(Data data, Monitor monitor) {
        boolean isAlert = macAddressFilter.apply(data, monitor);
        isAlert |= temperatureFilter.apply(data, monitor);
        isAlert |= humidityFilter.apply(data, monitor);

        return isAlert;
    }

    private void handle(Data data, Monitor monitor) {
        boolean isAlert = this.checkFilters(data, monitor);

        if (isAlert) {
            log.info("Send notification for monitor={}.", monitor.getId());
            rabbitMQSender.send(monitor);
        }
    }
}
