package com.course.course;

import com.course.course.entities.Course;
import com.course.course.entities.Lesson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouseApplication.class, args);
		System.out.println("CouseApplication started\n");

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.registerModule(new JavaTimeModule());

		try {
            File jsonFiile = new File("C:\\WorkSpace_estrutura_de_dados\\Leitura_de_arquivo\\couse\\src\\main\\resources\\file.json");
			List<Course> courses = objectMapper.readValue(jsonFiile, new TypeReference<List<Course>>() {});

			for (Course course : courses) {
				System.out.println("Course Id: " + course.getId());
				System.out.println("Course Title: " + course.getTitle());

				List<Lesson> lessons = course.getLessons();

				for (Lesson lesson : lessons) {
					System.out.println();
					System.out.println("    	id: " + lesson.getId());
					System.out.println("    	title: " + lesson.getTitle());
					System.out.println("    	media: " + lesson.getMedia());
					System.out.println("		timestamp: " + lesson.getTimestamp());
				}

				System.out.println();
			}
        }
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
