package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.ManagerRepository;
import ma.atos.agencymanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Manager saveManager(Manager manager){
        return managerRepository.save(manager);
    }

    public List<Manager> getManagers(){
        return managerRepository.findAll();
    }

    public Manager getManagerById(Long id){
    return managerRepository.findById(id).orElse(null);
    }

    public void deleteManager(Long id){
        managerRepository.deleteById(id);
    }

    public Manager updateManager(Manager manager){
    Manager existingManager = managerRepository.findById(manager.getId()).orElse(null);
    assert existingManager != null;
    existingManager.setFirstName(manager.getFirstName());
    existingManager.setLastName(manager.getLastName());
    existingManager.setRegistrationNumber(manager.getRegistrationNumber());
    existingManager.setIntegrationDate(manager.getIntegrationDate());
    existingManager.setModificationDate(new Date());
    return  managerRepository.save(existingManager);
    }

    public Manager assignRole(Long roleId, Long managerId){
       Manager manager = managerRepository.findById(managerId).get();
       Role role = roleRepository.findById(roleId).get();
       manager.getRoles().add(role);
       return managerRepository.save(manager);
    }
}
