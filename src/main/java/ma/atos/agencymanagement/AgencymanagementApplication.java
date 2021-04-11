package ma.atos.agencymanagement;


import ma.atos.agencymanagement.model.Agency;
import ma.atos.agencymanagement.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Date;

@EnableDiscoveryClient
@SpringBootApplication



public class AgencymanagementApplication implements CommandLineRunner {

	@Autowired
	private AgencyRepository agencyRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgencymanagementApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception{
		agencyRepository.save(new Agency(1L,"bank1","1","321z21",new Date()));
		agencyRepository.save(new Agency(2L,"bank2","2","321z22",new Date()));
		agencyRepository.save(new Agency(3L,"bank3","3","321z23",new Date()));
		agencyRepository.save(new Agency(4L,"bank4","4","321z24",new Date()));
	}
}
