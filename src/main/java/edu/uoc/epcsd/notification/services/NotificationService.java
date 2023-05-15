package edu.uoc.epcsd.notification.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uoc.epcsd.notification.model.UserDTO;
import edu.uoc.epcsd.notification.kafka.ProductMessage;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Log4j2
@Component
public class NotificationService {

    public void notifyProductAvailable(ProductMessage productMessage) throws JsonProcessingException {

        // TODO: query User service to get the users that have an alert for the specified product, then simulate the
        //  email notification for the alerted users by logging a line with INFO level
        log.info("llegaaaaaa: " + productMessage.toString());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        final String uri = "http://localhost:18082/alert/"+ productMessage.getModel() + "/"+ df.format(Calendar.getInstance().getTime()) + "/users";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(uri, String.class);

        ObjectMapper objectMapper = new ObjectMapper();


        List<UserDTO> usersToAlert = objectMapper.readValue(response, new TypeReference<List<UserDTO>>() {
        });

        for (var user : usersToAlert) {
            log.info(user.getEmail());
        }

    }

}
