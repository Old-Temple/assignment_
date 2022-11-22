package assignment.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import assignment.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import assignment.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @Autowired
    assignment.external.OrderService orderService;

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='EndCooking'")
    public void wheneverEndCooking_AddDeliveryList(@Payload EndCooking endCooking){

        EndCooking event = endCooking;
        System.out.println("\n\n##### listener AddDeliveryList : " + endCooking + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        

        // Sample Logic //

        

    }

}


