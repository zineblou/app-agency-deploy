package ma.atos.agencymanagement.dto;

import lombok.Data;
import ma.atos.agencymanagement.model.Agency;

import java.util.ArrayList;
import java.util.List;


@Data
public class MergedAgencyDTO extends Agency {
    private List<AgencyDTO> mergedAgencies = new ArrayList<>();

}
