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

    @GetMapping("/agencies")
    public List<Agency> getAllAgencies(){
        return agencyService.getAllAgencies();
    }


    @GetMapping("/agencies/{pId}")
    public Agency getAgency(@PathVariable("pId") Long id){
        return agencyService.getAgency(id).orElseThrow(()-> new AgencyNotFoundException(id));
    }

    @PostMapping("/agencies")
    public String addAgency(@RequestBody Agency agency){
        agencyService.addAgency(agency);
        return "The agency created successfully";
    }

    @PutMapping("/agencies")
    public String updateAgency(@RequestBody Agency agency){
        agencyService.updateAgency(agency);
        return "Agency updated successfully";
    }

    @DeleteMapping("/agencies/{pId}")
    public String deleteAgency(@PathVariable("pId") Long id){
        agencyService.deleteAgency(id);
        return "Agency deleted successfully";
    }

    @PutMapping("/disable/{pId}")
    public String disableAgency(@PathVariable("pId")Long id){
        agencyService.disableAgency(id);
        return "Agency disabled successfully";

    }

    @PostMapping("/merge")
    public String mergeAgencies(@RequestBody List<Agency> agencyList){
        agencyService.mergeAgencies(agencyList);
        return "Agencies merged successfully";
    }
}

