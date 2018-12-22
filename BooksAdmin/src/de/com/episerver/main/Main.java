package de.com.episerver.main;

import de.com.episerver.controll.PrintInformations;
import de.com.episerver.dataBase.Datas;
import de.com.episerver.dataBase.ImportDatas;

public class Main {
	
	public static void main(String[] args) {
		try {
			ImportDatas importDatas = new ImportDatas();
			Datas datas = importDatas.importDocs();
			PrintInformations print = new PrintInformations(datas);
			//print.listAllBooksMagazines();
			print.printBooksMagazinesAutors("pr-rabe@optivo.de");
			print.printBooksMagazinesIsbn("5554-5545-4518");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
