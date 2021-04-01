package ma.atos.agencymanagement;

import ma.atos.agencymanagement.model.Role;
import ma.atos.agencymanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgencymanagementApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(AgencymanagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role(null, "Modification", "ZE1245"));
        roleRepository.save(new Role(null, "Saisir", "KL1237"));
        roleRepository.save(new Role(null, "Modification", "MO1234"));
        roleRepository.save(new Role(null, "Modification", "ALIKJ"));


    }

}
