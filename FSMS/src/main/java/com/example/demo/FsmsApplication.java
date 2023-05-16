package com.example.demo;


import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FsmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FsmsApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Philemon", "anaman", "ndefophil@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Aboagye", "Benjamin", "benjamin@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Evans", "Siaw", "evans@gmail.com");
//		studentRepository.save(student3);


	}
}
