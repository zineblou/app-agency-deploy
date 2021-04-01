package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    public Role getById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role saveRole(Role role) {
        Role savedRole = roleRepository.save(role);
        return savedRole;

    }

    public void deletRole(Long id) {
        roleRepository.deleteById(id);
    }

}
