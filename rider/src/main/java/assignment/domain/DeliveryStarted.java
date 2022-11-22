package assignment.domain;

import assignment.domain.*;
import assignment.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Long customerId;
    private Integer price;
    private String customerAddress;
    private String shopAddress;

    public DeliveryStarted(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryStarted(){
        super();
    }
}
