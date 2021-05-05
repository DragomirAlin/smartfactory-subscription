package ro.dragomialin.subscription.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomialin.subscription.repository.Subscription;
import ro.dragomialin.subscription.repository.SubscriptionRepository;
import ro.dragomialin.subscription.service.SubscriptionService;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository repository;

    @Override
    public Subscription add(Subscription subscription) {
        log.info("Add new subscription to system. Subscription type={}.", subscription.getType());
        return repository.save(subscription);
    }

    @Override
    public void delete(String id) {
        Subscription subscription = getById(id);
        log.info("Delete subscription with id={}.", subscription.getId());
        repository.delete(subscription);
    }

    @Override
    public List<Subscription> getAll() {
        log.info("Get all subscriptions.");
        return repository.findAll();
    }

    @Override
    public Subscription getById(String id) {
        log.info("Get subscription by id={}.", id);
        return repository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }
}
