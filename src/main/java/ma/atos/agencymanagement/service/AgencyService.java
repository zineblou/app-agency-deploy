package ma.atos.agencymanagement.service;


import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.AgencyMerge;
import ma.atos.agencymanagement.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class AgencyService {


    @Autowired
    private AgencyRepository agencyRepository;

    public List<Agency> getAllAgencies() {
        List<Agency> agencies = new ArrayList<>();
        agencyRepository.findAll().forEach(agencies::add);
        return agencies;

    }

    public Optional<Agency> getAgency(Long id) {
        return agencyRepository.findById(id);
    }

    public void addAgency(Agency agency) {
        agencyRepository.save(agency);
    }

    public Agency updateAgency(Agency agency) {

        Agency existingAgency = agencyRepository.findById(agency.getPlaceCode()).orElse(null);
        assert existingAgency != null;
        existingAgency.setName(agency.getName());
        existingAgency.setBankCode(agency.getBankCode());
        existingAgency.setSwiftCode(agency.getSwiftCode());
        existingAgency.setDate(new Date());
        return agencyRepository.save(existingAgency);

    }

    public void deleteAgency(Long id) {

        agencyRepository.deleteById(id);
    }

    public Agency disableAgency(Long id) {
        Agency agency = agencyRepository.findById(id).get();
        agency.setDisable(true);
        return agencyRepository.save(agency);

    }

    public void mergeAgencies(List<Agency> agencyList) {
        AgencyMerge agencyMerge = new AgencyMerge();
        agencyMerge.setAgencyList(agencyList);

        for (Agency temp : agencyList) {
            disableAgency(temp.getPlaceCode());
        }


    }
}
