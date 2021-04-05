package ma.atos.agencymanagement.controller;

import lombok.AllArgsConstructor;
import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.service.HabilitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("habilitation")
class HabilitationController {
    @Autowired
    private HabilitationService service;

     @PostMapping("/addHabilitation")
    public Habilitation addHabilitation(@RequestBody Habilitation habilitation) {
        return service.saveHabilitation(habilitation);
    }

    @PostMapping("/addHabilitations")
    public List<Habilitation> addHabilitation(@RequestBody List<Habilitation> habilitations) {
        return service.saveHabilitation(habilitations);
    }

    @GetMapping("/habilitations")
    public List<Habilitation> findAllHabilitation() {
        return service.getHabilitation();
    }

    @GetMapping("/HabilitationById/{id}")
    public Habilitation findHabilitationById(@PathVariable long id) {
        return service.getHabilitationById(id);

    }

    @PutMapping("/updateHabilitaion")
    public Habilitation updateHabilitation(@RequestBody Habilitation habilitation) {
        return service.updateHabilitation(habilitation);
    }

    @DeleteMapping("/deleteHabilitation/{id}")
    public void deleteHabilitation(@PathVariable Long id) {
         service.deleteHabilitation(id);
    }
}

