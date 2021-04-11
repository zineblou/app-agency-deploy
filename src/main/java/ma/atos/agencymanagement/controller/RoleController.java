package ma.atos.agencymanagement.controller;

import ma.atos.agencymanagement.converter.RoleConverter;
import ma.atos.agencymanagement.dto.RoleDTO;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleConverter roleConverter;

    //Get the list of roles
    @GetMapping(value = "/listroles")
    public List<RoleDTO> getRoles() {
        return roleConverter.FromListRolesToListRolesDto(roleService.getRoles());
    }

    //Add a new role
    @PostMapping(value = "/addrole")
    public RoleDTO addRole(RoleDTO roleDTO) {

        return roleConverter.FromRoleToRoleDto(roleService.saveRole(roleConverter.FromRoleDtoToRole(roleDTO)));
    }

    //Update the roles
    @PutMapping(value = "/update")
    public RoleDTO updateRole(@RequestBody RoleDTO roleDTO) {
        return roleConverter.FromRoleToRoleDto(roleService.update(roleConverter.FromRoleDtoToRole(roleDTO)));
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
    public Role assignHabilitation(@RequestParam("roleId") Long roleId, @RequestParam("habilitationId") Long habilitationId) {
        return roleService.assignHabilitation(roleId, habilitationId);
    }

}




