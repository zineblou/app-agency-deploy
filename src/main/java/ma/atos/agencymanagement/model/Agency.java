package ma.atos.agencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Agency {
    @Id
    private Long placeCode;
    private String name;
    private String bankCode;
    private String swiftCode;
    private Date date;
}
