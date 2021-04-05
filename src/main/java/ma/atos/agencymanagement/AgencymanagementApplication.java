package ma.atos.agencymanagement;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.model.Manager;
import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.AgencyRepository;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import ma.atos.agencymanagement.repository.ManagerRepository;
import ma.atos.agencymanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class AgencymanagementApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	AgencyRepository agencyRepository;
	@Autowired
	HabilitationRepository habilitationRepository;
	@Autowired
	ManagerRepository managerRepository;

	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(AgencymanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i = 0; i <10; i++){
			managerRepository.save(new Manager("i","name"+i,"prenom"+i, new Date()));
			habilitationRepository.save(new Habilitation("name"+i,"code" ,new Date(),new Date()));

		}


	}

}