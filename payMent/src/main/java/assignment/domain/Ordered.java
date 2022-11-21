package assignment.domain;

import assignment.domain.*;
import assignment.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long customerId;
    private Integer price;
    private Long shopId;
}


