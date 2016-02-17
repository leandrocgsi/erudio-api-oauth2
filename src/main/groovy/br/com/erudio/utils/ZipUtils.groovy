package br.com.erudio.utils;

import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

class ZipUtils {
	
	def zipFile(String zipFile, byte[] ... stream) {
		
		FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
		ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
		
		def file1Entry = new ZipEntry('first_file.txt');
		zipOutputStream.putNextEntry(file1Entry);
		zipOutputStream.write("This is the content of the first file".bytes);
		def file2Entry = new ZipEntry('second_file.txt');
		zipOutputStream.putNextEntry(file2Entry);
		zipOutputStream.write("This is the content of the second file".bytes);
		zipOutputStream.closeEntry();
		zipOutputStream.close();
	}

}
