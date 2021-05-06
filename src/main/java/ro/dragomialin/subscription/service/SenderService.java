package ro.dragomialin.subscription.service;

import ro.dragomialin.subscription.model.Subscription;

public interface SenderService {
    void send(Subscription subscription);
}
