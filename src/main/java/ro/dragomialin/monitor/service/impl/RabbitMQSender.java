package ro.dragomialin.monitor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.dragomialin.monitor.common.Monitor;
import ro.dragomialin.monitor.service.SenderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQSender implements SenderService {
    private final RabbitTemplate rabbitTemplate;
    @Value("${smartfactory.rabbitmq.mqtt.exchange}")
    private String exchange;
    @Value("${smartfactory.rabbitmq.mqtt.routingkey}")
    private String routingkey;

    @Override
    public void send(Monitor monitor) {
        rabbitTemplate.convertAndSend(exchange, routingkey, monitor);
    }
}
