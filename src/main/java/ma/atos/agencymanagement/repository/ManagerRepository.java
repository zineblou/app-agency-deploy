package ma.atos.agencymanagement.repository;

import ma.atos.agencymanagement.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {

}
