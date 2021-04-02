package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

@Service
public class HabilitationService {
    @Autowired
     private HabilitationRepository repository;


    public Habilitation saveHabilitation(Habilitation habilitation) {

        return repository.save(habilitation);
    }
    public List<Habilitation> saveHabilitation(List<Habilitation> habilitations)
    {
        return repository.saveAll(habilitations);

    }

    public  List<Habilitation> getHabilitation()
    {
        return repository.findAll();

    }
 public Habilitation getHabilitationById(long id)
    {
        return repository.findById(id).orElse(null);

    }

    public Habilitation getHabilitationByCode(String code)
    {
        return repository.findByCode(code);

    }
  public String deleteHabilitation(Long id)
    {
        repository.deleteById(id);
        return "habilitation removed !!  "+id;

    }
   public Habilitation updateHabilitation(Habilitation habilitation) {


       Habilitation existingHabilitation = repository.findById(habilitation.getId()).orElse(null);
       existingHabilitation.setId(habilitation.getId());
       existingHabilitation.setCode(habilitation.getCode());
       existingHabilitation.setName(habilitation.getName());
       existingHabilitation.setStartDate(habilitation.getStartDate());
       existingHabilitation.setEndDate(habilitation.getEndDate());
       return repository.save(habilitation);
   }
   


}

