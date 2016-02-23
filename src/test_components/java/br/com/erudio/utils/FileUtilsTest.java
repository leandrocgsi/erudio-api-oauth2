package br.com.erudio.utils;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.erudio.utils.FileUtils;

@Ignore
public class FileUtilsTest {
	
	FileUtils fileUtils = new FileUtils();
	
	@Before
	public void setup() {
	}
	
	@Test
	public void copyFileTest() {
		fileUtils.copyFile("C://Users//LEANDRO//Desktop//pom2.xml", "C://Users//LEANDRO//Desktop//COPY//copied.xml");
	}
	
	@Test
	public void printFileTest() {
		fileUtils.printFile("C://Users//LEANDRO//Desktop//pom2.xml");
	}
	
	@Test
	public void fileToStringTest() {
		System.out.println(fileUtils.fileToString("C://Users//LEANDRO//Desktop//pom2.xml"));
	}
	
	@Test
	public void writeFileTest() {
		fileUtils.writeFile("C://Users//LEANDRO//Desktop//teste.txt", "This is the content of the first file".getBytes());
	}

}
