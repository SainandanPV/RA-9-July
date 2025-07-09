package com.litmus7.retail.service;

import java.sql.SQLException;
import java.util.List;

import com.litmus7.retail.dao.ProductDAO;
import com.litmus7.retail.dao.ProductDAOImpl;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.*;
public class ProductService {
	private ProductDAO productDao=new ProductDAOImpl();
	
	private void validateProduct(Product product) throws InvalidProductException{
		if(product.getProductId()<=0) {
			throw new InvalidProductException("Product ID is invalid. It must be positive");
		}
		if (product.getName() == null || product.getName().trim().isEmpty()) {
	        throw new InvalidProductException("Product name cannot be empty!!");
	    }
	    if (product.getCategory() == null || product.getCategory().trim().isEmpty()) {
	        throw new InvalidProductException("Product category cannot be empty!!");
	    }
	    if (product.getPrice() < 0) {
	        throw new InvalidProductException("Invalid product price. It can't be negative!!");
	    }
	    if (product.getStockQuantity() < 0) {
	        throw new InvalidProductException("Invalid Stock Quantity. It can't be negative!!");
	    }
	    
	}
	
	public void addProduct(Product product) throws InvalidProductException,DuplicateProductException{
		validateProduct(product);
		try {
			if(productDao.getProductById(product.getProductId())!=null) {
				throw new DuplicateProductException("Product already exists!!");
			}
			productDao.addProduct(product);
		}
		catch(SQLException e) {
		    throw new InvalidProductException("Error occurred while adding product!! Details: " + e.getMessage(), e);
		}

		
	}
	
	public Product getProductById(int productId) throws InvalidProductException,ProductNotFoundException{
		if(productId<=0) {
			throw new InvalidProductException("Product ID is invalid. It must be positive!!");
		}
		
		try {
			if(productDao.getProductById(productId)==null) {
				throw new ProductNotFoundException("Product with given ID not found!!");
			}
			return productDao.getProductById(productId);
		}
		catch(SQLException e){
			throw new InvalidProductException("Error occured while fetching the Product!!", e);
		}
	}
	
	
	public List<Product> getAllProducts() throws InvalidProductException{
		try {
            return productDao.getAllProducts();
        } catch (SQLException e) {
            throw new InvalidProductException("Error occured while fetching all the products!!", e);
        }
	}
	
	
	public void updateProduct(Product product) throws InvalidProductException, ProductNotFoundException {
        validateProduct(product);

        try {
            if (productDao.getProductById(product.getProductId()) == null) {
                throw new ProductNotFoundException("Cannot update. Product not found with ID: " + product.getProductId());
            }

            productDao.updateProduct(product);
        } 
        catch (SQLException e) {
            throw new InvalidProductException("Error occured while updating the Product!!", e);
        }
    }
	
	
	public void deleteProduct(int productId) throws InvalidProductException, ProductNotFoundException {
        if (productId <= 0) {
            throw new InvalidProductException("Product ID must be positive!!");
        }

        try {
            if (productDao.getProductById(productId) == null) {
                throw new ProductNotFoundException("Product with given ID not found!!");
            }

            productDao.deleteProduct(productId);
        } catch (SQLException e) {
            throw new InvalidProductException("Error occured during deleting Product!!", e);
        }
    }

}
