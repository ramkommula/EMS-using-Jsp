package net.javaguides.ems;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EmployeeManagementsystmApplication {

	 
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementsystmApplication.class, args);
	}
	
}
