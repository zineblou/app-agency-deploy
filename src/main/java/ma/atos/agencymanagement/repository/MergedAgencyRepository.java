package ma.atos.agencymanagement.repository;

import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.MergedAgency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MergedAgencyRepository extends JpaRepository<MergedAgency,Long> {

}
