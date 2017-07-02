package czaspracy;

import java.util.ArrayList;

//ładowanie danych z pliku źródłowego do lokalnej bazy

public class DataLoader {

	
	
	public DataLoader(){
		
	}
	
	public ArrayList<Record> getData(){
		
		return new ArrayList<Record>();
	}
	
	
	
	
	
	
	
}

/*
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

    public static void main(String[] args) throws IOException {
        DataLoader rFile = new DataLoader();
        ArrayList<File> myFiles = new ArrayList();
        myFiles.add(new File("Kowalski_Jan.xls"));
        rFile.readData(myFiles);
    }
    
    ArrayList<Record> recordList = new ArrayList<Record>();
    //Model model;
    
    public DataLoader() {
        //model = new Model();
    }
    
    public void readData(List<File> files) throws IOException {
        for (File file : files) {
            readFile(file);
        }
    }
    
    private void readFile(File dataFile) throws IOException {
        InputStream inp = new FileInputStream(dataFile);
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
        
        DataFormatter formatter = new DataFormatter();
        // iteracja po sheetach
        Sheet sheet1 = wb.getSheetAt(0);
            for (Row row : sheet1) {
                Record r = new Record();
                r.setProject(sheet1.getSheetName());
                r.setName(dataFile.getName());
                
            
                r.setTaskName(row.getCell(1).getStringCellValue());
                r.setTaskDuration(row.getCell(2).getNumericCellValue());
                // dodanie rekordu
                // ustawienie dat
                
                for (Cell cell : row) {
                    

                    // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                    String text = formatter.formatCellValue(cell);
                    System.out.println(text);

                    
                }
            }

    }

*/