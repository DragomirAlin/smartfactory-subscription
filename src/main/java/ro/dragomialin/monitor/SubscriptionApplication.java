package ro.dragomialin.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SubscriptionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SubscriptionApplication.class, args);
	}

}
