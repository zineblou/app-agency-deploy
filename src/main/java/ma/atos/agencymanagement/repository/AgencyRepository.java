package ma.atos.agencymanagement.repository;

import ma.atos.agencymanagement.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgencyRepository<T extends Agency> extends JpaRepository<T,Long> {

}
