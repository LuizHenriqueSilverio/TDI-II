package br.edu.ifsuldeminas.mch.webii.crudmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Dealership;

public interface DealershipRepository  extends JpaRepository<Dealership, Integer> {
    
}
