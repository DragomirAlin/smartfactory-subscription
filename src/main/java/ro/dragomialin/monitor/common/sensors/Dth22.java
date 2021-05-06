package ro.dragomialin.monitor.common.sensors;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@SuperBuilder
public class Dth22 extends Acquisition{
    private double temperature;
    private double humidify;
}
