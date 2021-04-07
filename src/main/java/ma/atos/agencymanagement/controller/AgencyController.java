package ma.atos.agencymanagement.controller;
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

    // add List of agencies
    @GetMapping("/agencies")
    public List<Agency> getAllAgencies(){
        return agencyService.getAllAgencies();
    }

    //Ad agencies by id
    @GetMapping("/agencies/{pId}")
    public Agency getAgency(@PathVariable("pId") Long id){
        return agencyService.getAgency(id).orElseThrow(()-> new AgencyNotFoundException(id));
    }

    //Create new agencies
    @PostMapping("/agencies")
    public String addAgency(@RequestBody Agency agency){
        agencyService.addAgency(agency);
        return "The agency created successfully";
    }

    //Update agencies
    @PutMapping("/agencies")
    public String updateAgency(@RequestBody Agency agency){
        agencyService.updateAgency(agency);
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

