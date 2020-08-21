package com.wellsfargo.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.coronakit.dao.CoronaProductsDao;
import com.wellsfargo.coronakit.dao.CoronaProductsDaoImpl;
import com.wellsfargo.coronakit.exception.MyException;
import com.wellsfargo.coronakit.model.CoronaKitProducts;

public class CoronaProductsServiceImpl implements CoronaProductsService {

	
	public CoronaProductsDao coronaProductsDao;
	
	public CoronaProductsServiceImpl() {
		coronaProductsDao = new CoronaProductsDaoImpl();
	}
	
	private boolean isValidProductId(Integer pId) {
		return pId > 0 && pId != null;
	}
	
	private boolean isValidProductName(String pName) {
		return pName != null && pName.length() <= 15;
	}
	
	private boolean isValidProductDesc(String pDesc) {
		return pDesc != null && pDesc.length() <= 255;
	}
	private boolean isValidProductCost(Integer pCost) {
		return pCost > 0 && pCost != null;
	}
	
	private boolean isValidProduct(CoronaKitProducts coronaKitProducts) {
		
		boolean isValidProduct = true;
		
		List<String> errMsg = new ArrayList();
		
		if(coronaKitProducts!=null) {
			if(!isValidProductId(coronaKitProducts.getpId())) {
				isValidProduct = false;
				errMsg.add("Product id must be a positive non-repetative number");
			}
			
			if(!isValidProductCost(coronaKitProducts.getpCost())) {
				isValidProduct = false;
				errMsg.add("Product Cost must be a positive non-zero value");
			}
			
			if(!isValidProductName(coronaKitProducts.getpName())) {
				isValidProduct = false;
				errMsg.add("Product Name length must be less than 15 characters");
			}
			
			if(!isValidProductDesc(coronaKitProducts.getpDesc())) {
				isValidProduct = false;
				errMsg.add("Product Description length must be less than 255 characters");
			}
			
		}else {
			isValidProduct = false;
		}
		
		return isValidProduct;
	}
	
	@Override
	public CoronaKitProducts validateAndAddProduct(CoronaKitProducts coronaKitProducts) throws MyException {
		if(isValidProduct(coronaKitProducts)) {
			coronaProductsDao.addProduct(coronaKitProducts);
		}
		return coronaKitProducts;
	}

	@Override
	public CoronaKitProducts validateAndSaveProduct(CoronaKitProducts coronaKitProducts) throws MyException {
		if(isValidProduct(coronaKitProducts)) {
			coronaProductsDao.editProduct(coronaKitProducts);
		}
		return coronaKitProducts;
	}

	@Override
	public boolean deleteProduct(int pId) throws MyException {
		return coronaProductsDao.deleteProductById(pId);
	}

	@Override
	public List<CoronaKitProducts> getAll() throws MyException {
		return coronaProductsDao.getAllProducts();
	}

	@Override
	public CoronaKitProducts getProduct(int pId) throws MyException {
		return coronaProductsDao.getProduct(pId);
	}

}
