package ma.atos.agencymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import ma.atos.agencymanagement.model.Modification;




@Data
public class RoleDTO extends Modification {



    private String name;
    private String code;




}
