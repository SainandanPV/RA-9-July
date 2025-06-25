package com.litmus7.studentservice;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

public class StudentPerformanceService{
	Map<String,Student> studentMap=new HashMap<>();
	private Map<String, Course> courseCatalog = new HashMap<>();
	
	public void loadCoursesFromFile(String filePath) {
		try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
			String line;
			while((line=br.readLine())!=null) {
				String[] parts=line.split(",");
				if(parts.length==2) {
					Course course=new Course(parts[0].trim(),parts[1].trim());
					courseCatalog.put(course.getCourseId(), course);
				}
			}
		}
		catch(IOException e) {
			System.out.println("Error reading course file:"+e.getMessage());
		}
	}
	
	public Map<String,Course> getCourseCatalog(){
		return courseCatalog;
	}
	
	public void addStudent(Student student) {
		studentMap.put(student.getStudentId(), student);
	}
	
	public void assignCourseToStudent(String studentId,String courseId, int marks) {
		Student student=studentMap.get(studentId);
		Course course=courseCatalog.get(courseId);
		if(student!=null && course!=null) {
			student.enrollInCourse(course, marks);
		}
		else {
			System.out.println("Invalid student ID or Couse ID");
		}
	}
	
	public void printStudentReport(String studentID) {
		Student student=studentMap.get(studentID);
		if(student==null) {
			System.out.println("Student not found");
		}
		
		System.out.println("Performance report for "+student.getName());
		Map<Course,Integer> marksMap=student.getCourseMarks();
		for(Map.Entry<Course,Integer> entry :marksMap.entrySet()) {
			System.out.println(entry.getKey()+"==> Marks : "+entry.getValue());
		}
	}
}