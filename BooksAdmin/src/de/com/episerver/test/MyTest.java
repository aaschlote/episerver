package de.com.episerver.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.com.episerver.controll.PrintInformations;
import de.com.episerver.dataBase.Datas;
import de.com.episerver.dataBase.ImportDatas;

public class MyTest {

	private String returnDoc = "";
	private Datas datas = null;

	@Before
	public void executedBeforeEach() {
		ImportDatas importDatas = new ImportDatas();
		this.returnDoc = importDatas.importDocs();
		this.datas = importDatas.getDatas();
	}

	@Test
	public void importFile() {
		assertEquals("SUCCESS", this.returnDoc);
	}
	
	@Test
	public void testAllDatasDoc() {
		
		PrintInformations print = new PrintInformations(this.datas);
		String returnAllDatas = print.listAllBooksMagazines();
		assertNotNull(returnAllDatas);
	}
	
	@Test
	public void testEmailAutor() {
		
		PrintInformations print = new PrintInformations(this.datas);
		String returnEmail = print.printBooksMagazinesAutors("pr-rabe@optivo.de");
		
		String expected = "Das Piratenkochbuch. Ein Spezialitätenkochbuch mit den 150 leckersten Rezepten Genial italienisch";
		
		assertEquals(expected, returnEmail);
	}
	
	@Test
	public void testIsbnAutor() {
		
		PrintInformations print = new PrintInformations(this.datas);
		String returnIsbn = print.printBooksMagazinesIsbn("5554-5545-4518");
		
		String expected = "Ich helf dir kochen. Das erfolgreiche Universalkochbuch mit großem Backteil";
		
		assertEquals(expected, returnIsbn);
	}

}
