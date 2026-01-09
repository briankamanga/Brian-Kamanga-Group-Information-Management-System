package com.briankamangagroup.briankamangagroup_information_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.briankamangagroup.briankamangagroup_information_management_system.entity")
@EnableJpaRepositories(basePackages = "com.briankamangagroup.briankamangagroup_information_management_system.repository")
public class BriankamangagroupInformationManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriankamangagroupInformationManagementSystemBackendApplication.class, args);
	}

}
