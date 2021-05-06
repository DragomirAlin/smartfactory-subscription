package ro.dragomialin.monitor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Data;
import ro.dragomialin.monitor.service.FilterService;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {


    @Override
    public boolean doFilter(Data data) {
        return false;
    }
}
