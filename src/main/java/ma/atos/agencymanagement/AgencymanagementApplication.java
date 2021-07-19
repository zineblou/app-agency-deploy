package ma.atos.agencymanagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@EnableDiscoveryClient
@SpringBootApplication



public class AgencymanagementApplication {



	public static void main(String[] args) {
		SpringApplication.run(AgencymanagementApplication.class, args);


}}
