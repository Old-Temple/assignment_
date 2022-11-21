package assignment.domain;

import assignment.domain.Ordered;
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


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();



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






}
