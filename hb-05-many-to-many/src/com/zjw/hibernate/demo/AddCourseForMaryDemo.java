package com.zjw.hibernate.demo;

import com.zjw.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseForMaryDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			//begin the transaction
			session.beginTransaction();

			//get student Jianwei from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Courses: "+ tempStudent.getCourses());


			Course tempCourse1 = new Course("Ruibik`s Cube : How to Speed Cube");
			Course tempCourse2 = new Course("Game Development");

			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			session.save(tempCourse1);
			session.save(tempCourse2);


			session.getTransaction().commit();
			System.out.println("Done!");

			
		}finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}