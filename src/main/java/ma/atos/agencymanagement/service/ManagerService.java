package ma.atos.agencymanagement.service;

import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.AgencyRepository;
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

    @Autowired
    private AgencyRepository<Agency> agencyRepository;

    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public List<Manager> getManagers() {
        return managerRepository.findAll();
    }

    public Manager getManagerById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }

    public Manager updateManager(Manager manager) {
        Manager existingManager = managerRepository.findById(manager.getId()).orElse(null);
        assert existingManager != null;
        existingManager.setFirstName(manager.getFirstName());
        existingManager.setLastName(manager.getLastName());
        existingManager.setRegistrationNumber(manager.getRegistrationNumber());
        existingManager.setIntegrationDate(manager.getIntegrationDate());
        existingManager.setModificationDate(new Date());
        return managerRepository.save(existingManager);

    }

    public String assignRole(Long roleId, Long idManager) {
        Manager manager = managerRepository.findById(idManager).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);
        if(manager!=null && role!=null) {
            manager.getRoles().add(role);
            managerRepository.save(manager);
            return "assigne role success";
        }
        return "assigne role error";

    }

    public String assignManager(Long manager1, Long manager2) {
        Manager assigned = managerRepository.findById(manager1).orElse(null);
        Manager toAssign = managerRepository.findById(manager2).orElse(null);
        if(assigned!=null && toAssign!=null) {
            assigned.setManagerSup(toAssign);
            managerRepository.save(assigned);
            return "assigne manager success";
        }
        return "assigne manager error";

    }

    public String assignAgency(Long managerId, Long agencyId) {
        Manager manager = managerRepository.findById(managerId).orElse(null);
        Agency agency =  agencyRepository.findById(agencyId).orElse(null);
        if(manager!=null && agency!=null) {
            manager.setAgency(agency);
            return "assigne agency success";
        }
        return "assigne agency error";
    }
}
