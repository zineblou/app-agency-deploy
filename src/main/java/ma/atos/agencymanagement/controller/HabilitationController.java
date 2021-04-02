package ma.atos.agencymanagement.controller;

import lombok.AllArgsConstructor;
import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.service.HabilitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("habilitaion")

class HabilitationController {
    @Autowired
    private HabilitationService service;

    // add habilitation method
     @PostMapping("/addHabilitation")
    public Habilitation addHabilitation(@RequestBody Habilitation habilitation) {
        return service.saveHabilitation(habilitation);
    }

    // add habilitation method
    @PostMapping("/addHabilitations")
    public List<Habilitation> addHabilitation(@RequestBody List<Habilitation> habilitations) {
        return service.saveHabilitation(habilitations);
    }


    // Get  a list of all  habilitations
    @GetMapping("/habilitations")
    public List<Habilitation> findAllHabilitation() {
        return service.getHabilitation();
    }

    // Get a single habilitation by id
    @GetMapping("/HabilitationById/{id}")
    public Habilitation findHabilitationById(@PathVariable Long id) {
        return service.getHabilitationById(id);

    }

    // Update habilitation method
    @PutMapping("/updateHabilitaion")
    public Habilitation updateHabilitation(@RequestBody Habilitation habilitation) {
        return service.updateHabilitation(habilitation);
    }

    // Update habilitation method
    @DeleteMapping("/deleteHabilitation/{id}")
    public void deleteHabilitation(@PathVariable Long id) {
         service.deleteHabilitation(id);
    }



}

