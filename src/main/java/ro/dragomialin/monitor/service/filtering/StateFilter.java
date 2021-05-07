package ro.dragomialin.monitor.service.filtering;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;

@Slf4j
@Service
@RequiredArgsConstructor
public class StateFilter implements Filter {
    @Override
    public boolean apply(Data data) {
        return false;
    }
}
