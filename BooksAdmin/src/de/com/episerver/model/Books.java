package de.com.episerver.model;

import java.util.ArrayList;

public class Books {

	private String title;
	private String isbnNumber;
	private ArrayList<Autors> listAutors;
	private String description;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public ArrayList<Autors> getListAutors() {
		return listAutors;
	}

	public void setListAutors(ArrayList<Autors> listAutors) {
		this.listAutors = listAutors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
