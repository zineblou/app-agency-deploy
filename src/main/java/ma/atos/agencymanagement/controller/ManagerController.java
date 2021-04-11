package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.converter.ManagerConverter;
import ma.atos.agencymanagement.dto.ManagerDTO;
import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerConverter managerConverter;

    //UPDATE MANAGER
    @PutMapping("/update")
    public String update(@RequestBody ManagerDTO managerDTO){
        managerConverter.FromManagerToManagerDto(managerService.updateManager(managerConverter.FromManagerDtoToManager(managerDTO)));
        return "Manager updated successfully";
    }

    //ADD a new manager
    @PostMapping("/addManager")
    public String addManager(ManagerDTO managerDTO){
        managerConverter.FromManagerToManagerDto(managerService.saveManager(managerConverter.FromManagerDtoToManager((managerDTO))));
        return "The manager created successfully";

    }

    //get the list of managers
    @GetMapping("/managers")
    public List<ManagerDTO> getManagers(){
        return managerConverter.FromListManagersToListManagersDto(managerService.getManagers());
    }

    //Delete managers by id
    @DeleteMapping("/delete/{id}")
    public void deleteManager(@PathVariable Long id){
        managerService.deleteManager(id);
    }

   //Assing a role to the manager
    @PutMapping("/assignRole")
    public Manager assignRole(@RequestParam("idRole") Long roleId, @RequestParam("idManager") Long idManager){
       return managerService.assignRole(roleId,idManager);
    }

    //Assign a manager
    @PutMapping("/assignManager")
    public Manager assignManager(@RequestParam("id1") Long id1, @RequestParam("id2") Long id2){
        return managerService.assignManager(id1,id2);
    }

    //Assign an agency
    @PutMapping("/assignAgency")
    public Manager assignAgency(@RequestParam("idManager") Long idManager, @RequestParam("idAgency") Long idAgency){
        return managerService.assignAgency(idManager,idAgency);
    }

}
