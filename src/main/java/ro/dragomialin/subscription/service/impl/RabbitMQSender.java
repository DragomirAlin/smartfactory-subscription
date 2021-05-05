package ro.dragomialin.subscription.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.dragomialin.subscription.repository.Subscription;
import ro.dragomialin.subscription.service.SenderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQSender implements SenderService {
    private final RabbitTemplate rabbitTemplate;
    @Value("${smartfactory.rabbitmq.exchange}")
    public String exchange;
    @Value("${smartfactory.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    @Scheduled(fixedDelay = 3000L)
    public void send() {
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(exchange, routingkey, Subscription.builder().id("1").build());
    }
}
