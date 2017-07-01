package czaspracy;

import java.util.ArrayList;

public class App {
	
	ArrayList<Record> data;
	
	public static void main(String[] args){
		
		App app = new App();
		app.start();
		
		
	}
	
	
	private void start(){
		
		DataLoader dataLoader  = new DataLoader();
		
		if(dataLoader.getData() != null){
			System.out.println("Dane zostały poprawnie wczytane.");
		//	data = dataLoader.getData();
			data = new ArrayList<Record>();
			data.add(new Record("Kowalski","analiza","analiza danych","1","12","2016", 2));
			data.add(new Record("Nowak","analiza","analiza danych","1","12","2016", 3));
			data.add(new Record("Nowak","analiza","analiza danych","2","12","2016", 3));
			//test
			
		    Menu menu = new Menu(data);
		    
		    
		    
			menu.start();
		}else{
			
			System.out.println("Dane nie zostały poprawnie wczytane.");
		}
				
	}
	
	
	
	

}
