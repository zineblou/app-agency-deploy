package ma.atos.agencymanagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication



public class AgencymanagementApplication {



	public static void main(String[] args) {
		SpringApplication.run(AgencymanagementApplication.class, args);
	}


}
