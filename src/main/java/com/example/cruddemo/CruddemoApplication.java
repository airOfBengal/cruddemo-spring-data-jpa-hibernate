package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
//			createInstructor(appDao);
//			findInstructor(appDao);

//			deleteInstructor(appDao);

//			findInstructorDetail(appDao);

			deleteInstructorDetail(appDao);
		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		long theId = 3;
		appDao.deleteInstructorDetailById(theId);
	}

	private void findInstructorDetail(AppDao appDao) {
		long theId = 1;

		System.out.println("Finding instructor detail with id " + theId);
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(theId);
		System.out.println(instructorDetail);
	}

	private void deleteInstructor(AppDao appDao) {
		long theID = 2;
		System.out.println("Deleting Instructor with ID " + theID);
		appDao.deleteById(theID);
	}

	private void findInstructor(AppDao appDao) {
		long theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor instructor = appDao.findById(theId);
		System.out.println("Found instructor: " + instructor);
		System.out.println("Associated instructor detail: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {
		Instructor instructor = new Instructor("Ripu", "Rony", "ripu@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("Source codes", "Coding");
		instructor.setInstructorDetail(instructorDetail);
		appDao.save(instructor);
	}

}
