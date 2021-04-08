package ma.atos.agencymanagement.dto;



import lombok.Data;

import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.Modification;


import java.util.Date;



@Data

public class ManagerDTO extends Modification {




    private String registrationNumber;
    private String firstName;
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
