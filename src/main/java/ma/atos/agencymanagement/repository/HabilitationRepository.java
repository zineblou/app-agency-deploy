package ma.atos.agencymanagement.repository;

import jdk.nashorn.internal.objects.NativeArray;
import ma.atos.agencymanagement.model.Habilitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  HabilitationRepository extends JpaRepository<Habilitation, Long> {


    Habilitation findByCode(String code);
}
