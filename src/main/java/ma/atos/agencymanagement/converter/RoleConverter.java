package ma.atos.agencymanagement.converter;

import ma.atos.agencymanagement.dto.RoleDTO;
import ma.atos.agencymanagement.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class RoleConverter {

    //From role to role dto
    public RoleDTO FromRoleToRoleDto(Role role){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(role, RoleDTO.class);
    }

    //From role dto to role entity
    public Role FromRoleDtoToRole(RoleDTO roleDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(roleDTO, Role.class);
    }

    //From role list to role dto list
    public List<RoleDTO> FromListRolesToListRolesDto(List<Role> roles){
        ModelMapper mapper =new ModelMapper();
        return roles.stream().map(this::FromRoleToRoleDto).collect(Collectors.toList());
    }

    //From role list dto to role list
    public List<Role> FromListRolesDtoToListRoles(List<RoleDTO> rolesDto){
        ModelMapper mapper =new ModelMapper();
        return rolesDto.stream().map(this::FromRoleDtoToRole).collect(Collectors.toList());

    }
}
