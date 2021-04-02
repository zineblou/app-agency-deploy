package ma.atos.agencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Role> roles = new ArrayList<>();




}

