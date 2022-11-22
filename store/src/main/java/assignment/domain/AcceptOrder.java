package assignment.domain;

import assignment.domain.*;
import assignment.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class AcceptOrder extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Integer price;
    private String status;

    public AcceptOrder(ShopOrder aggregate){
        super(aggregate);
    }
    public AcceptOrder(){
        super();
    }
}
