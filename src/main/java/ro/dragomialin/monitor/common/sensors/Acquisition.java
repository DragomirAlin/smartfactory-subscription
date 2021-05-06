package ro.dragomialin.monitor.common.sensors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Acquisition {
    private String type;
}
