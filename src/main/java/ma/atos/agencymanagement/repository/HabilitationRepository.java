package ma.atos.agencymanagement.repository;

import ma.atos.agencymanagement.model.Habilitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  HabilitationRepository extends JpaRepository<Habilitation, Long> {



}
