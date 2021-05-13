package ro.dragomialin.monitor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.dragomialin.monitor.common.Monitor;

@Repository
public interface MonitorRepository extends MongoRepository<Monitor, String> {
}
