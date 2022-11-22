package assignment.domain;

import assignment.domain.AcceptOrder;
import assignment.domain.RejectOrder;
import assignment.domain.StartCooking;
import assignment.domain.EndCooking;
import assignment.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="ShopOrder_table")
@Data

public class ShopOrder  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Long shopId;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        AcceptOrder acceptOrder = new AcceptOrder(this);
        acceptOrder.publishAfterCommit();



        RejectOrder rejectOrder = new RejectOrder(this);
        rejectOrder.publishAfterCommit();



        StartCooking startCooking = new StartCooking(this);
        startCooking.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        assignment.external.Delivery delivery = new assignment.external.Delivery();
        // mappings goes here
        StoreApplication.applicationContext.getBean(assignment.external.DeliveryService.class)
            .accept(delivery);


        EndCooking endCooking = new EndCooking(this);
        endCooking.publishAfterCommit();

    }

    public static ShopOrderRepository repository(){
        ShopOrderRepository shopOrderRepository = StoreApplication.applicationContext.getBean(ShopOrderRepository.class);
        return shopOrderRepository;
    }




    public static void addOrder(Paid paid){

        /** Example 1:  new item 
        ShopOrder shopOrder = new ShopOrder();
        repository().save(shopOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(shopOrder->{
            
            shopOrder // do something
            repository().save(shopOrder);


         });
        */

        
    }
    public static void deleteOrder(PayCancled payCancled){

        /** Example 1:  new item 
        ShopOrder shopOrder = new ShopOrder();
        repository().save(shopOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCancled.get???()).ifPresent(shopOrder->{
            
            shopOrder // do something
            repository().save(shopOrder);


         });
        */

        
    }
    public static void updateStatus(OrderConfirmed orderConfirmed){

        /** Example 1:  new item 
        ShopOrder shopOrder = new ShopOrder();
        repository().save(shopOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderConfirmed.get???()).ifPresent(shopOrder->{
            
            shopOrder // do something
            repository().save(shopOrder);


         });
        */

        
    }


}
