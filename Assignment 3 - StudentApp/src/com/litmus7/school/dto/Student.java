package com.litmus7.school.dto;
import java.util.Scanner;

public class Student {
    private String name;
    private int rollNumber;
    private int[] marks = new int[5];
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        rollNumber = scanner.nextInt();

        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }
    public int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }
    public double calculateAverage() {
        return calculateTotal() / 5.0;
    }
    public char getGrade() {
        double average = calculateAverage();
        if (average >= 90) return 'A';
        else if (average >= 75) return 'B';
        else if (average >= 60) return 'C';
        else if (average >= 50) return 'D';
        else return 'F';
    }
    public void printReportCard() {
        System.out.println("\n--- Report Card ---");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + calculateTotal());
        System.out.printf("Average    : %.2f\n", calculateAverage());
        System.out.println("Grade      : " + getGrade());
    }
}
