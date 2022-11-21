package assignment.domain;

import assignment.domain.*;
import assignment.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long customerId;
    private Integer price;
}


