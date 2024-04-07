package org.jsp.product.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.jsp.product.dto.ProductDetails;

public class ProductImp implements Product {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	{
		Properties p = new Properties();
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(
					"C:\\Users\\ajayk_dqm1o31\\Desktop\\Advance java by satish sir\\Jdbc_Demo\\jdbc.properties");
			p.load(fin);
			con = DriverManager.getConnection(p.getProperty("url"), p);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void saveProduct() {
		ProductDetails pd=null;
		String qry = "insert into user values(?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(qry);
			pst.setInt(1, pd.getId());
			pst.setString(2, pd.getPname());
			pst.setString(3, pd.getBrand());
			pst.setString(4, pd.getCate());
			pst.setString(5, pd.getDesce());
			pst.setDouble(6, pd.getCost());
			pst.setString(7, pd.getImgUrl());
			pst.executeUpdate();
			System.out.println("Updated successfully");
		} catch (SQLException e) {
			System.out.println("Unable to save user"); 
		}


	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findProductById() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProductById() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findProductByBrand() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findProductByCate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void filterProductByCost() {
		// TODO Auto-generated method stub

	}

}
