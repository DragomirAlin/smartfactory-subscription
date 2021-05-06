package ro.dragomialin.monitor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;


@Data
@Builder
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class Monitor {
    private String id;
    private String macAddress;
    private String acquisitionType;
    private Type type;
    private double value;
    private boolean sendEmail;
    private boolean sendSMS;
    @Email
    private String email;
    private String phoneNumber;

    public enum Type {
        LESS, EQUAL
    }
}
