package com.banque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.banque.dao.ClientRepository;
import com.banque.dao.CompteRepository;
import com.banque.dao.OperationRepository;
import com.banque.entities.Client;
import com.banque.entities.Compte;
import com.banque.entities.CompteCourant;
import com.banque.entities.CompteEpargne;
import com.banque.entities.Operation;
import com.banque.entities.Retrait;
import com.banque.entities.Versement;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner  {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = clientRepository.save(new Client("hassan","hassan@hotmail.com"));
		Client c2 =	clientRepository.save(new Client("yahya","yahya@hotmail.com"));
		
		Compte cp1 = compteRepository.save(new CompteCourant("c1",new Date(),9000,c1,6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2",new Date(),6000,c2,5.5));
		
		
		Operation op1 = operationRepository.save(new Versement(new Date(),9000,cp1));
		Operation op2 = operationRepository.save(new Versement(new Date(),6000,cp1));
		Operation op3 = operationRepository.save(new Versement(new Date(),2300,cp1));
		
		
		Operation op4 = operationRepository.save(new Retrait(new Date(),2300,cp2));
		Operation op5 = operationRepository.save(new Retrait(new Date(),6040,cp2));
		Operation op6 = operationRepository.save(new Retrait(new Date(),2040,cp2));	
	}

}
