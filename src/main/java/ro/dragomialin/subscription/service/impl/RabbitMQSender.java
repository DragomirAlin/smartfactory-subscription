package ro.dragomialin.subscription.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.dragomialin.subscription.repository.Subscription;
import ro.dragomialin.subscription.service.SenderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQSender implements SenderService {
    private final AmqpTemplate rabbitTemplate;
    @Value("${smartfactory.rabbitmq.exchange}")
    private String exchange;
    @Value("${smartfactory.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public void send(Subscription subscription) {
        rabbitTemplate.convertAndSend(exchange, routingkey, subscription);
    }
}
