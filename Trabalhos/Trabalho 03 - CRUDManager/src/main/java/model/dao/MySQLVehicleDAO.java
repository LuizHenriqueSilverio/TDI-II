package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.Company;
import model.ModelException;
import model.Vehicle;

public class MySQLVehicleDAO implements VehicleDAO{

	@Override
	public boolean save(Vehicle vehicle) throws ModelException {
		DBHandler db = new DBHandler();
		
		String sqlInsert = "INSERT INTO vehicles VALUES " + " (DEFAULT, ?, ?, ?, ?, ?);";
		
		db.prepareStatement(sqlInsert);
		db.setString(1, vehicle.getType());
		db.setString(2, vehicle.getBrand());
		db.setInt(3, vehicle.getYearOfManufacture());
		db.setString(4, vehicle.getColor());
		db.setInt(5, vehicle.getCompany().getId());
		
		return db.executeUpdate() > 0;
	}

	@Override
	public boolean update(Vehicle vehicle) throws ModelException {
		DBHandler db = new DBHandler();
		
		String sqlUpdate = "UPDATE vehicles "
						   + " SET type = ?, "
						   + " brand = ?, "
						   + " yearOfManufacture = ?, "
						   + " color = ?, "
						   + " company_id = ? "
						 + " WHERE id = ?;";
		
		db.prepareStatement(sqlUpdate);
		
		db.setString(1, vehicle.getType());
		db.setString(2, vehicle.getBrand());
		db.setInt(3, vehicle.getYearOfManufacture());
		db.setString(4, vehicle.getColor());
		db.setInt(5, vehicle.getCompany().getId());
		db.setInt(6, vehicle.getId());
		
		return db.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Vehicle vehicle) throws ModelException {
		DBHandler db = new DBHandler();
		
		String sqlDelete = " DELETE FROM vehicles "
						 + " WHERE id = ?;";
		
		db.prepareStatement(sqlDelete);
		db.setInt(1, vehicle.getId());
		
		return db.executeUpdate() > 0;
	}

	@Override
	public List<Vehicle> listAll() throws ModelException {
		DBHandler db = new DBHandler();
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		String sqlQuery = " SELECT * FROM vehicles";
		
		db.createStatement();
		
		db.executeQuery(sqlQuery);
		
		while(db.next()) {
			Vehicle v = createVehicle(db);
			vehicles.add(v);
		}
		
		return vehicles;
	}

	@Override
	public Vehicle findById(int id) throws ModelException {
		DBHandler db = new DBHandler();
		
		String sqlQuery = "SELECT * FROM vehicles WHERE id = ?;";
		
		db.prepareStatement(sqlQuery);
		db.setInt(1, id);
		db.executeQuery();
		
		Vehicle v = null;
		while(db.next()) {
			v = createVehicle(db);
			break;
		}
		
		return v;
	}
	
	private Vehicle createVehicle(DBHandler db) throws ModelException {
		Vehicle v = new Vehicle(db.getInt("id"));
		v.setType(db.getString("type"));
		v.setBrand(db.getString("brand"));
		v.setYearOfManufacture(db.getInt("yearOfManufacture"));
		v.setColor(db.getString("color"));
		CompanyDAO companyDAO = DAOFactory.createDAO(CompanyDAO.class);
		Company c = companyDAO.findById(db.getInt("company_id"));
		v.setCompany(c);
		
		return v;
	}
}
