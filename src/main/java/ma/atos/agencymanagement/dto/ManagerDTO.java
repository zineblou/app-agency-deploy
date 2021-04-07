package ma.atos.agencymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.Modification;
import ma.atos.agencymanagement.model.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ManagerDTO extends ModificationDTO implements Serializable {


    private Long id;
    private String registrationNumber;
    private String firstName;
    private String lastName;
    private Date integrationDate;

    private List<RoleDTO> roles = new ArrayList<RoleDTO>();

    private ManagerDTO manager;

    private AgencyDTO agency;

    public ManagerDTO(String registrationNumber, String firstName, String lastName, Date integrationDate) {
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.integrationDate = integrationDate;
    }
}
