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
		fileUtils.copyFile(System.getProperty("user.dir") + "\\target\\pom2.xml", System.getProperty("user.dir") + "\\target\\COPY//copied.xml");
	}
	
	@Test
	public void printFileTest() {
		fileUtils.printFile(System.getProperty("user.dir") + "\\target\\pom2.xml");
	}
	
	@Test
	public void fileToStringTest() {
		System.out.println(fileUtils.fileToString(System.getProperty("user.dir") + "\\target\\pom2.xml"));
	}
	
	@Test
	public void writeFileTest() {
		fileUtils.writeFile(System.getProperty("user.dir") + "\\target\\teste.txt", "This is the content of the first file".getBytes());
	}

}
