package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Vehicle;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.DealershipRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.VehicleRepository;
import jakarta.validation.Valid;

@Controller
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepo;

    @Autowired
    private DealershipRepository dealershipRepo;

    @GetMapping("/vehicles")
    public String listVehicles(Model model) {
        List<Vehicle> vehicles = vehicleRepo.findAll();

        model.addAttribute("vehicles", vehicles);

        return "vehicles";
    }
    
    @GetMapping("/vehicles/form")
    public String vehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("dealerships", dealershipRepo.findAll());
        return "vehicles_form";
    }

    @PostMapping("/vehicles/register")
    public String vehicleNew(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult errors) {

        if (errors.hasErrors()) {
            return "vehicles_form";
        }

        vehicleRepo.save(vehicle);

        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/update/{id}")
    public String vehicleUpdate(@PathVariable("id") Integer id, Model model) {

        Optional<Vehicle> vehicleOpt = vehicleRepo.findById(id);
        Vehicle vehicle;

        if (vehicleOpt.isPresent()) {
            vehicle = vehicleOpt.get();
        } else {
            vehicle = new Vehicle();
        }

        model.addAttribute("vehicle", vehicle);
        model.addAttribute("dealerships", dealershipRepo.findAll());

        return "vehicles_form";
    }

    @GetMapping("/vehicles/delete/{id}")
    public String vehicleDelete(@PathVariable("id") Integer id) {

        Optional<Vehicle> vehicleOpt = vehicleRepo.findById(id);

        if (vehicleOpt.isPresent()) {
            vehicleRepo.delete(vehicleOpt.get());
        }

        return "redirect:/vehicles";
    }
}
