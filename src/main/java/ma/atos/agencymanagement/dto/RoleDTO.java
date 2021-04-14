package ma.atos.agencymanagement.dto;

import lombok.Data;
import ma.atos.agencymanagement.model.Modification;
import javax.validation.constraints.NotNull;




@Data
public class RoleDTO extends Modification {


    @NotNull(message ="name is required")
    private String name;
    @NotNull(message ="Code is required")
    private String code;




}
