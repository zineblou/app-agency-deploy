package ma.atos.agencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeCode;
    private String name;
    private String bankCode;
    private String swiftCode;
    private Date date;
    private boolean disable=false;


}
