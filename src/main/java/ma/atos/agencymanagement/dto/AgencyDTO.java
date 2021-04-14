package ma.atos.agencymanagement.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Data
public class AgencyDTO extends ModificationDTO{
    @NotNull(message = "placeCode is required")
    private Long placeCode;
    @NotNull(message = "Name is required")
    private String name;
    @NotBlank(message = " bankCode is required")
    @Size(min = 3, max = 20, message = " bankCode size is between 10 and 20")
    private String bankCode;
    @NotNull(message = "SwiftCode is required")
    private String swiftCode;


    private List<ManagerDTO> managers;
    private boolean disable = false;



}
