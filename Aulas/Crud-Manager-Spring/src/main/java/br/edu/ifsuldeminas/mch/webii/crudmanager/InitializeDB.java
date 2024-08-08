package br.edu.ifsuldeminas.mch.webii.crudmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.UserRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitializeDB implements CommandLineRunner{

    @Autowired
    private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {
        User luiz = new User();
        luiz.setName("Luiz Henrique Souza");
        luiz.setGender("M");
        luiz.setEmail("luiz@mail.com");

        User gui = new User();
        gui.setName("Guilherme Souza");
        gui.setGender("M");
        gui.setEmail("gui@mail.com");

        userRepo.save(luiz);
        userRepo.save(gui);
    }

}
