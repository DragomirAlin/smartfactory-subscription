package ro.dragomialin.monitor.service.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.common.Subscription;

@Slf4j
@Service
@RequiredArgsConstructor
public class StateFilter implements Filter {
    @Override
    public boolean apply(Data data, Subscription subscription) {
        return false;
    }
}
