package de.com.episerver.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

public class Magazines implements Comparable<Magazines> {
	
	private String title;
	private String isbnNumber;
	private ArrayList<Autors> listAutors;
	private Calendar releaseDate;
	
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

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
		String emails = "";
		for (Autors autors : listAutors) {
			emails += " " + autors.getEmail();
		}

		return this.title + " " + this.isbnNumber + " " + emails + " "
				+ format1.format(this.releaseDate.getTime());
	}

	@Override
	public int compareTo(Magazines o) {
		return getTitle().compareTo(o.getTitle());
	}

}
