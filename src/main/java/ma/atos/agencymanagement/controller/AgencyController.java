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
    public void addAgency(@RequestBody Agency agency){
        agencyService.addAgency(agency);
    }

    @PutMapping("/agencies/{pId}")
    public void updateAgency(@RequestBody Agency agency, @PathVariable("pId") Long id){
        agencyService.updateAgency(id,agency);
    }

    @DeleteMapping("/agencies/{pId}")
    public void deleteAgency(@PathVariable("pId") Long id){
        agencyService.deleteAgency(id);
    }
}