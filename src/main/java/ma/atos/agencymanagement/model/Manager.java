package ma.atos.agencymanagement.model;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Manager extends Modification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationNumber;
    private String firstName;
    private String lastName;
    private Date integrationDate;
    @ManyToOne
    private Manager manager;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Role> roles = new ArrayList<>();



}
