package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import ma.atos.agencymanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private HabilitationRepository repository;

    public Role getById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }



    public Role saveRole(Role role) {
        return roleRepository.save(role);

    }

    public void deletRole(Long id) {
        roleRepository.deleteById(id);
    }

    public String assignHabilitation(Long roleId, Long habilitationId) {
        Role role = roleRepository.findById(roleId).orElse(null);
        Habilitation habilitation = repository.findById(habilitationId).orElse(null);
        if(role!=null && habilitation !=null) {

                role.getHabilitation().add(habilitation);
                roleRepository.save(role);
                return "assigne HABILITATION success";
            }
        return "assigne HABILITATION error";
    }

    public Role update(Role role) {

        Role existingRole = roleRepository.findById(role.getId()).orElse(null);
            if(existingRole == null){
                existingRole = roleRepository.save(role);
            }
            existingRole.setName(role.getName());
            existingRole.setCode(role.getCode());
            existingRole.setId(role.getId());

        return roleRepository.save(existingRole);
    }


}
