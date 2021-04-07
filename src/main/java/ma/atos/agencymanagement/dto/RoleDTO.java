package ma.atos.agencymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.model.Modification;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RoleDTO extends Modification implements Serializable{

    private Long id;
    private String name;
    private String code;



    private List<Manager> managers = new ArrayList<Manager>();


    private List<HabilitationDTO> habilitation = new ArrayList<HabilitationDTO>();

    public RoleDTO(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public RoleDTO(String name, String code) {
        this.name = name;
        this.code = code;
    }

}
