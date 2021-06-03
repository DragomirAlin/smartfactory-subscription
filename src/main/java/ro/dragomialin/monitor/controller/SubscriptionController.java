package ro.dragomialin.monitor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.dragomialin.monitor.common.Subscription;
import ro.dragomialin.monitor.service.SubscriptionService;

import java.util.List;

@RequestMapping("/monitor")
@RestController
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public Subscription addMonitor(@RequestBody Subscription subscription) {
        return subscriptionService.add(subscription);
    }

    @GetMapping("/all")
    public List<Subscription> getAll() {
        return subscriptionService.getAllMonitors();
    }

    @GetMapping("/{id}")
    public Subscription getMonitor(@PathVariable String id){
        return subscriptionService.getMonitorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMonitor(@PathVariable String id){
        subscriptionService.delete(id);
    }

}
