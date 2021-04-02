package ma.atos.agencymanagement.repository;

import ma.atos.agencymanagement.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgencyRepository extends JpaRepository<Agency,Long> {

}
