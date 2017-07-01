package czaspracy;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
	
	List<File> files;

	
	public FileLoader(){
		files = new ArrayList<>();
	}
	public List<File> getFiles(String directoryPath) {

		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();
		
	
		for(File file : listOfFiles) {
	
			if(file.isFile() & file.getName().contains(".xls")){
				files.add(file);
			}
			else if (file.isDirectory()){
				getFiles(file.getAbsolutePath());
			}
			files.add(file);
			System.out.println("Dodaje do listy plik " + file.getName());
		}
		return files;
	}

}
