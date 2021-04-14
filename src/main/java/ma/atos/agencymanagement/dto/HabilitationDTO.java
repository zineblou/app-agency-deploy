package ma.atos.agencymanagement.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class HabilitationDTO extends ModificationDTO {


    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "startDate is required")
    private Date startDate;
    @NotNull(message = "endDate is required")
    private Date endDate;


}

