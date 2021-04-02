package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import ma.atos.agencymanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//    public Role finByRole (Role role){return roleRepository.findById}

    public Role saveRole(Role role) {
        Role savedRole = roleRepository.save(role);
        return savedRole;

    }
    public void deletRole(Long id) {
        roleRepository.deleteById(id);
    }
    public Role assignHabilitation(Long roleId, Long habilitationId){
       Role role = roleRepository.findById(roleId).get();
        Habilitation habilitation = repository.findById(habilitationId).get();
        role.getHabilitation().add(habilitation);
        return roleRepository.save(role);
    }


}
