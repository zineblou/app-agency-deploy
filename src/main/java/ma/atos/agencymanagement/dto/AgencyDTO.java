package ma.atos.agencymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agencymanagement.model.Manager;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



 @NoArgsConstructor @AllArgsConstructor
 @Data
public class AgencyDTO implements Serializable {

    private Long placeCode;
    private String name;
    private String bankCode;
    private String swiftCode;
    private Date date;


    private List<ManagerDTO> managers;
    private boolean disable = false;


    public AgencyDTO(Long placeCode, String name, String bankCode, String swiftCode, Date date) {
        this.placeCode = placeCode;
        this.name = name;
        this.bankCode = bankCode;
        this.swiftCode = swiftCode;
        this.date = date;
    }
}
