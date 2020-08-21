package com.wellsfargo.coronakit.service;

import java.util.List;

import com.wellsfargo.coronakit.exception.MyException;
import com.wellsfargo.coronakit.model.CoronaKitProducts;

public interface CoronaProductsService {
	
	CoronaKitProducts validateAndAddProduct(CoronaKitProducts coronaKitProducts) throws MyException;
	CoronaKitProducts validateAndSaveProduct(CoronaKitProducts coronaKitProducts) throws MyException;
	boolean deleteProduct(int pId) throws MyException;
	List<CoronaKitProducts> getAll() throws MyException;
	CoronaKitProducts getProduct(int pId) throws MyException;

}
