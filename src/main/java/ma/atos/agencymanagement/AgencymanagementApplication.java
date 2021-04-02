package ma.atos.agencymanagement;

import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.AgencyRepository;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import ma.atos.agencymanagement.repository.ManagerRepository;
import ma.atos.agencymanagement.repository.RoleRepository;
import ma.atos.agencymanagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class AgencymanagementApplication implements CommandLineRunner {

	@Autowired
    private ManagerRepository managerRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ManagerService roleService;

	@Autowired
	private AgencyRepository agencyRepository;

	public static void main(String[] args) {

		SpringApplication.run(AgencymanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
 	for(int i = 0; i <10; i++){
		managerRepository.save(new Manager("i","name"+i,"prenom"+i, new Date()));
		roleRepository.save(new Role("role"+i,"code"+i));

	}
	Manager manager = managerRepository.findById(1L).get();
	List<Role> roles = roleRepository.findAll().subList(0,4);
	Iterator<Role> it = roles.iterator();
	while(it.hasNext()){
		Role role = it.next();
		roleService.assignRole(role.getId(),manager.getId());
	}
	Agency agency = new Agency();
	agencyRepository.save(agency);

	}
}
