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
    @Autowired LogRepository logRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_KakaoAlert(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener KakaoAlert : " + paid + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCancled'")
    public void wheneverPayCancled_KakaoAlert(@Payload PayCancled payCancled){

        PayCancled event = payCancled;
        System.out.println("\n\n##### listener KakaoAlert : " + payCancled + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='AcceptOrder'")
    public void wheneverAcceptOrder_KakaoAlert(@Payload AcceptOrder acceptOrder){

        AcceptOrder event = acceptOrder;
        System.out.println("\n\n##### listener KakaoAlert : " + acceptOrder + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='RejectOrder'")
    public void wheneverRejectOrder_KakaoAlert(@Payload RejectOrder rejectOrder){

        RejectOrder event = rejectOrder;
        System.out.println("\n\n##### listener KakaoAlert : " + rejectOrder + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooking'")
    public void wheneverCooking_KakaoAlert(@Payload Cooking cooking){

        Cooking event = cooking;
        System.out.println("\n\n##### listener KakaoAlert : " + cooking + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderChecked'")
    public void wheneverOrderChecked_KakaoAlert(@Payload OrderChecked orderChecked){

        OrderChecked event = orderChecked;
        System.out.println("\n\n##### listener KakaoAlert : " + orderChecked + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_KakaoAlert(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener KakaoAlert : " + deliveryStarted + "\n\n");


        

        // Sample Logic //

        

    }

}


