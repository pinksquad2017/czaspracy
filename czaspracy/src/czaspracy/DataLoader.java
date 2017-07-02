package czaspracy;

import java.util.ArrayList;
import java.util.Calendar;

//ładowanie danych z pliku źródłowego do lokalnej bazy

//public class DataLoader {
//
//	
//	
//	public DataLoader(){
//		
//	}
//	
//	public ArrayList<Record> getData(){
//		
//		return new ArrayList<Record>();
//	}
//	
//	
//	
//	
//	
//	
//	
//}


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

public class DataLoader {

//	public static void main(String[] args) throws IOException {
//		DataLoader rFile = new DataLoader();
//		ArrayList<File> myFiles = new ArrayList();
//		myFiles.add(new File("Kowalski_Jan.xls"));
//		rFile.readData(myFiles);
//	}

	ArrayList<Record> recordList = new ArrayList<Record>();
	// Model model;

	public DataLoader() {
		// model = new Model();
	}

	public void readData(List<File> files) throws IOException {
		for (File file : files) {
			readFile(file);
		}
	}
	
	public ArrayList<Record> getData() throws IOException{
		// 
		DataLoader rFile = new DataLoader();
		FileLoader fLoader = new FileLoader();
		ArrayList<File> myFiles = fLoader.getFiles(System.getProperty("user.dir"));
		rFile.readData(myFiles);
		return recordList;
	}

	private void readFile(File dataFile) throws IOException {
		InputStream inp = new FileInputStream(dataFile);
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));

		for (Sheet sheet : wb) { // petla po arkuszach
			for (Row row : sheet) { // petla po wierszach
				if (row.getRowNum() == 0) {
					continue; // pomija naglowek
				} 
				try  {
					Record r = new Record();
					r.setProject(sheet.getSheetName());
					r.setName(dataFile.getName());

					r.setTaskName(row.getCell(1).getStringCellValue());
					r.setTaskDuration(row.getCell(2).getNumericCellValue());

					Calendar cal = Calendar.getInstance();
					cal.setTime(row.getCell(0).getDateCellValue());

					String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
					String month = Integer.toString(cal.get(Calendar.MONTH));
					String year = Integer.toString(cal.get(Calendar.YEAR));

					r.setDay(day);
					r.setMonth(month);
					r.setYear(year);

					recordList.add(r);
					r.printRecord();
					
				} finally {
				}

//				for (Cell cell : row) {
//
//					System.out.println(cell);

			//	}
			}
		}
	}
}
