package de.com.episerver.main;

import de.com.episerver.controll.PrintInformations;
import de.com.episerver.dataBase.Datas;
import de.com.episerver.dataBase.ImportDatas;

public class Main {
	
	public static void main(String[] args) {
		try {
			ImportDatas importDatas = new ImportDatas();
			importDatas.importDocs();
			Datas datas = importDatas.getDatas();
			PrintInformations print = new PrintInformations(datas);
			//print.listAllBooksMagazines();
			//System.out.println(print.printBooksMagazinesAutors("pr-rabe@optivo.de"));
			System.out.println(print.printBooksMagazinesIsbn("5554-5545-4518"));
			//System.out.println(print.printSortData());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
