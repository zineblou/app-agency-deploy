package ma.atos.agencymanagement.dto;

import lombok.Data;
import ma.atos.agencymanagement.model.Modification;




@Data
public class RoleDTO extends Modification {



    private String name;
    private String code;




}
