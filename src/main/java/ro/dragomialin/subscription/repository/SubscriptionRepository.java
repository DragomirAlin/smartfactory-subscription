package ro.dragomialin.subscription.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
