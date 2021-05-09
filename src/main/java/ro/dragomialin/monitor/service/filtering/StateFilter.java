package ro.dragomialin.monitor.service.filtering;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.model.Monitor;

@Slf4j
@Service
@RequiredArgsConstructor
public class StateFilter implements Filter {
    @Override
    public boolean apply(Data data, Monitor monitor) {
        return false;
    }
}
