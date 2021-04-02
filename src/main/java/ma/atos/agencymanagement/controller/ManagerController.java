package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.service.ManagerService;
import ma.atos.agencymanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/addManager")
    public Manager addManager(Manager manager){
        return managerService.saveManager(manager);
    }

    @GetMapping("/managers")
    public List<Manager> getManagers(){
        return managerService.getManagers();
    }

    @GetMapping("/manager/{id}")
    public Manager getManagerById(@PathVariable Long id){
        return managerService.getManagerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManager(@PathVariable Long id){
        managerService.deleteManager(id);
    }

    @PostMapping("/update")
    public Manager updateManager(@RequestBody Manager manager){
        return managerService.updateManager(manager);
    }

    @PutMapping("/assignRole")
    public Manager assignRole(@RequestParam("idRole") Long roleId, @RequestParam("idManager") Long idManager){
       return managerService.assignRole(roleId,idManager);
    }
    @PutMapping("/assignManager")
    public Manager assignManager(@RequestParam("id1") Long id1, @RequestParam("id2") Long id2){
        return managerService.assignManager(id1,id2);
    }
    @PutMapping("/assignAgency")
    public Manager assignAgency(@RequestParam("idManager") Long idManager, @RequestParam("idAgency") Long idAgency){
        return managerService.assignAgency(idManager,idAgency);
    }
}
