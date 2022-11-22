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
    @Autowired PaymentRepository paymentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Ordered'")
    public void wheneverOrdered_AcceptPay(@Payload Ordered ordered){

        Ordered event = ordered;
        System.out.println("\n\n##### listener AcceptPay : " + ordered + "\n\n");


        

        // Sample Logic //
        Payment.acceptPay(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancled'")
    public void wheneverOrderCancled_RejectPay(@Payload OrderCancled orderCancled){

        OrderCancled event = orderCancled;
        System.out.println("\n\n##### listener RejectPay : " + orderCancled + "\n\n");


        

        // Sample Logic //
        Payment.rejectPay(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='RejectOrder'")
    public void wheneverRejectOrder_RejectPay(@Payload RejectOrder rejectOrder){

        RejectOrder event = rejectOrder;
        System.out.println("\n\n##### listener RejectPay : " + rejectOrder + "\n\n");


        

        // Sample Logic //
        Payment.rejectPay(event);
        

        

    }

}


