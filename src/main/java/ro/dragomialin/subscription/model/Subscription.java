package ro.dragomialin.subscription.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class Subscription {
    public String id;
    public Type type;
    public long version;
    public Object subscription;
    @CreatedDate
    public Date createdAt;
    @LastModifiedDate
    public Date updatedAt;

    public enum Type {
        DEVICE, TOPIC,
    }
}
