package ma.atos.agencymanagement;

import ma.atos.agencymanagement.model.Habilitation;
import ma.atos.agencymanagement.repository.HabilitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgencymanagementApplication implements CommandLineRunner {

	@Autowired
    private HabilitationRepository habilitationRepository;

	public static void main(String[] args) {

		SpringApplication.run(AgencymanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
