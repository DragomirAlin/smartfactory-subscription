package ro.dragomialin.subscription.service;

import ro.dragomialin.subscription.repository.Subscription;

public interface SenderService {
    void send(Subscription subscription);
}
