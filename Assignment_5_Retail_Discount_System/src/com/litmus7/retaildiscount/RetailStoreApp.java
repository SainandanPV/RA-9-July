package com.litmus7.retaildiscount;
import java.util.Scanner;
import com.litmus7.retaildiscount.model.Discountable;
import com.litmus7.retaildiscount.model.impl.PremiumCustomer;
import com.litmus7.retaildiscount.model.impl.RegularCustomer;
import com.litmus7.retaildiscount.model.impl.WholeSaleCustomer;

public class RetailStoreApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter customer type - Regular / Premium / Wholesale : ");
        String customerType = scanner.nextLine().trim().toLowerCase();

        System.out.println("Total purchase amount:");
        double totalAmount = scanner.nextDouble();

        Discountable customer = null;

        switch (customerType) {
            case "regular":
                customer = new RegularCustomer();
                break;
            case "premium":
                customer = new PremiumCustomer();
                break;
            case "wholesale":
                customer = new WholeSaleCustomer();
                break;
            default:
                System.out.println("Invalid customer type!!");
                System.exit(1);
        }
        
        double finalAmount = customer.applyDiscount(totalAmount);
        double discountApplied = totalAmount - finalAmount;

        System.out.printf("Original amount: ₹%.2f%n", totalAmount);
        System.out.printf("Discount applied: ₹%.2f%n", discountApplied);
        System.out.printf("Final amount payable: ₹%.2f%n", finalAmount);

        scanner.close();
	}
}
