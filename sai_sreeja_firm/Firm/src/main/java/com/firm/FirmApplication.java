package com.stock;


import java.text.SimpleDateFormat;


import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


import com.firm.dao.FirmDAO;

import com.firm.model.Firm;


@Configuration

@EnableAutoConfiguration

@SpringBootApplication
public
 class FirmApplication {

	
public static void main(String[] args) {
	
	SpringApplication.run(FirmApplication.class, args);
	
}

	
@Bean
	
CommandLineRunner initDatabase(final FirmDAO repository) {

	
	final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	return args -> {
		
	        repository.save(new Firm(1, "IBM", 10000, 50000, format.parse("2000-01-01")));
	
		repository.save(new Firm(2, "Infosys", 12000,80000, format.parse("1995-02-01")));
	
		repository.save(new Firm(3, "Technovert", 8000, 200, format.parse("2010-04-01")));
	
		repository.save(new Firm(4, "Cognizant", 19000, 100000, format.parse("1998-04-01")));
	
		repository.save(new Firm(5, "TCS", 14000, 200000, format.parse("1972-04-01")));
	
                repository.save(new Firm(6, "BYN", 48000, 12000, format.parse("2007-09-01")));
		repository.save(new Firm(7, "Wipro", 18000, 100000, format.parse("1997-01-01")));

                repository.save(new Firm(8, "Epam", 28000, 1000, format.parse("2011-07-02")));
		};
	
}

}
