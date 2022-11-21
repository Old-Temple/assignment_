package assignment.domain;

import assignment.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Log_table")
@Data

public class Log  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private String message;


    public static LogRepository repository(){
        LogRepository logRepository = CustomerApplication.applicationContext.getBean(LogRepository.class);
        return logRepository;
    }






}
