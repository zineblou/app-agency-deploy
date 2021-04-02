package ma.atos.agencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Role extends Modification{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Manager> managers = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Habilitation>  habilitation = new ArrayList<>();

    public Role( String name,String code){
        this.name = name;
        this.code = code;
    }

}
