package com.wellsfargo.coronakit.dao;

import java.util.List;

import com.wellsfargo.coronakit.exception.MyException;
import com.wellsfargo.coronakit.model.CoronaKitProducts;

public interface CoronaProductsDao {

	CoronaKitProducts addProduct(CoronaKitProducts coronaKitProducts) throws MyException;
	CoronaKitProducts editProduct(CoronaKitProducts coronaKitProducts) throws MyException;
	boolean deleteProductById(int pId) throws MyException;
	List<CoronaKitProducts> getAllProducts() throws MyException;
	CoronaKitProducts getProduct(int pId) throws MyException;
}
