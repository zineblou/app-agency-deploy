package ma.atos.agencymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agencymanagement.model.Agency;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MergedAgencyDTO extends Agency implements Serializable {
    private List<AgencyDTO> mergedAgencies = new ArrayList<>();

}
