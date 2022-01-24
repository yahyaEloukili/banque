package com.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.entities.Client;
import com.banque.entities.Compte;
import com.banque.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

	
}
