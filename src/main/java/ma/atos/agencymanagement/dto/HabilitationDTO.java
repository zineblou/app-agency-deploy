package ma.atos.agencymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.atos.agencymanagement.model.Modification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class HabilitationDTO extends Modification implements Serializable {



    private Long id;
    private String code;
    //le libelé
    private String name;
    private Date startDate;
    private Date endDate;



    public HabilitationDTO(String code, String name, Date startDate, Date endDate) {
        this.code = code;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }


}

