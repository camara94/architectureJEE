package com.camaratek.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.camaratek.metier.contrat.IMetier;

public class PresentationV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
		IMetier iMetier = (IMetier) context.getBean("metier");
		
		System.out.println( iMetier.calcul() );
	}

}
