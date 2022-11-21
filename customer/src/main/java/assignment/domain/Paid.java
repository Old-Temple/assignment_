package assignment.domain;

import assignment.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Paid extends AbstractEvent {

    private Long id;
    private Integer price;
    private Long customerId;
    private Long shopId;
    private Long menuId;
    private Boolean status;
}
