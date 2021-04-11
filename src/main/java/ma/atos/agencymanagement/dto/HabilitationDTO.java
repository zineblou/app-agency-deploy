package ma.atos.agencymanagement.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.atos.agencymanagement.model.Modification;




import java.util.Date;





@Data
public class HabilitationDTO extends Modification {



    //le libelé
    private String name;
    private Date startDate;
    private Date endDate;







}

