package ma.atos.agencymanagement.repository;

import ma.atos.agencymanagement.model.Habilitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  HabilitationRepository extends JpaRepository<Habilitation, Long> {

    @Autowired
    public Habilitation findHabilitationById(Long id);


}
