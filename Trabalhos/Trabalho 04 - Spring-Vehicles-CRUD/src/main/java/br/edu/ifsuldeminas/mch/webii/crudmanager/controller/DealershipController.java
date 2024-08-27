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

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Dealership;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.DealershipRepository;
import jakarta.validation.Valid;

@Controller
public class DealershipController {
    
    @Autowired
    private DealershipRepository dealershipRepo;

    @GetMapping("/dealerships")
    public String listDealerships(Model model) {
        List<Dealership> dealerships = dealershipRepo.findAll();

        model.addAttribute("dealerships", dealerships);

        return "dealerships";
    }

    @GetMapping("/dealerships/form")
    public String dealershipForm(@ModelAttribute("dealership") Dealership dealership) {
        return "dealerships_form";
    }

    @PostMapping("/dealerships/register")
    public String dealershipNew(@Valid @ModelAttribute("dealership") Dealership dealership, BindingResult errors) {

        if (errors.hasErrors()) {
            return "dealerships_form";
        }

        dealershipRepo.save(dealership);

        return "redirect:/dealerships";
    }

    @GetMapping("/dealerships/update/{id}")
    public String dealershipUpdate(@PathVariable("id") Integer id, Model model) {

        Optional<Dealership> dealershipOpt = dealershipRepo.findById(id);
        Dealership dealership;

        if (dealershipOpt.isPresent()) {
            dealership = dealershipOpt.get();
        } else {
            dealership = new Dealership();
        }

        model.addAttribute("dealership", dealership);

        return "dealerships_form";
    }

    @GetMapping("/dealerships/delete/{id}")
    public String dealershipDelete(@PathVariable("id") Integer id) {

        Optional<Dealership> dealershipOpt = dealershipRepo.findById(id);

        if (dealershipOpt.isPresent()) {
            dealershipRepo.delete(dealershipOpt.get());
        }

        return "redirect:/dealerships";
    }
}
