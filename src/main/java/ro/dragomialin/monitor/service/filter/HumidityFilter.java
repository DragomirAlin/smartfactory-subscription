package ro.dragomialin.monitor.service.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.stereotype.Component;
import ro.dragomialin.monitor.common.AcqusitionType;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.sensors.Dth22;
import ro.dragomialin.monitor.common.Monitor;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class HumidityFilter implements Filter {
    private final ObjectMapper objectMapper;
    private final List<AcqusitionType> allowedAcqusitions = List.of(AcqusitionType.DTH11, AcqusitionType.GOOGLE_MINI);

    @Override
    public boolean apply(Data data, Monitor monitor) {
        if (skipIfNotSupported(monitor)) return true;

        Dth22 dth22 = objectMapper.convertValue(data.getPayload(), Dth22.class);
        Monitor.Dth22 dth22Monitor = objectMapper.convertValue(monitor.getCustomMonitor(), Monitor.Dth22.class);
        return FilterUtils.applyOperator(dth22.getHumidify(), dth22Monitor.getHumidityValue(), dth22Monitor.getHumidityOperator());
    }

    private boolean skipIfNotSupported(Monitor monitor) {
        return BooleanUtils.isFalse(allowedAcqusitions.contains(monitor.getAcquisitionType()));
    }
}
