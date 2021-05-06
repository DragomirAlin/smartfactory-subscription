package ro.dragomialin.subscription.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.dragomialin.subscription.model.Subscription;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
