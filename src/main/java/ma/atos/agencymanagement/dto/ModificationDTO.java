package ma.atos.agencymanagement.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class ModificationDTO {
    private Date modificationDate;
}
