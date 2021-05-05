package ro.dragomialin.subscription.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.dragomialin.subscription.repository.Subscription;
import ro.dragomialin.subscription.service.ListenerService;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQListener implements ListenerService {

    @Override
    @RabbitListener(queues = "smartfactory.queue")
    public void listen(final Subscription subscription) {
        log.info("Message from myQueue: {}.", subscription.getId());
    }




}
