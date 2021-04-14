package ma.atos.agencymanagement.dto;


import lombok.Data;
import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.Modification;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.util.Date;



@Data

public class ManagerDTO extends ModificationDTO {




    @NotBlank(message = "registrationNumber is required")
    @Size(min = 3, max = 20, message = "registrationNumber size is between 10 and 20")
    private String registrationNumber;
    @NotNull(message = "firstName is required")
    private String firstName;
    @NotNull(message = "lastName is required")
    private String lastName;
    private Date integrationDate;



    private ManagerDTO manager;

    private Agency agency;

    public ManagerDTO(String registrationNumber, String firstName, String lastName, Date integrationDate) {
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.integrationDate = integrationDate;
    }
}
