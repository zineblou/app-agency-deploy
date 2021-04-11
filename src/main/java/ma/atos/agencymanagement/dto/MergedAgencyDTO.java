package ma.atos.agencymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agencymanagement.model.Agency;

import java.util.ArrayList;
import java.util.List;


@Data
public class MergedAgencyDTO extends Agency {
    private List<AgencyDTO> mergedAgencies = new ArrayList<>();

}