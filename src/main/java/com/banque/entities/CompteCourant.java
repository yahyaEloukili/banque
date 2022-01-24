package com.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private double decouvert;
	
	
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompteCourant(String codeCompte, Date datecreation, double solde, Client client, double decouvert) {
		super(codeCompte, datecreation, solde, client);
		this.decouvert = decouvert;
	}
	
	
}
