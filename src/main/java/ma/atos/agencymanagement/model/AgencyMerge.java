package ma.atos.agencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyMerge extends Agency{
    private List<Agency> agencyList = new ArrayList<>();
}
