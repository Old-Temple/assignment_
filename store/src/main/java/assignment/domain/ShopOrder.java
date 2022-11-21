package assignment.domain;

import assignment.domain.AcceptOrder;
import assignment.domain.Cooking;
import assignment.domain.RejectOrder;
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



        Cooking cooking = new Cooking(this);
        cooking.publishAfterCommit();



        RejectOrder rejectOrder = new RejectOrder(this);
        rejectOrder.publishAfterCommit();

    }

    public static ShopOrderRepository repository(){
        ShopOrderRepository shopOrderRepository = StoreApplication.applicationContext.getBean(ShopOrderRepository.class);
        return shopOrderRepository;
    }






}
