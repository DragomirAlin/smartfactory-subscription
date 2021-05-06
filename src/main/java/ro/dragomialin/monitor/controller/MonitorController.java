package ro.dragomialin.monitor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.dragomialin.monitor.service.MonitorService;

@RequestMapping("/monitor")
@RestController
@RequiredArgsConstructor
public class MonitorController {
    private final MonitorService monitorService;



}
