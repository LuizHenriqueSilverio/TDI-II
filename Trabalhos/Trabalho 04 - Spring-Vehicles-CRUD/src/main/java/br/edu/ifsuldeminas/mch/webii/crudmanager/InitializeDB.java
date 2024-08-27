package br.edu.ifsuldeminas.mch.webii.crudmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Address;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Dealership;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Vehicle;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.AddressRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.DealershipRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.VehicleRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitializeDB implements CommandLineRunner{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private DealershipRepository dealershipRepo;

    @Autowired
    private VehicleRepository vehicleRepo;

    @Override
    public void run(String... args) throws Exception {
        User luiz = new User();
        luiz.setName("Luiz Henrique Souza");
        luiz.setGender("M");
        luiz.setEmail("luiz@mail.com");
        
        Address address1 = new Address();
        address1.setPlace("Rua 25 de março");
        address1.setNumber(11);
        address1.setZipCode("37130-123");
        
        User gui = new User();
        gui.setName("Guilherme Souza");
        gui.setGender("M");
        gui.setEmail("gui@mail.com");

        Address address2 = new Address();
        address2.setPlace("Rua Sete");
        address2.setNumber(125);
        address2.setZipCode("37130-000");
        

        addressRepo.save(address1);
        addressRepo.save(address2);
        addressRepo.flush();

        luiz.setAddress(address1);
        gui.setAddress(address2);

        userRepo.save(luiz);
        userRepo.save(gui);

        Dealership dealership = new Dealership();
        dealership.setName("Concessionária do Zé");
        dealership.setAddress("Rua 25 de março, 11");
        dealership.setPhone("35 99999-9999");
        dealership.setCnpj("12345678901234");

        dealershipRepo.save(dealership);

        Vehicle car = new Vehicle();
        car.setBrand("Chevrolet");
        car.setModel("Onix");
        car.setManufactureYear("2021");
        car.setColor("Preto");
        car.setPlate("ABC-1234");
        car.setDealership(dealership);

        Vehicle car2 = new Vehicle();
        car2.setBrand("Toyota");
        car2.setModel("Corolla");
        car2.setManufactureYear("2022");
        car2.setColor("Branco");
        car2.setPlate("DEF-5678");
        car2.setDealership(dealership);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(car2);

        dealership.setVehicles(vehicles);

        vehicleRepo.saveAll(vehicles);

    }

}
