package ma.atos.agencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Habilitation {
    @Id
    private Long id;
    private String code;
    //le libelé
    private String name;
    private Date startDate;
    private Date endDate;



}

