package ma.atos.agencymanagement.controller;


import ma.atos.agencymanagement.converter.HabilitationConverter;
import ma.atos.agencymanagement.dto.HabilitationDTO;
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
    @Autowired
    private HabilitationConverter habilitationConverter;

    // add habilitation method
    @PostMapping("/addHabilitation")
    public HabilitationDTO addHabilitation(@RequestBody HabilitationDTO habilitationDTO) {
        return (HabilitationDTO) habilitationConverter.
                FromListHabilitionsToListHabilitationDto(habilitationService.saveHabilitation(habilitationConverter.
                        FromListHabilitationdDtoToListHabilitations((List<HabilitationDTO>) habilitationDTO)));
    }


    //add list of habilitation
    @GetMapping("/habilitations")
    public List<HabilitationDTO> getHabilitations() {
        return habilitationConverter.
                FromListHabilitionsToListHabilitationDto(habilitationService.getHabilitations());


    }


    // add habilitation method
    @PostMapping("/addHabilitations")
    public List<HabilitationDTO> addHabilitation(@RequestBody List<HabilitationDTO> habilitationsDTO) {
        return habilitationConverter
                .FromListHabilitionsToListHabilitationDto(habilitationService
                        .saveHabilitation(habilitationConverter.FromListHabilitationdDtoToListHabilitations(habilitationsDTO)));
    }


    // Get a single habilitation by id
    @GetMapping("/HabilitationById/{id}")
    public HabilitationDTO getHabilitationById(@PathVariable Long id) {
        return (HabilitationDTO) habilitationConverter.
                FromListHabilitionsToListHabilitationDto((List<Habilitation>) habilitationService
                        .getHabilitationById(id));
    }

    // Update habilitation method
    @PutMapping("/update")
    public HabilitationDTO updateHabilitation(@RequestBody HabilitationDTO habilitationDTO) {
        return (HabilitationDTO) habilitationConverter.
                FromListHabilitionsToListHabilitationDto(habilitationService.
                        saveHabilitation(habilitationConverter
                                .FromListHabilitationdDtoToListHabilitations((List<HabilitationDTO>) habilitationDTO)));
    }

    // Delete  habilitation method
    @DeleteMapping("/delete/{id}")
    public void deleteHabilitation(@PathVariable Long id) {
        habilitationService.deleteHabilitation(id);
    }


}

