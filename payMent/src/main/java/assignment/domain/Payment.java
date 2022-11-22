package assignment.domain;

import assignment.domain.Paid;
import assignment.domain.PayCancled;
import assignment.PayMentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Payment_table")
@Data

public class Payment  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private Long shopId;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Boolean status;

    @PostPersist
    public void onPostPersist(){


        Paid paid = new Paid(this);
        paid.publishAfterCommit();



        PayCancled payCancled = new PayCancled(this);
        payCancled.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PayMentApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }




    public static void acceptPay(Ordered ordered){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

        
    }
    public static void rejectPay(OrderCancled orderCancled){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancled.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

        
    }
    public static void rejectPay(RejectOrder rejectOrder){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejectOrder.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

        
    }


}
