package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Company;
import model.ModelException;
import model.Vehicle;
import model.dao.CompanyDAO;
import model.dao.DAOFactory;
import model.dao.VehicleDAO;

@WebServlet(urlPatterns = {"/vehicles", "/vehicle/form"})
public class VehiclesController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getRequestURI();
		
		switch (action) {
		case "/crud-manager/vehicle/form": {
			loadCompanies(req);
			req.setAttribute("action", "insert");
			ControllerUtil.forward(req, resp, "/form-vehicle.jsp");
			break;
		}
		default: 
			listVehicles(req);
				
			ControllerUtil.transferSessionMessagesToRequest(req);	
			ControllerUtil.forward(req, resp, "/vehicles.jsp");
				
			break;
		}
	}

	private void loadCompanies(HttpServletRequest req) {
		List<Company> companies = new ArrayList<>();
		CompanyDAO dao = DAOFactory.createDAO(CompanyDAO.class);
		try {
			companies = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar dados das empresas");
		}
		
		req.setAttribute("companies", companies);
	}
	
	private void listVehicles(HttpServletRequest req) {
		VehicleDAO vehicleDAO = DAOFactory.createDAO(VehicleDAO.class);
		
		List<Vehicle> vehicles = new ArrayList<>();
		
		try {
			vehicles = vehicleDAO.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar dados dos veículos");
		}
		
		req.setAttribute("vehicles", vehicles);
	}
}
