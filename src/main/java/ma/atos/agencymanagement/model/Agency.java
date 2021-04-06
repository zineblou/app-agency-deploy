package ma.atos.agencymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Agency {
    @Id
    private Long placeCode;
    private String name;
    private String bankCode;
    private String swiftCode;
    private Date date;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Manager> managers;
    private boolean disable = false;


    public Agency(Long placeCode, String name, String bankCode, String swiftCode, Date date) {
        this.placeCode = placeCode;
        this.name = name;
        this.bankCode = bankCode;
        this.swiftCode = swiftCode;
        this.date = date;
    }
}
