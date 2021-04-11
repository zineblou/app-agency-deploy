package ma.atos.agencymanagement.controller;
import ma.atos.agencymanagement.converter.AgencyConverter;
import ma.atos.agencymanagement.dto.AgencyDTO;
import ma.atos.agencymanagement.exception.AgencyNotFoundException;
import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.service.AgencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgencyController {

    @Autowired
    private AgencyService agencyService;
    @Autowired
    private AgencyConverter agencyConverter;


    // add List of agencies
    @GetMapping("/agencies")
    public List<AgencyDTO> getAllAgencies(){

//
        return agencyConverter.FromListAgencysToListAgencysDto(agencyService.getAllAgencies());

    }
// Get Agencies By Id
    @GetMapping("/agencies/{pId}")
    public AgencyDTO getAgencyDTO(@PathVariable("pId") Long id){
//
        return agencyConverter.FromAgencyToAgencyDto(agencyService.getAgency(id).get());

    }


    @PostMapping("/agencies")
    public String addAgency( AgencyDTO agencyDTO){
       agencyConverter.FromAgencyToAgencyDto(agencyService.addAgency(agencyConverter.FromAgencyDtoToAgency(agencyDTO)));
        return "The agency created successfully";
    }


    //Update agencies
    @PutMapping("/agencies")
    public String updateAgency(@RequestBody AgencyDTO agencyDTO){
        agencyConverter.FromAgencyToAgencyDto(agencyService.updateAgency(agencyConverter.FromAgencyDtoToAgency(agencyDTO)));
        return "Agency updated successfully";
    }

    //Delete agencies by id
    @DeleteMapping("/agencies/{pId}")
    public String deleteAgency(@PathVariable("pId") Long id){
    agencyService.deleteAgency(id);
        return "Agency deleted successfully";
    }

    //Disable agency
    @PutMapping("/disable/{pId}")
    public String disableAgency(@PathVariable("pId")Long id){
        agencyService.disableAgency(id);
        return "Agency disabled successfully";

    }

    //Merging method
    @PostMapping("/merge")
    public String mergeAgencies(@RequestBody List<Agency> agencyList){
        agencyService.mergeAgencies(agencyList);
        return "Agencies merged successfully";
    }
}

