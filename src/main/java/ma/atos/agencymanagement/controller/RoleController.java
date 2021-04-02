package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/add")
    public Role addRole(Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping(value = "/listroles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping(value = "/role/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PutMapping(value = "/update")
    public Role updateRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @PutMapping(value = "/listroles/{id}")
    public Role update(@PathVariable(name = "id") Long id, @RequestBody Role role) {
        role.setId(id);
        return roleService.saveRole(role);
    }

    @DeleteMapping(value = "/deleteRole/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deletRole(id);
    }
}




