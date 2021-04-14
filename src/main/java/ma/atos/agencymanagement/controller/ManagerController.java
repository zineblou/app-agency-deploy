package ma.atos.agencymanagement.controller;

import io.swagger.annotations.*;
import ma.atos.agencymanagement.converter.ManagerConverter;
import ma.atos.agencymanagement.dto.ManagerDTO;
import ma.atos.agencymanagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
@Api(value = "Manager", tags ={"Manager"})
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerConverter managerConverter;

    @ApiOperation(value = "Modifier Manager", notes = "", nickname = "ModifierManager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Manager modifiée", response = ManagerDTO.class),
    })
    //UPDATE MANAGER
    @PutMapping("/update")
    public String update(@RequestBody ManagerDTO managerDTO){
        managerConverter.fromManagerToManagerDto(managerService.updateManager(managerConverter.fromManagerDtoToManager(managerDTO)));
        return "Manager updated successfully";
    }

    @ApiOperation(value = "Ajouter Manager", notes = "", nickname = "AjouterManager")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Manager ajoutée", response = ManagerDTO.class),
    })
    //ADD a new manager
    @PostMapping("/addManager")
    public String addManager(ManagerDTO managerDTO){
        managerConverter.fromManagerToManagerDto(managerService.saveManager(managerConverter.fromManagerDtoToManager(managerDTO)));
        return "The manager created successfully";

    }

    @ApiOperation(value = "Retourner la liste des Managers", notes = "", nickname = "findAll")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des managers trouvés", response = ManagerDTO.class),
    })
    //get the list of managers
    @GetMapping("/managers")
    public List<ManagerDTO> getManagers(){
        return managerConverter.fromListManagersToListManagersDto(managerService.getManagers());
    }

    @ApiOperation(value = "supprimer Manager", notes = "", nickname = "supprimerManager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Manager supprimée", response = ManagerDTO.class),
    })
    //Delete managers by id
    @DeleteMapping("/delete/{id}")
    public void deleteManager(@ApiParam(value = "Manager à supprimer", required = true)@PathVariable Long id){
        managerService.deleteManager(id);
    }

    @ApiOperation(value = "Assigner un Role à un Manager", notes = "", nickname = "assignRoleToManager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Role assignée", response = ManagerDTO.class),
    })
   //Assing a role to the manager
    @PutMapping("/assignRole")
    public String assignRole(@ApiParam(value = "Role à assigner", required = true)@RequestParam("idRole") Long roleId, @ApiParam(value = "Manager à assigner", required = true)@RequestParam("idManager") Long idManager){
       return managerService.assignRole(roleId,idManager);
    }

    @ApiOperation(value = "Assigner un Manager à un Gestionnaire", notes = "", nickname = "assignManager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Manager assignée", response = ManagerDTO.class),
    })
    //Assign a manager
    @PutMapping("/assignManager")
    public String assignManager(@ApiParam(value = "Manager à assigner", required = true)@RequestParam("id1") Long id1, @ApiParam(value = "Gestionnaire", required = true)@RequestParam("id2") Long id2){
        return managerService.assignManager(id1,id2);
    }

    @ApiOperation(value = "Assigner un Manager à une Agence", notes = "", nickname = "assignManagerToAgency")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Manager assignée à l'agence", response = ManagerDTO.class),
    })
    //Assign an agency
    @PutMapping("/assignAgency")
    public String assignAgency(@ApiParam(value = "Manager à assigner", required = true)@RequestParam("idManager") Long idManager, @ApiParam(value = "Agence", required = true)@RequestParam("idAgency") Long idAgency){
        return managerService.assignAgency(idManager,idAgency);
    }

}
