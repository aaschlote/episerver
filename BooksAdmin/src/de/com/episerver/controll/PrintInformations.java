package de.com.episerver.controll;

import java.util.Collections;

import de.com.episerver.dataBase.Datas;
import de.com.episerver.model.Autors;
import de.com.episerver.model.Books;
import de.com.episerver.model.Magazines;

public class PrintInformations {

	private Datas datas;

	public PrintInformations(Datas datas) {
		super();
		this.datas = datas;
	}

	public Datas getDatas() {
		return datas;
	}

	public String listAllBooksMagazines() {

		String infoReturn = "";
		
		for (Books books : getDatas().getListBooks()) {
			infoReturn += books.toString() + " \n";
		}

		for (Magazines magazines : getDatas().getListMagazines()) {
			infoReturn += magazines.toString() + " \n";
		}
		
		return infoReturn;
	}

	public String printBooksMagazinesAutors(String emailAutor) {

		String infoReturn = "";
		
		for (Books books : getDatas().getListBooks()) {
			for (Autors autors : books.getListAutors()) {
				if (autors.getEmail().equalsIgnoreCase(emailAutor)) {
					infoReturn += books.getTitle() + " \n";
					break;
				}
			}
		}

		for (Magazines magazines : getDatas().getListMagazines()) {
			for (Autors autors : magazines.getListAutors()) {
				if (autors.getEmail().equalsIgnoreCase(emailAutor)) {
					infoReturn += magazines.getTitle() + " \n";
					break;
				}
			}
		}
		
		return infoReturn;

	}

	public String printBooksMagazinesIsbn(String isbnNumber) {

		String infoReturn = "";
		
		for (Books books : getDatas().getListBooks()) {
			if (books.getIsbnNumber().equalsIgnoreCase(isbnNumber)) {
				infoReturn += books.getTitle() + " \n";
			}
		}

		for (Magazines magazines : getDatas().getListMagazines()) {
			if (magazines.getIsbnNumber().equalsIgnoreCase(isbnNumber)) {
				infoReturn += magazines.getTitle() + " \n";
			}
		}
		
		return infoReturn;

	}

	public String printSortData() {
		
		String infoReturn = "";
		
		Collections.sort(getDatas().getListBooks());
		Collections.sort(getDatas().getListMagazines());

		for (Books books : getDatas().getListBooks()) {
			infoReturn += books.getTitle() + " \n";
		}
		
		for (Magazines magazines : getDatas().getListMagazines()) {
			infoReturn +=  magazines.getTitle() + " \n";
		}
		
		return infoReturn;

	}
	
	

}
