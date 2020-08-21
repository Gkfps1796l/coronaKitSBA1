package com.wellsfargo.coronakit.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wellsfargo.coronakit.dao.CoronaProductsDaoImpl;
import com.wellsfargo.coronakit.exception.MyException;
import com.wellsfargo.coronakit.model.CoronaKit;
import com.wellsfargo.coronakit.model.CoronaKitProducts;
import com.wellsfargo.coronakit.service.CoronaKitService;
import com.wellsfargo.coronakit.service.CoronaKitServiceImpl;
import com.wellsfargo.coronakit.service.CoronaProductsService;
import com.wellsfargo.coronakit.service.CoronaProductsServiceImpl;

/**
 * Servlet implementation class CoronaProductAdminController
 */
@WebServlet({"/newUser", "/verifyUserDetails", "/addProductsToKit", "/enterDeliveryAddress", "/orderSummary"})
public class CoronaProductUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	private CoronaProductsService coronaProductsService;
	CoronaKit coronaKit;
	List<CoronaKitProducts> productList;
	Map<Integer, Integer> pQtyMap;

	@Override
	public void init() throws ServletException {
		coronaProductsService = new CoronaProductsServiceImpl();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		
		String url = request.getServletPath();
		String view = "";
		
		switch(url) {
		case "/newUser": view = "newUser.jsp";break;
		case "/verifyUserDetails": view = doListProducts(request, response);break;
		case "/addProductsToKit": view = addProductsToKit(request, response);break;
		case "/enterDeliveryAddress": view = "enterDeliveryAddress.jsp";;break;
		case "/orderSummary": view = doOrderSummary(request, response);break;
		default: view = "errPage.jsp";break;
		
		}
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}
		
	private String doListProducts(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		String view = "";
		coronaKit = new CoronaKit();
		coronaKit.setPersonName(request.getParameter("uName"));
		coronaKit.setContactNumber(Long.parseLong(request.getParameter("contact")));
		coronaKit.setEmail(request.getParameter("eMail"));
		coronaKit.setOrderDate(LocalDateTime.now());
		
		CoronaKitService coronaKitService = new CoronaKitServiceImpl();
		
		if(coronaKitService.verifyUserDetails(coronaKit)) {
			session.setAttribute("coronaKit", coronaKit);
			try {
				List<CoronaKitProducts> productList = coronaProductsService.getAll();
				
				session.setAttribute("productList", productList);
				view = "showProductstoAdd.jsp";
			} catch (MyException e) {
				session.setAttribute("errMsg", e.getMessage());
				view = "errPage.jsp";
			}
		}else {
			session.setAttribute("errMsg", "Kindly provide valid user details");
			view = "errPage.jsp";
		}
		return view;
	}
	
	private String addProductsToKit(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		String view = "";
		try {
			productList = coronaProductsService.getAll();
			pQtyMap = new HashMap<Integer, Integer>();
			
			int productListSize = productList.size();
			
			Iterator<CoronaKitProducts> i = productList.iterator();
			int pQty = 0;
			while(i.hasNext()) {
				try {
					pQty = Integer.parseInt(request.getParameter("pQuantity"+i.next().getpId()));
				}catch(NumberFormatException e){
					pQty = 0;
				}
				
				if( pQty == 0) {
					i.remove();
				}
			}
			
			if(productList.size()!=0) {
				for(int j = 0; j < productList.size(); j++) {
					pQtyMap.put(productList.get(j).getpId(), Integer.parseInt(request.getParameter("pQuantity"+productList.get(j).getpId())));
				}
				
				session.setAttribute("productList", productList);
				session.setAttribute("pQtyMap", pQtyMap);
				view = "productsAddedToKit.jsp";
			}else {
				session.setAttribute("errMsg", "Please enter quantity for at least one product");
				view = "errPage.jsp";
			}
			
			
		} catch (MyException e) {
			session.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}
		return view;
	}
	
	private String doOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		String view = "";
		int allItemsCost = 0;
		
		coronaKit.setDeliveryAddress(request.getParameter("dAddress"));
		Map<Integer, Integer> totalCostMap = new HashMap<Integer, Integer>();
		
		for(CoronaKitProducts product: productList) {
			totalCostMap.put(product.getpId(), product.getpCost()*pQtyMap.get(product.getpId()));
			allItemsCost = allItemsCost + product.getpCost()*pQtyMap.get(product.getpId());
		}
		session.setAttribute("coronaKit", coronaKit);
		session.setAttribute("allItemsCost", allItemsCost);
		session.setAttribute("totalCostMap", totalCostMap);
		view = "orderSummary.jsp";
		return view;
	}
}
