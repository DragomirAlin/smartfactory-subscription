package ro.dragomialin.monitor.common.sensors;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class Dth22 {
    private double temperature;
    private double humidify;
}
