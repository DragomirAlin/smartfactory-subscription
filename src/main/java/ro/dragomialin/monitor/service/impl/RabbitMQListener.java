package ro.dragomialin.monitor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.model.Monitor;
import ro.dragomialin.monitor.service.ListenerService;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQListener implements ListenerService {
    private static final String QUEUE_NAME = "queue.mqtt";

    @Override
    @RabbitListener(queues = QUEUE_NAME)
    public void listen(final Monitor subscription) {
        log.info("Message from myQueue: {}.", subscription.getId());
    }




}
