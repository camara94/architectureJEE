package com.camaratek.metier.impl;

import com.camaratek.dao.contrat.Idao;
import com.camaratek.metier.contrat.IMetier;

public class MetierImpl implements IMetier {
	
	private Idao idao; 
	
	

	public void setIdao(Idao idao) {
		this.idao = idao;
	}


	public double calcul() {
		
		double nb = idao.getValue();
		
		return nb*10;
	}

}
