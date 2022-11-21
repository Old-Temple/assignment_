package assignment.domain;

import assignment.domain.*;
import assignment.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cooking extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Integer price;
    private String status;

    public Cooking(ShopOrder aggregate){
        super(aggregate);
    }
    public Cooking(){
        super();
    }
}
