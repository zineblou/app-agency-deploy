package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.service.ManagerService;
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
}
