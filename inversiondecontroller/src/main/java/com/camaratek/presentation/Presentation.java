package com.camaratek.presentation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.camaratek.dao.contrat.Idao;
import com.camaratek.dao.impl.IdaoImpl;
import com.camaratek.metier.contrat.IMetier;
import com.camaratek.metier.impl.MetierImpl;

public class Presentation {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
	IllegalAccessException, NoSuchMethodException, SecurityException {
		
		//IdaoImpl idao = new IdaoImpl();
		
		//MetierImpl metierImpl = new MetierImpl();
		
		//metierImpl.setIdao(idao);
		
		//System.out.println( metierImpl.calcul() );
		
		 
		try {
			Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/config.txt")));
			String daoClassName = scanner.next();
			String metierClassName = scanner.next();
			//System.out.println( daoClassName + " \n" + metierClassName );
			
			Class cDao = Class.forName(daoClassName);
			Idao dao = (Idao) cDao.newInstance();
			System.out.println( dao.getValue() );
			
			Class cMetier = Class.forName(metierClassName);
			IMetier metier =(MetierImpl) cMetier.newInstance();
			
			Method m1 = cMetier.getMethod("setIdao", new Class [] { Idao.class });
			m1.invoke(metier, new Object[] {dao} );
			
			System.out.println( metier.puis() );
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
