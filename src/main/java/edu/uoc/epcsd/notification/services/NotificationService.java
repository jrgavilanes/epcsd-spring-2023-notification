package edu.uoc.epcsd.notification.services;

import edu.uoc.epcsd.notification.kafka.ProductMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class NotificationService {

    public void notifyProductAvailable(ProductMessage productMessage) {

        // TODO: query User service to get the users that have an alert for the specified product, then simulate the
        //  email notification for the alerted users by logging a line with INFO level

    }

}
