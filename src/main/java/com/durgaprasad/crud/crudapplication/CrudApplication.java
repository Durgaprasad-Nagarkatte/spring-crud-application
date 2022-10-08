package com.durgaprasad.crud.crudapplication;

import com.durgaprasad.crud.crudapplication.entity.Person;
import com.durgaprasad.crud.crudapplication.jdbc.PersonJdbcDao;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(CrudApplication.class);

	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", personJdbcDao.findAll());
		logger.info("User id 10001 -> {}", personJdbcDao.findById(10001));
		personJdbcDao.insert(new Person(10005, "Hannah", "Hamburg", new Date()));
		//logger.info("Delete person with id 10002  -> {}", personJdbcDao.deleteById(10002));
		logger.info("User by name -> {}", personJdbcDao.findByName("Akshatha"));

	}
}
