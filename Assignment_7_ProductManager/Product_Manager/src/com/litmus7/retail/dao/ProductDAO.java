package com.litmus7.retail.dao;

import java.sql.SQLException;
import java.util.List;

import com.litmus7.retail.dto.Product;

public interface ProductDAO {
	void addProduct(Product product) throws SQLException;
	Product getProductById(int productId) throws SQLException;
	List<Product> getAllProducts() throws SQLException;
	void updateProduct(Product product) throws SQLException;
	void deleteProduct(int productId) throws SQLException;
}
