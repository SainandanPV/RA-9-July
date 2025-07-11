package com.litmus7.school.dto;
import java.util.Scanner;

/* Student class represents a student with name, 
 * roll number, and marks for 5 subjects.
 * Includes methods to input student data, calculate 
 * total, average, grade and print report card
*/

public class Student{
	private String name;
	private int rollNumber;
	private int[] marks=new int[5];
	/*
	 * Method that reads student name, roll number and marks for 5 subjects, from the user
	 */
	public void inputDetails() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Student name: ");
		name=scanner.nextLine();
		System.out.println("Enter roll number: ");
		rollNumber=scanner.nextInt();
		System.out.println("Enter marks for 5 subjects : ");
		for(int i=0;i<5;i++) {
			System.out.println("Subject"+(i+1)+" : ");
			marks[i]=scanner.nextInt();			
		}
	}
	/*
	 * Calculates the total marks of all 5 subjects
	 * @return total marks as an integer
	 */
	public int calculateTotal() {
		int total=0;
		for(int mark:marks) {
			total+=mark;
		}
		return total;
	}
	/*
	 * Calculates the average of marks of 5 subjects
	 * @return average marks as double
	 */
	public double calculateAverage() {
		return calculateTotal()/5.0;
	}
	
	/*declares an inner enum 
	 * categorize students based on average marks
	*/
	private enum Grade{
		A("Excellent"),
		B("Good"),
        C("Average"),
        D("Pass"),
        F("Fail");
		
		private final String description;
		//constructor for enum
		Grade(String description){
			this.description=description;
		}
		/*
		 * Retrieves the grade's description
		 * @return description as string
		 */
		public String getDescription() {
			return description;
		}
	}
	/*
	 * @return Grade enum (A to F)
	 */
	
	public Grade getGrade() {
		double avg=calculateAverage();
		if(avg>=90) return Grade.A;
		else if (avg>=75) {
			return Grade.B;
		}
		else if (avg>=60) {
			return Grade.C;
		}
		else if (avg>=50) {
			return Grade.D;
		}
		else {
			return Grade.F;
		}
	}
	/*
	 * Prints the consolidated report card including the grade description
	 */
	public void printReportCard() {
		Grade grade=getGrade();
		System.out.println("\n---Report Card---");
		System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + calculateTotal());
        System.out.printf("Average    : %.2f\n", calculateAverage());
        System.out.println("Grade      : " + grade + " (" + grade.getDescription() + ")");
	}
	
}
