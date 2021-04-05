package ma.atos.agencymanagement.service;


import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.MergedAgency;
import ma.atos.agencymanagement.repository.AgencyRepository;
import ma.atos.agencymanagement.repository.MergedAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {


    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private MergedAgencyRepository mergedAgencyRepository;

    public List<Agency> getAllAgencies(){
        List<Agency> agencies = new ArrayList<>();
        agencyRepository.findAll().forEach(agencies::add);
        return agencies;

    }

    public Optional<Agency> getAgency(Long id){
        return agencyRepository.findById(id);
    }

    public void addAgency(Agency agency){
        agencyRepository.save(agency);
    }

    public void updateAgency(Long id,Agency agency){
        if (agencyRepository.findById(id).get() != null){
            agencyRepository.save(agency);
        }
    }

    public void deleteAgency(Long id){
        agencyRepository.deleteById(id);
    }

    public Agency disableAgency(Long id){
        Agency agency= agencyRepository.findById(id).get();
        agency.setDisable(true);
        return agencyRepository.save(agency);

    }

    public MergedAgency mergeAgencies(List<Long> agenciesID){
        // creation de lobjet agence fusionnée
        MergedAgency mergAg = new MergedAgency();

        List<Agency> agencies = new ArrayList<Agency>();

        for (Long aID: agenciesID
             ) {

            Agency a = this.getAgency(aID).get();
            agencies.add(a);
        }

        //affectation de la liste des agences à fusionner
        mergAg.setMergedAgencies(agencies);

        String mName = "";
        String cSwift = "";

        for (Agency a : agencies)
        {

            //mName +=  a.getName()+"-";
            mName = mName + a.getName()+"-";
            cSwift = cSwift+ a.getSwiftCode()+"-";

            this.disableAgency(a.getPlaceCode());
        }

        mergAg.setName(mName);
        mergAg.setSwiftCode(cSwift);
        mergAg.setBankCode(agencies.get(0).getBankCode());

        mergedAgencyRepository.save(mergAg);







        return mergAg;
    }

}
