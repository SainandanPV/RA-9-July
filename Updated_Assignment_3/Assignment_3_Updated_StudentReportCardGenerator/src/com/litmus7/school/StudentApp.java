package com.litmus7.school;
import java.util.Scanner;
import com.litmus7.school.dto.Student;

/*
 * StudentApp class serves as the entry point for Report Card Generation
 * Reads input from the user, collect student details, calculates grade, generates the report card
 */

public class StudentApp{
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter number of Students: ");
		int numberOfStudents=scanner.nextInt();
		scanner.nextLine();
		
		Student[] students=new Student[numberOfStudents];
		/*
		 * Reads the student details one by one
		 */
		for(int i=0;i<numberOfStudents;i++) {
			System.out.println("\nEnter details for Student "+(i+1)+" : ");
			students[i]=new Student();
			students[i].inputDetails();
		}
		/*
		 * Prints report card for all students
		 */
		for(Student student:students) {
			student.printReportCard();
		}
		scanner.close(); //Close the scanner
	}
}