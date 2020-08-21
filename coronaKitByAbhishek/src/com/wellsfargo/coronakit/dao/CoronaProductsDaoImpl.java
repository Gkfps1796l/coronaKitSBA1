package com.wellsfargo.coronakit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.coronakit.exception.MyException;
import com.wellsfargo.coronakit.model.CoronaKitProducts;

public class CoronaProductsDaoImpl implements CoronaProductsDao {

	private static String product_Add_Query = "Insert into coronakit(pId,pname,pdesc,pcost) values(?,?,?,?)";
	private static String product_Edit_Query = "Update coronakit set pname=?, pdesc=?,pcost=? Where pId=?";
	private static String product_Delete_Query = "Delete From coronakit Where pId=?";
	private static String product_GetAll_Query = "Select pId,pName,pDesc,pCost From coronakit";
	private static String product_GetSingle_Query = "Select pId,pName,pDesc,pCost From coronakit Where pId=?";
	
	
	@Override
	public CoronaKitProducts addProduct(CoronaKitProducts coronaKitProducts) throws MyException {
		
		if(coronaKitProducts!=null) {
			try(Connection connection = ConnectionFactory.getConnection();
					PreparedStatement pst = connection.prepareStatement(product_Add_Query);){
				
				pst.setInt(1, coronaKitProducts.getpId());
				pst.setString(2, coronaKitProducts.getpName());
				pst.setString(3, coronaKitProducts.getpDesc());
				pst.setInt(4, coronaKitProducts.getpCost());
				
				pst.executeUpdate();
				
			}catch(SQLException e) {
				throw new MyException("Error occured!! Could not add the product details");
			}
		}
		return coronaKitProducts;
	}

	@Override
	public CoronaKitProducts editProduct(CoronaKitProducts coronaKitProducts) throws MyException {
		if(coronaKitProducts!=null) {
			try(Connection connection = ConnectionFactory.getConnection();
					PreparedStatement pst = connection.prepareStatement(product_Edit_Query);){
				
				
				pst.setString(1, coronaKitProducts.getpName());
				pst.setString(2, coronaKitProducts.getpDesc());
				pst.setInt(3, coronaKitProducts.getpCost());
				pst.setInt(4, coronaKitProducts.getpId());
				
				pst.executeUpdate();
				
			}catch(SQLException e) {
				throw new MyException("Error occured!! Could not save the product details");
			}
		}
		return coronaKitProducts;
	}

	@Override
	public boolean deleteProductById(int pId) throws MyException {
		boolean isDeleted = false;
		try(Connection connection = ConnectionFactory.getConnection();
				PreparedStatement pst = connection.prepareStatement(product_Delete_Query);){
			
			pst.setInt(1, pId);
			
			int noOfRows = pst.executeUpdate();
			
			isDeleted = noOfRows > 0;
			
		}catch(SQLException e) {
			throw new MyException("Error occured!! Could not delete the product details");
		}
		return isDeleted;
		
	}

	@Override
	public List<CoronaKitProducts> getAllProducts() throws MyException {
		List<CoronaKitProducts> list = new ArrayList();
		try(Connection connection = ConnectionFactory.getConnection();
				PreparedStatement pst = connection.prepareStatement(product_GetAll_Query);){
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				CoronaKitProducts coronaKitProducts = new CoronaKitProducts();
				coronaKitProducts.setpId(rs.getInt(1));
				coronaKitProducts.setpName(rs.getString(2));
				coronaKitProducts.setpDesc(rs.getString(3));
				coronaKitProducts.setpCost(rs.getInt(4));
				
				list.add(coronaKitProducts);
			}
			
			if(list.isEmpty()) {
				list = null;
			}
			
		}catch(SQLException e) {
			throw new MyException("Error occured!! Could not retrieve product details");
		}
		
		return list;
	}

	@Override
	public CoronaKitProducts getProduct(int pId) throws MyException {
		CoronaKitProducts coronaKitProducts = null;
		try(Connection connection = ConnectionFactory.getConnection();
				PreparedStatement pst = connection.prepareStatement(product_GetSingle_Query);){
			
			pst.setInt(1, pId);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				coronaKitProducts = new CoronaKitProducts();
				coronaKitProducts.setpId(rs.getInt(1));
				coronaKitProducts.setpName(rs.getString(2));
				coronaKitProducts.setpDesc(rs.getString(3));
				coronaKitProducts.setpCost(rs.getInt(4));
			}
			
		}catch(SQLException e) {
			throw new MyException("Error occured!! Could not retrieve product details");
		}
		return coronaKitProducts;
	}

}
