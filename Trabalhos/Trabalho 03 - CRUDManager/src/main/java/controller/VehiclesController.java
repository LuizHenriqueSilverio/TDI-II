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

@WebServlet(urlPatterns = {"/vehicles", "/vehicle/form", "/vehicle/insert", "/vehicle/update", "/vehicle/delete"})
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
		case "/crud-manager/vehicle/update": {
			loadVehicle(req);
			loadCompanies(req);
			req.setAttribute("action", "update");
			ControllerUtil.forward(req, resp, "/form-vehicle.jsp");
			break;
		}
		default: 
			listVehicles(req);
				
			ControllerUtil.transferSessionMessagesToRequest(req);	
			ControllerUtil.forward(req, resp, "/vehicles.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI();
            
        switch (action) {
    	case "/crud-manager/vehicle/insert": {
    		insertVehicle(req);
    		ControllerUtil.redirect(resp, req.getContextPath() + "/vehicles");
    		break;
    	}
    	case "/crud-manager/vehicle/update": {
			updateVehicle(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/vehicles");
			break;
		}
    	case "/crud-manager/vehicle/delete": { 
			String vehicleIdStr = req.getParameter("id");
			String vehicleModel = req.getParameter("entityName");
			int vehicleId = Integer.parseInt(vehicleIdStr);
			
			VehicleDAO dao = DAOFactory.createDAO(VehicleDAO.class);
			
			try {
				if(dao.delete(new Vehicle(vehicleId))) {
					ControllerUtil.sucessMessage(req, "Veículo " + vehicleModel + " excluido com sucesso");
				} else {
					ControllerUtil.errorMessage(req, "Veículo " + vehicleModel + " não pode ser excluido");
				}
			} catch (ModelException e) {
				ControllerUtil.errorMessage(req, "Erro ao excluir veículo");
			} finally {
				ControllerUtil.redirect(resp, req.getContextPath() + "/vehicles");
			}
			break;
    	}
    	default:
    		throw new IllegalArgumentException("Unexpected value: " + action);
    	}
	}
	
	private void updateVehicle(HttpServletRequest req) {
		String vehicleIdStr = req.getParameter("vehicleId");
		int vehicleId = Integer.parseInt(vehicleIdStr);
		Vehicle vehicle = createVehicle(req, vehicleId);
		
		VehicleDAO dao = DAOFactory.createDAO(VehicleDAO.class);
		
		try {
			if(dao.update(vehicle) ) {
				ControllerUtil.sucessMessage(req, "Veículo '" + vehicle.getModel() + "' alterado com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "Veículo '" + vehicle.getModel() + "' não pode ser alterado.");
			}
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao alterar dados do veículo");
		}
		
	}

	private void insertVehicle(HttpServletRequest req) {
		Vehicle vehicle = createVehicle(req, 0);
		
		VehicleDAO dao = DAOFactory.createDAO(VehicleDAO.class);
		
		try {
			if ( dao.save(vehicle) ) {
				ControllerUtil.sucessMessage(req, "Veículo '" + vehicle.getModel() + "' salvo com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "Veículo '" + vehicle.getModel() + "' não pode ser salvo.");
			}
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao salvar dados do vendedor");
		}
	}
	
	private void loadVehicle(HttpServletRequest req) {
		String vehicleIdStr = req.getParameter("vehicleId");
		int vehicleId = Integer.parseInt(vehicleIdStr);
		
		VehicleDAO vehicleDAO = DAOFactory.createDAO(VehicleDAO.class);
		Vehicle vehicle = new Vehicle();
		
		try {
			vehicle = vehicleDAO.findById(vehicleId);
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar dados do veículo");
		}
		
		req.setAttribute("vehicleEdit", vehicle);
	}

	private Vehicle createVehicle(HttpServletRequest req, int vehicleId) {
		String vehicleType = req.getParameter("vehicle_type");
		String vehicleBrand = req.getParameter("vehicle_brand");
		String vehicleModel = req.getParameter("vehicle_model");
		String vehicleYearOfManufactureStr = req.getParameter("vehicle_yearOfManufacture");
		int yearOfManufacture = Integer.parseInt(vehicleYearOfManufactureStr);
		String plate = req.getParameter("vehicle_plate");
		String vehicleCompany = req.getParameter("vehicle_company");
		int vehicleCompanyId = Integer.parseInt(vehicleCompany);
		Vehicle vehicle;
		
		if(vehicleId == 0) {
			vehicle = new Vehicle();
		}else {
			vehicle = new Vehicle(vehicleId);
		}
		
		vehicle.setType(vehicleType);
		vehicle.setBrand(vehicleBrand);
		vehicle.setModel(vehicleModel);
		vehicle.setYearOfManufacture(yearOfManufacture);
		vehicle.setPlate(plate);
		vehicle.setCompany(new Company(vehicleCompanyId));
		
		return vehicle;
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
