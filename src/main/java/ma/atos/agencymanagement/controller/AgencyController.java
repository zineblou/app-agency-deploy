package ma.atos.agencymanagement.controller;

import io.swagger.annotations.*;
import ma.atos.agencymanagement.converter.AgencyConverter;
import ma.atos.agencymanagement.dto.AgencyDTO;
import ma.atos.agencymanagement.exception.AgencyNotFoundException;
import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Agency", tags = {"Agency"})
public class AgencyController {

    @Autowired
    private AgencyService agencyService;
    @Autowired
    private AgencyConverter agencyConverter;

    @ApiOperation(value = "Retourner la liste des Agences", notes = "", nickname = "findAll")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des agences trouvées", response = AgencyDTO.class),
    })

    // add List of agencies
    @GetMapping("/agencies")
    public List<AgencyDTO> getAllAgencies() {


        return agencyConverter.fromListAgencysToListAgencysDto(agencyService.getAllAgencies());

    }

    @ApiOperation(value = "Retourner une Agence par son id", notes = "", nickname = "findById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Agence trouvée", response = AgencyDTO.class),
    })

// Get Agencies By Id
    @GetMapping("/agencies/{pId}")
    public AgencyDTO getAgencyDTO(@ApiParam(value = "Agence à trouver", required = true) @PathVariable("pId") Long id) {

        return agencyConverter.fromAgencyToAgencyDto(agencyService.getAgency(id).orElseThrow(()-> new AgencyNotFoundException(id)));

    }

    @ApiOperation(value = "Ajouter une Agence", notes = "", nickname = "AjouterAgence")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Agence ajoutée", response = AgencyDTO.class),
    })

    @PostMapping("/agencies")
    public String addAgency(@ApiParam(value = "Agence à ajouter", required = true)
                            @Valid @RequestBody AgencyDTO agencyDTO) {
        agencyConverter.fromAgencyToAgencyDto(agencyService.addAgency(agencyConverter.fromAgencyDtoToAgency(agencyDTO)));
        return "The agency created successfully";
    }

    @ApiOperation(value = "Modifier une Agence", notes = "", nickname = "ModifierAgence")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Agence modifiée", response = AgencyDTO.class),
    })

    //Update agencies
    @PutMapping("/agencies")
    public String updateAgency(@ApiParam(value = "Agence à modifier", required = true)
                               @Valid @RequestBody AgencyDTO agencyDTO) {
        agencyConverter.fromAgencyToAgencyDto(agencyService.updateAgency(agencyConverter.fromAgencyDtoToAgency(agencyDTO)));
        return "Agency updated successfully";
    }

    @ApiOperation(value = "Supprimer une Agence", notes = "", nickname = "DeleteAgenceById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Agence supprimer", response = AgencyDTO.class),
    })

    //Delete agencies by id
    @DeleteMapping("/agencies/{pId}")
    public String deleteAgency(@ApiParam(value = "Agence à supprimer", required = true) @PathVariable("pId") Long id) {
        agencyService.deleteAgency(id);
        return "Agency deleted successfully";
    }

    @ApiOperation(value = "désactiver une Agence", notes = "", nickname = "DisableAgenceById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Agence désactiver", response = AgencyDTO.class),
    })

    //Disable agency
    @PutMapping("/disable/{pId}")
    public String disableAgency(@ApiParam(value = "Agence à désactiver", required = true) @PathVariable("pId") Long id) {
        agencyService.disableAgency(id);
        return "Agency disabled successfully";

    }

    @ApiOperation(value = "Fusionner les agences", notes = "", nickname = "mergeAgencies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "les Agences sont fusionnés", response = AgencyDTO.class),
    })
    //Merging method
    @PostMapping("/merge")
    public String mergeAgencies(@RequestBody List<Agency> agencyList) {
        agencyService.mergeAgencies(agencyList);
        return "Agencies merged successfully";
    }
}

