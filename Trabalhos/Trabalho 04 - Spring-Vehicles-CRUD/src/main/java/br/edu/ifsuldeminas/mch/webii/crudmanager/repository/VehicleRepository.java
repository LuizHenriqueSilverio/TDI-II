package br.edu.ifsuldeminas.mch.webii.crudmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    
}
