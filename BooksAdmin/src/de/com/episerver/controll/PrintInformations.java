package de.com.episerver.controll;

import java.text.SimpleDateFormat;

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
	
	public void listAllBooksMagazines(){
		
		for (Books books : getDatas().getListBooks()) {
			printDataBook(books);
		}
		
		for (Magazines magazines : getDatas().getListMagazines()) {
			printDataMagazine(magazines);
		}
	}
	
	public void printBooksMagazinesAutors(String emailAutor){
		
		for (Books books : getDatas().getListBooks()) {
			for (Autors autors : books.getListAutors()) {
				if	(autors.getEmail().equalsIgnoreCase(emailAutor)){
					System.out.println(books.getTitle());
					break;
				}
			}
		}
		
		for (Magazines magazines : getDatas().getListMagazines()) {
			for (Autors autors : magazines.getListAutors()) {
				if	(autors.getEmail().equalsIgnoreCase(emailAutor)){
					System.out.println(magazines.getTitle());
					break;
				}
			}
		}
		
	}
	
	public void printBooksMagazinesIsbn(String isbnNumber){
		
		for (Books books : getDatas().getListBooks()) {
			if	(books.getIsbnNumber().equalsIgnoreCase(isbnNumber)){
				System.out.println(books.getTitle());
			}
		}
		
		for (Magazines magazines : getDatas().getListMagazines()) {
			if	(magazines.getIsbnNumber().equalsIgnoreCase(isbnNumber)){
				System.out.println(magazines.getTitle());
			}
		}
		
	}
	
	private void printDataBook(Books books){
		System.out.println(books.getTitle());
		System.out.println(books.getIsbnNumber());
		System.out.println(books.getDescription());
		String autorsEmails = "";
		for (Autors autors : books.getListAutors()) {
			autorsEmails += " " + autors.getEmail();
		}
		System.out.println(autorsEmails);
	}
	
	private void printDataMagazine(Magazines magazines){
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(magazines.getTitle());
		System.out.println(magazines.getIsbnNumber());
		String autorsEmails = "";
		for (Autors autors : magazines.getListAutors()) {
			autorsEmails += " " + autors.getEmail();
		}
		System.out.println(autorsEmails);
		
		System.out.println(format1.format(magazines.getReleaseDate().getTime()));
	}

}
