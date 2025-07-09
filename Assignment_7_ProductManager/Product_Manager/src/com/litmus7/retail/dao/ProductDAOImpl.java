package com.litmus7.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {
	public void addProduct(Product product) throws SQLException {
		String sql="insert into products(productId,name,category,price,stockQuantity) values(?,?,?,?,?)";
		try(Connection conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setInt(1,product.getProductId());
			ps.setString(2,product.getName());
			ps.setString(3, product.getCategory());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStockQuantity());
			ps.executeUpdate();
		}	
	}
	
	public Product getProductById(int productId) throws SQLException{
		String sql="select * from products where productId=?";
		try(Connection conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setInt(1, productId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int id=rs.getInt("productId");
				String name=rs.getString("name");
				String category=rs.getString("category");
				double price=rs.getDouble("price");
				int stockQuantity=rs.getInt("stockQuantity");
				
				return new Product(id,name,category,price,stockQuantity);
				
			}
			else {
				return null;
			}
		}
	}
	
	public List<Product> getAllProducts() throws SQLException{
		String sql="select * from products";
		List<Product> products=new ArrayList<>();
		try(Connection conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql)){
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("productId");
				String name=rs.getString("name");
				String category=rs.getString("category");
				double price=rs.getDouble("price");
				int stockQuantity=rs.getInt("stockQuantity");
				
				
				products.add(new Product(id,name,category,price,stockQuantity));
			}
			return products;
		}
	}
	
	public void updateProduct(Product product) throws SQLException{
		String sql="update products set name=?,category=?,price=?,stockQuantity=? where productId=?";
		try(Connection conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setString(1, product.getName());
			ps.setString(2, product.getCategory());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getStockQuantity());
			ps.setInt(5, product.getProductId());
			
			int rowsUpdated=ps.executeUpdate();
			if(rowsUpdated==0) {
				System.out.println("No product found with ID : "+product.getProductId());
			}
			else {
				System.out.println("Product updated successfully!!");
			}
		}
	}
	
	public void deleteProduct(int productId) throws SQLException{
		String sql="delete from products where productId=?";
		try(Connection conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setInt(1, productId);
			int rowsDeleted=ps.executeUpdate();
			if (rowsDeleted == 0) {
	            System.out.println("No product found with ID : " + productId);
	        } else {
	            System.out.println("Product deleted successfully!!");
	        }
		}
	}
	
}
