package edu.uoc.epcsd.notification.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
}
