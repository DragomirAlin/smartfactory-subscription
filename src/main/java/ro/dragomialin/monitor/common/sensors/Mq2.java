package ro.dragomialin.monitor.common.sensors;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class Mq2 {
    private double gasValue;
}
