package de.com.episerver.dataBase;

import java.util.ArrayList;

import de.com.episerver.model.Autors;
import de.com.episerver.model.Books;
import de.com.episerver.model.Magazines;

public class Datas {

	private static String caracter = ",";
	private ArrayList<Autors> listAutors = new ArrayList<>();
	private ArrayList<Books> listBooks = new ArrayList<>() ;
	private ArrayList<Magazines> listMagazines = new ArrayList<>();
	
	public ArrayList<Autors> getListAutors() {
		return listAutors;
	}
	
	public ArrayList<Books> getListBooks() {
		return listBooks;
	}
	
	public ArrayList<Magazines> getListMagazines() {
		return listMagazines;
	}

	public void setListAutors(ArrayList<Autors> listAutors) {
		this.listAutors = listAutors;
	}

	public void setListBooks(ArrayList<Books> listBooks) {
		this.listBooks = listBooks;
	}

	public void setListMagazines(ArrayList<Magazines> listMagazines) {
		this.listMagazines = listMagazines;
	}
	
	public ArrayList<Autors> findAutors(String email){
		ArrayList<Autors> listAutors2 = new ArrayList<>();
		
		String[] info = email.split(caracter);
		
		for (String autorEmail : info) {
			Autors autors = findAutors2(autorEmail);
			if	(autors != null){
				listAutors2.add(autors);
			}
		}
		
		return listAutors2;
	}
	
	public Autors findAutors2(String email){
		for (Autors autors : listAutors) {
			if	(autors.getEmail().equalsIgnoreCase(email)){
				return autors;
			}
		}
		
		return null;
	}

	
}
