package com.litmus7.retail.controller;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.*;
import com.litmus7.retail.service.ProductService;

public class ProductController {
	private ProductService productService=new ProductService();
	public void addProduct(Product product) {
		try {
			productService.addProduct(product);
			System.out.println("Product added Successfully!!");
		}
		catch(InvalidProductException e) {
			System.out.println(e.getMessage());
		}
		catch(DuplicateProductException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Product getProductById(int id) {
		try {
			Product product=productService.getProductById(id);
			return product;
		}
		catch(InvalidProductException e) {
			System.out.println(e.getMessage());
		}
		catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<Product> getAllProducts(){
		try {
			List<Product> productList=new ArrayList<>();
			productList=productService.getAllProducts();
			return productList;
		}
		catch(InvalidProductException e){
			System.out.println(e.getMessage());
			return new ArrayList<>();
		}
	}
	
	public void updateProduct(Product product) {
		try {
			productService.updateProduct(product);
			System.out.println("Product updated successfully!!");
		}
		catch(InvalidProductException e) {
			System.out.println(e.getMessage());
		}
		catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteProduct(int id) {
		try {
			productService.deleteProduct(id);
			System.out.println("Product deleted successfully!!");
		}
		catch(InvalidProductException e) {
			System.out.println(e.getMessage());
		}
		catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
