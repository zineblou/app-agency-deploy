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

    //Get the list of roles
    @GetMapping(value = "/listroles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    //Add a new role
    @PostMapping(value = "/addrole")
    public Role addRole(Role role) {
        return roleService.saveRole(role);
    }

    //Update the roles
    @PutMapping(value = "/update")
    public Role updateRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    //Get the manager by id
    @GetMapping(value = "/role/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    //Delete Role
    @DeleteMapping(value = "/deleteRole/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deletRole(id);
    }

    //Asign Habilitation to the role
    @PutMapping("/assignHabilition")
    public Role assignHabilitation(@RequestParam("roleId") Long roleId, @RequestParam("habilitationId") Long habilitationId){
        return roleService.assignHabilitation(roleId,habilitationId);
    }

}




