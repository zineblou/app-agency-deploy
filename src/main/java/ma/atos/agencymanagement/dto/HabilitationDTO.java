package ma.atos.agencymanagement.dto;

import lombok.Data;
import ma.atos.agencymanagement.model.Modification;

import java.util.Date;





@Data
public class HabilitationDTO extends Modification {



    //le libelé
    private String name;
    private Date startDate;
    private Date endDate;







}

