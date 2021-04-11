package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.service.ManagerService;
import ma.atos.agencymanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    //UPDATE MANAGER
    @PutMapping("/update")
    public String update(@RequestBody Manager manager){
        System.out.println("Manager to modify "+manager.getFirstName());
        managerService.updateManager(manager);
        return "Manager updated successfully";
    }

    //ADD a new manager
    @PostMapping("/addManager")
    public String addManager(Manager manager){
        managerService.saveManager(manager);
        return "The manager created successfully";

    }

    //get the list of managers
    @GetMapping("/managers")
    public List<Manager> getManagers(){
        return managerService.getManagers();
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
