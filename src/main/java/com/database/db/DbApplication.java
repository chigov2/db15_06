package com.database.db;

import com.database.db.entity.Person;
import com.database.db.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DbApplication  implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users - > {}",dao.findAll());
		logger.info("Users id 817 - > {}",dao.finById(817));
		logger.info("Users name  - > {}",dao.finByName("Max"));
		//logger.info("Delete user 1001 Number of rows deleted - > {}",dao.deleteById(1001));
		logger.info("Inserting user id 10004 -> {}",
				dao.insert(new Person(10004,"Lena","Berlin",new Date())));
		logger.info("updating person id 1001 - {}",
				dao.update(new Person(1001,"Lenchik","Seattle",new Date())));
	}
}
