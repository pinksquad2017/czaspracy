package czaspracy;

import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class DataLoader {

	ArrayList<Record> recordList;

	public DataLoader() {
		recordList = new ArrayList<Record>();
	}

	public void readData(List<File> files) throws IOException {
		for (File file : files) {
			readFile(file);
		}
	}

	public ArrayList<Record> getData() throws IOException {
		DataLoader rFile = new DataLoader();
		FileLoader fLoader = new FileLoader();
		ArrayList<File> myFiles = fLoader.getFiles(System.getProperty("user.dir"));
		rFile.readData(myFiles);
		return rFile.recordList;
	}

	private void readFile(File dataFile) {
		InputStream inp;
		try {
			inp = new FileInputStream(dataFile);
			HSSFWorkbook wb;
			try {
				wb = new HSSFWorkbook(new POIFSFileSystem(inp));
				for (Sheet sheet : wb) { // iterating through sheets
					for (Row row : sheet) { // iterating through rows
						if (row.getRowNum() == 0) {
							continue; // skip headline
						}
						if (row.getCell(0) == null || row.getCell(1) == null || row.getCell(2) == null) {
							continue;
						}
						Record r = new Record();
						r.setProject(sheet.getSheetName());
						r.setName(dataFile.getName().substring(0, dataFile.getName().length() - 4));
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
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
