package ma.atos.agencymanagement.controller;


import io.swagger.annotations.*;
import ma.atos.agencymanagement.converter.HabilitationConverter;
import ma.atos.agencymanagement.dto.HabilitationDTO;
import ma.atos.agencymanagement.dto.RoleDTO;
import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.service.HabilitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("habilitation")
@Api(value = "Habilitation", tags ={"Habilitation"})
class HabilitationController {
    @Autowired
    private HabilitationService habilitationService;
    @Autowired
    private HabilitationConverter habilitationConverter;

    @ApiOperation(value = "Ajouter Habilitation", notes = "", nickname = "AjouterHabilitation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Habilitation ajoutée", response = HabilitationDTO.class),
    })

    // add habilitation method
    @PostMapping("/addHabilitation")
    public HabilitationDTO addHabilitation(@RequestBody HabilitationDTO habilitationDTO) {
        return (HabilitationDTO) habilitationConverter.
                FromListHabilitionsToListHabilitationDto(habilitationService.saveHabilitation(habilitationConverter.
                        FromListHabilitationdDtoToListHabilitations((List<HabilitationDTO>) habilitationDTO)));
    }

    @ApiOperation(value = "Retourner la liste des habilitations", notes = "", nickname = "findAll")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des habilitations trouvés", response = HabilitationDTO.class),
    })

    //add list of habilitation
    @GetMapping("/habilitations")
    public List<HabilitationDTO> getHabilitations() {
        return habilitationConverter.
                FromListHabilitionsToListHabilitationDto(habilitationService.getHabilitations());


    }

    @ApiOperation(value = "Ajouter la liste des habilitations", notes = "", nickname = "findAll")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Liste des habilitations ajoutés", response = HabilitationDTO.class),
    })

    // add habilitation method
    @PostMapping("/addHabilitations")
    public List<HabilitationDTO> addHabilitation(@RequestBody List<HabilitationDTO> habilitationsDTO) {
        return habilitationConverter
                .FromListHabilitionsToListHabilitationDto(habilitationService
                        .saveHabilitation(habilitationConverter.FromListHabilitationdDtoToListHabilitations(habilitationsDTO)));
    }

    @ApiOperation(value = "Retourner une habilitation par son id", notes = "", nickname = "findById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Habilitation trouvée", response = HabilitationDTO.class),
    })

    // Get a single habilitation by id
    @GetMapping("/HabilitationById/{id}")
    public HabilitationDTO getHabilitationById(@ApiParam(value = "Habilitation à trouver", required = true)@PathVariable Long id) {
        return (HabilitationDTO) habilitationConverter.
                FromListHabilitionsToListHabilitationDto((List<Habilitation>) habilitationService
                        .getHabilitationById(id));
    }

    @ApiOperation(value = "Modifier une habilitation", notes = "", nickname = "modifierHabilitation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Habilitation modifiée", response = HabilitationDTO.class),
    })

    // Update habilitation method
    @PutMapping("/update")
    public HabilitationDTO updateHabilitation(@RequestBody HabilitationDTO habilitationDTO) {
        return (HabilitationDTO) habilitationConverter.
                FromListHabilitionsToListHabilitationDto(habilitationService.
                        saveHabilitation(habilitationConverter
                                .FromListHabilitationdDtoToListHabilitations((List<HabilitationDTO>) habilitationDTO)));
    }

    @ApiOperation(value = "Supprimer une Habilitation", notes = "", nickname = "DeleteHabilitationById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Role supprimer", response = HabilitationDTO.class),
    })

    // Delete  habilitation method
    @DeleteMapping("/delete/{id}")
    public void deleteHabilitation(@ApiParam(value = "Habilitation à supprimer", required = true)@PathVariable Long id) {
        habilitationService.deleteHabilitation(id);
    }


}

