package czaspracy;

import java.io.IOException;
import java.util.ArrayList;
import czaspracy.FileLoader;
public class App {
	
	ArrayList<Record> data;
	
	public static void main(String[] args) throws IOException{
		
		 
		App app = new App();
		FileLoader.getCatalogYears(args[0]);
		app.start(args[0]);
		
		
	}
	
	
	private void start(String path) throws IOException{
		
		
		DataLoader dataLoader  = new DataLoader();
		
		if(dataLoader.getData(path) != null){
			System.out.println("Dane zostały poprawnie wczytane.\n");
		
			data = dataLoader.getData(path);
			Menu menu = new Menu(data);
			menu.start();
			
		}else{
			
			System.out.println("Dane nie zostały poprawnie wczytane.\n");
		}
				
	}
	
	
	
	

}
