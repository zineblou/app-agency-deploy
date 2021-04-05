package ma.atos.agencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role extends Modification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @LazyCollection(LazyCollectionOption.FALSE)

    @ManyToMany
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Manager> managers = new ArrayList<Manager>();
    @LazyCollection(LazyCollectionOption.FALSE)

    @ManyToMany
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Habilitation> habilitation = new ArrayList<Habilitation>();

    public Role(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Role(String name, String code) {
        this.name = name;
        this.code = code;
    }

}
