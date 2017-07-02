package czaspracy;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
	
	ArrayList<File> files;

	
	public FileLoader(){
		files = new ArrayList<>();
	}
	public ArrayList<File> getFiles(String directoryPath) {

		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();
		
	
		for(File file : listOfFiles) {
	
			if(file.isFile() & file.getName().contains(".xls")){
				files.add(file);
				System.out.println("Dodaje do listy plik " + file.getName());
			}
			else if (file.isDirectory()){
				getFiles(file.getAbsolutePath());
			}
			
		}
		return files;
	}

}
