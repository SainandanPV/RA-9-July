package com.litmus7.school;
import com.litmus7.school.dto.Student;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        Student[] students = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            students[i] = new Student();
            students[i].inputDetails();
        }
        for (int i = 0; i < numberOfStudents; i++) {
            students[i].printReportCard();
        }
    }
}
