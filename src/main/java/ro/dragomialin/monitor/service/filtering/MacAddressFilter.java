package ro.dragomialin.monitor.service.filtering;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.model.Monitor;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MacAddressFilter implements Filter {

    @Override
    public boolean apply(Data data, Monitor monitor) {
        return StringUtils.isBlank(monitor.getMacAddress()) || StringUtils.equals(data.getMetadata().getMacAddress(), monitor.getMacAddress());
    }
}
