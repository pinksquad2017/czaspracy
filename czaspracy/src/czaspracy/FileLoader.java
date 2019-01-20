package czaspracy;

import java.io.File;
import java.util.ArrayList;

public class FileLoader {

	ArrayList<File> files;
	static ArrayList<String> catalogYear = new ArrayList<String>();

	public FileLoader() {
		files = new ArrayList<>();
	}

	public static String getCatalogYears(String directoryPath) {

		File folder = new File(directoryPath);

		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				catalogYear.add(file.getName().toString());
			}
		}
		String formatedCatalogYear = catalogYear.toString();
		formatedCatalogYear = formatedCatalogYear.substring(1, formatedCatalogYear.length() - 1);
		System.out.println("Dane zostaly zaladowane dla nastepujacych lat: " + formatedCatalogYear);
		return formatedCatalogYear;

	}

	public ArrayList<File> getFiles(String directoryPath) {
		// System.out.println(directoryPath);
		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {

			if (file.isFile() & file.getName().contains(".xls")) {
				files.add(file);
				System.out.println("Dodaje do listy plik " + file.getName());
			} else if (file.isDirectory()) {
				getFiles(file.getAbsolutePath());
			}
		}
		return files;
	}

}
