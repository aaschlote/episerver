package de.com.episerver.dataBase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import de.com.episerver.model.Autors;
import de.com.episerver.model.Books;
import de.com.episerver.model.Magazines;

public class ImportDatas {
	
	private Datas datas = new Datas();
	private static String caracter = ";";
	
	public Datas importDocs() throws Exception{
		ZipFile zipFile = new ZipFile("data.zip");
		ZipEntry autorsFile = zipFile.getEntry("data/autoren.csv");
		ZipEntry booksFile = zipFile.getEntry("data/buecher.csv");
		ZipEntry magazinesFile = zipFile.getEntry("data/zeitschriften.csv");
		
		importAutors(zipFile, autorsFile);
		importBooks(zipFile, booksFile);
		importMagazines(zipFile, magazinesFile);
		
		
		
		return getDatas();
	}
	
	private void importAutors(ZipFile zipFile, ZipEntry file) throws Exception {
		BufferedReader br = null;
		String line = "";
		br = new BufferedReader(new InputStreamReader(zipFile.getInputStream(file), "UTF-8"));
		br.readLine();
		ArrayList<Autors> listAutors = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			
			Autors autors = new Autors();

			String[] info = line.split(caracter);
			autors.setEmail(info[0]);
			autors.setFirstName(info[1]);
			autors.setSurname(info[2]);
			listAutors.add(autors);
		}
		
		getDatas().setListAutors(listAutors);
	}
	
	private void importBooks(ZipFile zipFile, ZipEntry file) throws Exception {
		BufferedReader br = null;
		String line = "";
		br = new BufferedReader(new InputStreamReader(zipFile.getInputStream(file), "UTF-8"));
		br.readLine();
		ArrayList<Books> listBooks = new ArrayList<>() ;
		while ((line = br.readLine()) != null) {
			
			Books books = new Books();

			String[] info = line.split(caracter);
			books.setTitle(info[0]);
			books.setIsbnNumber(info[1]);
			books.setDescription(info[3]);
			books.setListAutors(getDatas().findAutors(info[2]));
			listBooks.add(books);
		}
		
		getDatas().setListBooks(listBooks);
	}
	
	private void importMagazines(ZipFile zipFile, ZipEntry file) throws Exception {
		BufferedReader br = null;
		String line = "";
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		br = new BufferedReader(new InputStreamReader(zipFile.getInputStream(file), "UTF-8"));
		br.readLine();
		ArrayList<Magazines> listMagazines = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			
			Magazines magazines = new Magazines();

			String[] info = line.split(caracter);
			magazines.setTitle(info[0]);
			magazines.setIsbnNumber(info[1]);
			magazines.setListAutors(getDatas().findAutors(info[2]));
			
			if (!info[3].equalsIgnoreCase("")) {
				Calendar realeaseDataCal = Calendar.getInstance();
				Date realeaseDate = format.parse(info[3]);
				realeaseDataCal.setTime(realeaseDate);
				magazines.setReleaseDate(realeaseDataCal);
			}
			
			listMagazines.add(magazines);
			
		}
		
		getDatas().setListMagazines(listMagazines);
	}

	public Datas getDatas() {
		return datas;
	}	
	
}
