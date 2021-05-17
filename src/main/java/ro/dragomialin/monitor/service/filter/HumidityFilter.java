package ro.dragomialin.monitor.service.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.sensors.Dth22;
import ro.dragomialin.monitor.common.Monitor;

@Slf4j
@Component
@RequiredArgsConstructor
public class HumidityFilter implements Filter {
    private final ObjectMapper objectMapper;

    @Override
    public boolean apply(Data data, Monitor monitor) {
        Dth22 dth22 = objectMapper.convertValue(data.getPayload(), Dth22.class);
        return applyOperator(dth22, monitor);
    }

    private boolean applyOperator(Dth22 dth22, Monitor monitor) {
        return switch (monitor.getOperator()) {
            case LESS -> dth22.getHumidify() < monitor.getValue();
            case EQUAL -> dth22.getHumidify() == monitor.getValue();
        };
    }
}
