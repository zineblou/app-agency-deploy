package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;



@Service
public class HabilitationService {
    @Autowired
     private HabilitationRepository habilitationRepository;


    public Habilitation saveHabilitation(Habilitation habilitation) {

        return habilitationRepository.save(habilitation);
    }

    public List<Habilitation> saveHabilitation(List<Habilitation> habilitations)
    {
        return habilitationRepository.saveAll(habilitations);

    }

    public  List<Habilitation> getHabilitations()
    {
        return habilitationRepository.findAll();

    }
 public Habilitation getHabilitationById(long id)
    {
        return habilitationRepository.findById(id).orElse(null);

    }


  public String deleteHabilitation(Long id)
    {
        habilitationRepository.deleteById(id);
        return "habilitation removed !!  "+id;

    }
   public Habilitation updateHabilitation(Habilitation habilitation) {


       Habilitation existingHabilitation = habilitationRepository.findById(habilitation.getId()).orElse(null);
       assert existingHabilitation != null;
       existingHabilitation.setId(habilitation.getId());
       existingHabilitation.setCode(habilitation.getCode());
       existingHabilitation.setName(habilitation.getName());
       existingHabilitation.setStartDate(habilitation.getStartDate());
       existingHabilitation.setEndDate(habilitation.getEndDate());
       return habilitationRepository.save(existingHabilitation);
   }
   


}

