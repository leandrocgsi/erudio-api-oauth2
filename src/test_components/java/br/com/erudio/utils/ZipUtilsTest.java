package br.com.erudio.utils;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ZipUtilsTest {
	
	ZipUtils zipUtils = new ZipUtils();
	
	@Before
	public void setup() {
	}
	
	@Test
	public void zipFileTest() {
		zipUtils.zipFile(System.getProperty("user.dir") + "\\target\\teste2.zip");
	}

}
