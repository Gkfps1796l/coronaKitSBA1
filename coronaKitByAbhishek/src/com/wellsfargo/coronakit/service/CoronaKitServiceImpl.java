package com.wellsfargo.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.coronakit.model.CoronaKit;
import com.wellsfargo.coronakit.model.CoronaKitProducts;

public class CoronaKitServiceImpl implements CoronaKitService{

	private boolean isValidPersonName(String personName) {
		return personName != null;
	}
	
	private boolean isValidContactNum(Long contactNum) {
		return String.valueOf(contactNum).length() == 10;
	}
	
	private boolean isValidUserDetails(CoronaKit coronaKit) {
		
		boolean isValidUser = true;
		
		List<String> errMsg = new ArrayList();
		
		if(coronaKit!=null) {
			if(!isValidPersonName(coronaKit.getPersonName())) {
				isValidUser = false;
				errMsg.add("Person name should not be null");
			}
			
			if(!isValidContactNum(coronaKit.getContactNumber())) {
				isValidUser = false;
				errMsg.add("Contact number should be 10 digit mobile number");
			}
		}else {
			isValidUser = false;
		}
		
		return isValidUser;
	}
	@Override
	public boolean verifyUserDetails(CoronaKit coronaKit) {
		boolean isValid = false;
		if(isValidUserDetails(coronaKit)) {
			isValid = true;
		}
		return isValid;
	}

}
