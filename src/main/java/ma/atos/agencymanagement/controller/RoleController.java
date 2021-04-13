package ma.atos.agencymanagement.controller;

import io.swagger.annotations.*;
import ma.atos.agencymanagement.converter.RoleConverter;
import ma.atos.agencymanagement.dto.RoleDTO;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "Role", tags ={"Role"})
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleConverter roleConverter;

    @ApiOperation(value = "Retourner la liste des Roles", notes = "", nickname = "findAll")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des roles trouvés", response = RoleDTO.class),
    })

    //Get the list of roles
    @GetMapping(value = "/listroles")
    public List<RoleDTO> getRoles() {
        return roleConverter.FromListRolesToListRolesDto(roleService.getRoles());
    }

    @ApiOperation(value = "Ajouter un Role", notes = "", nickname = "AjouterRole")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Role ajoutée", response = RoleDTO.class),
    })

    //Add a new role
    @PostMapping(value = "/addrole")
    public RoleDTO addRole(RoleDTO roleDTO) {

        return roleConverter.FromRoleToRoleDto(roleService.saveRole(roleConverter.FromRoleDtoToRole(roleDTO)));
    }

    @ApiOperation(value = "Modifier un Role", notes = "", nickname = "modifierRole")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Role modifiée", response = RoleDTO.class),
    })

    //Update the roles
    @PutMapping(value = "/update")
    public RoleDTO updateRole(@RequestBody RoleDTO roleDTO) {
        return roleConverter.FromRoleToRoleDto(roleService.update(roleConverter.FromRoleDtoToRole(roleDTO)));
    }

    @ApiOperation(value = "Retourner un Role par son id", notes = "", nickname = "findById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Role trouvée", response = RoleDTO.class),
    })

    //Get the manager by id
    @GetMapping(value = "/role/{id}")
    public Role getRoleById(@ApiParam(value = "Role à trouver", required = true)@PathVariable Long id) {
        return roleService.getById(id);
    }

    @ApiOperation(value = "Supprimer un Role", notes = "", nickname = "DeleteRoleById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Role supprimer", response = RoleDTO.class),
    })

    //Delete Role
    @DeleteMapping(value = "/deleteRole/{id}")
    public void deleteRole(@ApiParam(value = "Role à supprimer", required = true)@PathVariable Long id) {
        roleService.deletRole(id);
    }

    @ApiOperation(value = "assigner un Role", notes = "", nickname = "AssignRoleToHabilitation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Role assigner", response = RoleDTO.class),
    })
    //Asign Habilitation to the role
    @PutMapping("/assignHabilition")
    public Role assignHabilitation(@ApiParam(value = "Role Id", required = true)@RequestParam("roleId") Long roleId, @ApiParam(value = "Habilitation Id", required = true)@RequestParam("habilitationId") Long habilitationId) {
        return roleService.assignHabilitation(roleId, habilitationId);
    }

}




