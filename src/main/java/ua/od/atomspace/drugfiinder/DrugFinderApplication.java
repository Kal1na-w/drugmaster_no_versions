package ua.od.atomspace.drugfiinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.od.atomspace.drugfiinder.service.DrugPurposeService;

@SpringBootApplication
public class DrugFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugFinderApplication.class, args);
	}

}
