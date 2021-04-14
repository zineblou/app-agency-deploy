package ma.atos.agencymanagement.dto;


import lombok.Data;

import java.util.List;


@Data
public class AgencyDTO extends ModificationDTO{

    private Long placeCode;
    private String name;
    private String bankCode;
    private String swiftCode;


    private List<ManagerDTO> managers;
    private boolean disable = false;



}
