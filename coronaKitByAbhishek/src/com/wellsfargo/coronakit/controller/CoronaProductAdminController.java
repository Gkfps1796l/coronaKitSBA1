package com.wellsfargo.coronakit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wellsfargo.coronakit.dao.CoronaProductsDaoImpl;
import com.wellsfargo.coronakit.exception.MyException;
import com.wellsfargo.coronakit.model.CoronaKitProducts;
import com.wellsfargo.coronakit.service.CoronaProductsService;
import com.wellsfargo.coronakit.service.CoronaProductsServiceImpl;

/**
 * Servlet implementation class CoronaProductAdminController
 */
@WebServlet({"/adminLoginLink","/adminHome","/showProduct", "/adminLogin", "/addProduct", "/editProduct", "/deleteProduct", "/createOrSaveProduct", "/saveProduct", "/newProduct"})
public class CoronaProductAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private CoronaProductsService coronaProductsService;

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
		case "/adminLoginLink": view = "adminLogin.jsp";break;
		case "/showProduct": view = doListProducts(request, response);break;
		case "/adminHome": view = "adminHome.jsp";break;
		//case "/adminLogin": 
		case "/addProduct": view = doAddProduct(request, response);break;
		case "/editProduct": view = doUpdateProduct(request, response);break;
		case "/saveProduct": view = createOrSaveProduct(request, response);break;
		case "/newProduct": view = createOrSaveProduct(request, response);break;
		case "/deleteProduct": view = doDeleteProduct(request, response);break;
		}
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}
		
	private String doListProducts(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
		
		try {
			List<CoronaKitProducts> productList = coronaProductsService.getAll();
			session.removeAttribute("successMsg");
			request.setAttribute("productList", productList);
			view = "productList.jsp";
		} catch (MyException e) {
			session.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}
		return view;
	}
	
	private String doDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
		//HttpSession session = request.getSession();
		String view = "";
		int productId = Integer.parseInt(request.getParameter("id"));
		
		try {
			coronaProductsService.deleteProduct(productId);
			request.setAttribute("successMsg", "Product with id "+productId+" has been deleted successfully !!");
			view = "adminHome.jsp";
		} catch (MyException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}
		return view;
	}
	
	private String doAddProduct(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
		CoronaKitProducts product = new CoronaKitProducts();
		request.setAttribute("product", product);
		request.setAttribute("isNew", true);
		
		view = "addEditProduct.jsp";
		return view;
	}
	
	private String doUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "";
	
		int pId = Integer.parseInt(request.getParameter("id"));
		
		try {
			CoronaKitProducts product = coronaProductsService.getProduct(pId);
			request.setAttribute("product", product);
			request.setAttribute("isNew", false);
			
			view = "addEditProduct.jsp";
		} catch (MyException e) {
			session.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}
		return view;
	}
	
	private String createOrSaveProduct(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		CoronaKitProducts product = new CoronaKitProducts();
		product.setpId(Integer.parseInt(request.getParameter("pId")));
		product.setpName(request.getParameter("pName"));
		product.setpDesc(request.getParameter("pDesc"));
		product.setpCost(Integer.parseInt(request.getParameter("pCost")));
		
		String view = "";
		
	
			try {
				if(request.getServletPath().equals("/newProduct")) {
					coronaProductsService.validateAndAddProduct(product);	
					request.setAttribute("successMsg", "\""+request.getParameter("pName")+"\" Product has been added successfully");
				}else {
					coronaProductsService.validateAndSaveProduct(product);
					request.setAttribute("successMsg", "\""+request.getParameter("pName")+"\" Product has been updated successfully");
				}
				
				view = "adminHome.jsp";
			} catch (MyException e) {
				session.setAttribute("errMsg", e.getMessage());
				view = "errPage.jsp";
			}
	
		return view;
	}

}
