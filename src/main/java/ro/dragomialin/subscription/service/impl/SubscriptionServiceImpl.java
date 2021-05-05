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
        return repository.save(subscription);
    }

    @Override
    public void delete(String id) {
        Subscription subscription = getById(id);
        repository.delete(subscription);
    }

    @Override
    public List<Subscription> getAll() {
        return repository.findAll();
    }

    @Override
    public Subscription getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }
}
