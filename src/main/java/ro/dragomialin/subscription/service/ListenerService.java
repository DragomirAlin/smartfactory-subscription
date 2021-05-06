package ro.dragomialin.subscription.service;

import ro.dragomialin.subscription.model.Subscription;

public interface ListenerService {
    void listen(Subscription subscription);
}
