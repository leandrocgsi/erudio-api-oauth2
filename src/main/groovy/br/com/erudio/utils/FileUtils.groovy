package br.com.erudio.utils

import java.io.File;

class FileUtils {

	def copyFile(String filePath, String fileDestinationPath){
		def fileSourceStream = new File(filePath).newDataInputStream()
		writeFile(fileDestinationPath, fileSourceStream);
		fileSourceStream.close()
	}
	
	def printFile(String filePath){
		new FileInputStream( new File(filePath) ).eachLine { println it }
	}
	
	def String fileToString(String filePath){
		def fileSourceStream = new File(filePath).newDataInputStream();
		fileSourceStream.getText();
		fileSourceStream.close()
	}
	
	def writeFile(String fileDestinationPath, byte[] stream){
		def fileDestinationStream = new File(fileDestinationPath).newDataOutputStream();
		fileDestinationStream << stream;
		fileDestinationStream.close();
	}

	def getBytesFromFile(File file) {
		InputStream inputStream = null;
		byte[] buffer = null;
		try {
			inputStream = new FileInputStream(file);
			buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffer;
	}
}
