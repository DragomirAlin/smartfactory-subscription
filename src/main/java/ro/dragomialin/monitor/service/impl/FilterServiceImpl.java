package ro.dragomialin.monitor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.model.Monitor;
import ro.dragomialin.monitor.service.FilterService;
import ro.dragomialin.monitor.service.MonitorService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {
    private final MonitorService monitorService;
    private final ObjectMapper objectMapper;

    @Override
    public boolean doFilter(Data data) {
        List<Monitor> monitors = monitorService.getAll();
        return false;
    }
}
