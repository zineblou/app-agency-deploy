package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/listroles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping(value = "/addrole")
    public Role addRole(Role role) {
        return roleService.saveRole(role);
    }

    @PutMapping(value = "/update")
    public Role updateRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping(value = "/role/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getById(id);
    }





    @DeleteMapping(value = "/deleteRole/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deletRole(id);
    }
    @PutMapping("/assignHabilition")
    public Role assignHabilitation(@RequestParam("roleId") Long roleId, @RequestParam("habilitationId") Long habilitationId){
        return roleService.assignHabilitation(roleId,habilitationId);
    }

}




