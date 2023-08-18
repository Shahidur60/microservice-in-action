package com.optimagrowth.license;

import com.optimagrowth.license.model.Person;
import com.optimagrowth.license.repositories.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LicenseServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(LicenseServiceApplication.class, args);

		PersonRepository personRepository =
				configurableApplicationContext.getBean(PersonRepository.class);

		Person person = new Person
				("Shaha", "cs","cs","11-11-1996","23455","shah@gmail.com");

		personRepository.save(person);
	}

}
