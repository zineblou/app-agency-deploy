package ma.atos.agencymanagement.controller;


import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.service.HabilitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("habilitation")
class HabilitationController {
    @Autowired
    private HabilitationService habilitationService;

    // add habilitation method
     @PostMapping("/addHabilitation")
    public Habilitation addHabilitation(@RequestBody Habilitation habilitation) {
        return habilitationService.saveHabilitation(habilitation);
    }

    @GetMapping("/habilitations")
    public List<Habilitation> getHabilitations() {
        return habilitationService.getHabilitations();
    }

    // add habilitation method
    @PostMapping("/addHabilitations")
    public List<Habilitation> addHabilitation(@RequestBody List<Habilitation> habilitations) {
        return habilitationService.saveHabilitation(habilitations);
    }




    // Get a single habilitation by id
    @GetMapping("/HabilitationById/{id}")
    public Habilitation getHabilitationById(@PathVariable Long id) {
        return habilitationService.getHabilitationById(id);

    }

    // Update habilitation method
    @PutMapping("/update")
    public Habilitation updateHabilitation(@RequestBody Habilitation habilitation) {
        return habilitationService.updateHabilitation(habilitation);
    }

    // Update habilitation method
    @DeleteMapping("/delete/{id}")
    public void deleteHabilitation(@PathVariable Long id) {
        habilitationService.deleteHabilitation(id);
    }



}

