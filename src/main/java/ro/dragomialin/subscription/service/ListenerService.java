package ro.dragomialin.subscription.service;

import ro.dragomialin.subscription.repository.Subscription;

public interface ListenerService {
    void listen(Subscription subscription);
}
