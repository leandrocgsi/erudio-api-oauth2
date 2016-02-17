package br.com.erudio.utils

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
	
	
}
