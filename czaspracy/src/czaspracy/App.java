package czaspracy;
import czaspracy.FileLoader;
import java.util.ArrayList;
public class App {
	
	ArrayList<Record> data;
	
	public static void main(String[] args){
		
		App app = new App();
		app.start();
		FileLoader.getCatalogYears(".//");
		
	}
	
	
	private void start(){
		
		DataLoader dataLoader  = new DataLoader();
		
		if(dataLoader.getData() != null){
			System.out.println("Dane zostały poprawnie wczytane.");
		
			data = dataLoader.getData();
			Menu menu = new Menu(data);
			menu.start();
			
		}else{
			
			System.out.println("Dane nie zostały poprawnie wczytane.");
		}
				
	}
	
	
	
	

}
