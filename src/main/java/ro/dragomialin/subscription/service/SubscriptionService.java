package ro.dragomialin.subscription.service;

import ro.dragomialin.subscription.repository.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription add(Subscription subscription);
    void delete(String id);
    List<Subscription> getAll();
    Subscription getById(String id);

}
