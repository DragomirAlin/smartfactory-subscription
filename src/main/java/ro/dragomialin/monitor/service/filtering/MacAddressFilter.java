package ro.dragomialin.monitor.service.filtering;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.model.Monitor;
import ro.dragomialin.monitor.service.MonitorService;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MacAddressFilter {
    private final MonitorService monitorService;

    public Optional<Monitor> getMonitor(Data data) {
        return monitorService.getAll().stream()
                .filter(m -> m.getMacAddress().equals(data.getMetadata().getMacAddress()))
                .findFirst();
    }
}
