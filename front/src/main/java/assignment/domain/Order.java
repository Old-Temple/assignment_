package assignment.domain;

import assignment.domain.OrderCancled;
import assignment.domain.OrderChecked;
import assignment.domain.OrderConfirmed;
import assignment.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private String customerAddress;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private Long shopId;

    @PostPersist
    public void onPostPersist(){


        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();



        OrderChecked orderChecked = new OrderChecked(this);
        orderChecked.publishAfterCommit();



        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        orderConfirmed.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }



    public void order(){
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

    }

    public static void updateStatus(AcceptOrder acceptOrder){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(acceptOrder.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(RejectOrder rejectOrder){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejectOrder.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(OrderConfirmed orderConfirmed){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderConfirmed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
