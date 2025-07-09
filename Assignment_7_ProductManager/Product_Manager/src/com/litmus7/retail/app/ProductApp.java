package com.litmus7.retail.app;

import java.util.List;
import java.util.Scanner;

import com.litmus7.retail.controller.ProductController;
import com.litmus7.retail.dto.Product;

public class ProductApp {
	public static void main(String[] args) {
		ProductController productController=new ProductController();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("Product Management System\n\n");
			System.out.println("1.Add new product");
			System.out.println("2.Get product by Product ID");
			System.out.println("3.Get all products");
			System.out.println("4.Update any existing product");
			System.out.println("5.Delete product");
			System.out.println("6.Exit");
			System.out.println("Enter your choice : ");
			
			int choice=0;
			try {
				choice=Integer.parseInt(scanner.nextLine());
			}
			catch(Exception e) {
				System.out.println("Invalid Input!!");
				continue;
			}
			
			switch(choice) {
			case 1:
				System.out.println("Enter Product ID : ");
				int id=Integer.parseInt(scanner.nextLine());
				System.out.print("Enter Product Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Category: ");
                String category = scanner.nextLine();
                System.out.print("Enter Price: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter Stock Quantity: ");
                int stock = Integer.parseInt(scanner.nextLine());
                
                Product product = new Product(id, name, category, price, stock);
                productController.addProduct(product);
                break;
		
			case 2:
				System.out.println("Enter Product ID : ");
				int searchId=Integer.parseInt(scanner.nextLine());
				if(productController.getProductById(searchId)!=null) {
					System.out.println(productController.getProductById(searchId));
				}
				else {
					System.out.println("Product with given product id not found!!");
				}
				break;
			case 3:
                List<Product> productList = productController.getAllProducts();
                if (productList != null && !productList.isEmpty()) {
                    for (Product prod : productList) {
                        System.out.println(prod);
                    }
                } else {
                    System.out.println("No products found!!");
                }
                break;
			
			case 4:
				System.out.println("Enter product ID : ");
				int updateId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter New Product Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter New Category: ");
                String newCategory = scanner.nextLine();
                System.out.print("Enter New Price: ");
                double newPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter New Stock Quantity: ");
                int newStock = Integer.parseInt(scanner.nextLine());

                Product updatedProduct = new Product(updateId, newName, newCategory, newPrice, newStock);
                productController.updateProduct(updatedProduct);
                break;
                
			case 5:
                System.out.print("Enter Product ID to delete: ");
                int deleteId = Integer.parseInt(scanner.nextLine());
                productController.deleteProduct(deleteId);
                break;
                
			case 6:
				System.out.println("Thank You!!!");
                scanner.close();
                System.exit(0);	
            default:
            	System.out.println("Enter a valid choice!!");
			}
		}
	}
}
