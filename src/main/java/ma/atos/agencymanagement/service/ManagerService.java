package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

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
    return  managerRepository.save(existingManager);
    }
}
