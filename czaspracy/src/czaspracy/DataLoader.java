package czaspracy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
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

	public ArrayList<Record> getData(String path) throws IOException {
		//
		DataLoader rFile = new DataLoader();
		FileLoader fLoader = new FileLoader();
		//ArrayList<File> myFiles = fLoader.getFiles(System.getProperty("user.dir"));
		ArrayList<File> myFiles = fLoader.getFiles(path);
		rFile.readData(myFiles);
		//readData(myFiles);
		return rFile.recordList;
	}	

	@SuppressWarnings("deprecation")
	private void readFile(File dataFile) {
        InputStream inp;
        try {
            inp = new FileInputStream(dataFile);
            HSSFWorkbook wb;
            try {
                wb = new HSSFWorkbook(new POIFSFileSystem(inp));
                for (Sheet sheet : wb) { // petla po arkuszach
                    for (Row row : sheet) { // petla po wierszach
                        if (row.getRowNum() == 0) {
                            continue; // pomija naglowek
                        }
                        
                        if (row.getCell(0) == null || row.getCell(1) == null || row.getCell(2)  == null ) {
                            continue; // pomija puste komorki
                        }

                        Record r = new Record();
                        r.setProject(sheet.getSheetName());

                        String name = dataFile.getName();
                        int indexDot = name.indexOf(".");
                        
                        name = name.substring(0, indexDot);
                        name = name.replace("_"," ");
                        r.setName(name);

                        if(row.getCell(1).getCellTypeEnum().getCode() == 1 ){
							r.setTaskName(row.getCell(1).getStringCellValue());
						}
						else
						{
						System.out.println("\n\n\nFormat komentarza nie jest poprawny w komórce " + row.getCell(1).getAddress().toString() + ", w arkuszu " + sheet.getSheetName() + ", w pliku " + dataFile.getName()); 
						}
						if(row.getCell(2).getCellTypeEnum().getCode() == 0 && row.getCell(2).getNumericCellValue() > 0 && row.getCell(2).getNumericCellValue() < 240 ){
						r.setTaskDuration(row.getCell(2).getNumericCellValue());
						}
						else 
						{ 
							System.out.println("\n\n\nFormat godzin nie jest poprawny w komórce " + row.getCell(2).getAddress().toString() + ", w arkuszu " + sheet.getSheetName() + ", w pliku " + dataFile.getName());  
						}
                       r.setTaskName(row.getCell(1).getStringCellValue());
                        r.setTaskDuration(row.getCell(2).getNumericCellValue());

                        Calendar cal = Calendar.getInstance();
                        cal.setTime(row.getCell(0).getDateCellValue());

                        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
                        String month = Integer.toString(cal.get(Calendar.MONTH)+1);
                        String year = Integer.toString(cal.get(Calendar.YEAR));

                        r.setDay(day);
                        r.setMonth(month);
                        r.setYear(year);

                        recordList.add(r);
                        //r.printRecord();

                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}