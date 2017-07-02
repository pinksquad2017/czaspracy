package czaspracy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

	private ArrayList<Record> data;
	private int choice;
	private Scanner scanner;
	
	public Menu(ArrayList<Record> data){
		
		this.data = data;
	}
	
	public void start(){
		
		
		System.out.println("\n\nWybierz opcję:\n\n"
				+ "1. Zestawienie per pracownik\n"
				+ "2. Zestawienie per projekt\n"
				+ "3. Pojedynczy pracownik - szczegóły\n"
				+ "4. Pracownik w projektach - udział %\n\n"
				+ "5. Wyjście z programu");
		
		scanner = new Scanner(System.in);
		try{
		choice = scanner.nextInt();
		}catch(Exception e){
			System.out.println("Wybierz poprawną opcję pomiędzy 1 a 5\n");
			this.start();
		}
		
		switch (choice){
		
		case 1:
			System.out.println("Wybrano opcję " + choice);
			this.option1();
			break;
		case 2:
			System.out.println("Wybrano opcję " + choice);
			this.option2();
			break;
		case 3:
			System.out.println("Wybrano opcję " + choice);
			this.option3();
			break;
		case 4:
			System.out.println("Wybrano opcję " + choice);
			this.option4();
			break;
		case 5:
			System.exit(0);
			break;
		default:
				System.out.println("Wybierz poprawną opcję pomiędzy 1 a 5\n");
				this.start();
				
		}
		
	}
	
	//zestawienie per pracownik
	private void option1(){
		
		System.out.println("Podaj rok:\n");
		String year = scanner.next();
		
		Map<String, Double> result = data.stream()
				.filter(y -> y.getYear().equals(year))
				.sorted((r1, r2)->r1.getName().
                        compareTo(r2.getName()))
				.collect(Collectors.groupingBy(Record::getName, Collectors.summingDouble(Record::getTaskDuration)));
		
		System.out.println(Formatter.padRight("Pracownik", 20, ' ') + Formatter.padRight("Ilość godzin", 20, ' '));
		result.forEach((k,v) -> {
			
			System.out.println(Formatter.padRight(k, 20, ' ') + "      " + v);
		});
		
		ResultExporter.exportToHtml1(result);
		
				
	}
	
	private void option2(){
		
		System.out.println("Podaj rok:\n");
		String year = scanner.next();
		
		Map<String, Double> result = data.stream()
				.filter(y -> y.getYear().equals(year))
				.sorted((r1, r2)->r1.getProject().
                        compareTo(r2.getProject()))
				.collect(Collectors.groupingBy(Record::getProject, Collectors.summingDouble(Record::getTaskDuration)));
		
		System.out.println(Formatter.padRight("Nazwa projektu", 20, ' ') + Formatter.padRight("Ilość godzin", 20, ' '));
		
		result.forEach((k,v) -> {
			
			System.out.println(Formatter.padRight(k, 20, ' ') + "      " + v);
		});
		
		ResultExporter.exportToHtml2(result);
		
		
	}
	
	private void option3(){
		
		//name, project,task duration
		System.out.println("Podaj nazwisko pracownika:");
		String last  = scanner.next();
		
		System.out.println("Podaj imię pracownika:");
		String first = scanner.next();
		
		String name = last + " " + first;
		
		
		Map<String,Map<String,Double>>  result = data.stream()
				.filter(r -> r.getName().equals(name))
				.collect(Collectors.groupingBy(Record::getMonth, Collectors.groupingBy(Record::getProject,Collectors.summingDouble(Record::getTaskDuration))));
		
		System.out.println(
				"Podsumowanie dla: " + name + "\n"
				+ Formatter.padRight("Miesiąc", 20, ' ') 
				+ Formatter.padRight("Nazwa projektu", 20, ' ') 
				+ Formatter.padRight("Ilość godzin", 20, ' '));
		
		result.forEach((k1,v1) -> { 
			
		System.out.println(Formatter.padRight(k1, 20, ' '));
			v1.forEach((k2,v2) -> {
				System.out.println("                       " + Formatter.padRight(k2, 15, ' ') + "      " + v2);
				
			});
		});
		
		ResultExporter.exportToHtml3(result);
		
	}
	private void option4(){
		
		//name, project, %time
		
		System.out.println("Podaj nazwisko pracownika:");
		String last  = scanner.next();
		
		System.out.println("Podaj imię pracownika:");
		String first = scanner.next();
		
		String name = last + " " + first;
		
		Map<String, Double> projectDuration = data.stream()
				.sorted((r1, r2)->r1.getProject().
                        compareTo(r2.getProject()))
				.collect(Collectors.groupingBy(Record::getProject, Collectors.summingDouble(Record::getTaskDuration)));
		
		
		Map<String,Map<String,Double>>  result = data.stream()
				.filter(r -> r.getName().equals(name))
				.collect(Collectors.groupingBy(Record::getName, Collectors.groupingBy(Record::getProject,Collectors.summingDouble(Record::getTaskDuration))));
		
		System.out.println(
				"Podsumowanie dla: " + name + "\n"
				+ Formatter.padRight("Projekt", 20, ' ') 
				+ Formatter.padRight("Zaangażowanie procentowe", 20, ' '));
		
		result.forEach((k1,v1) -> { 
			
				v1.forEach((k2,v2) -> {
					System.out.println(Formatter.padRight(k2, 20, ' ') + "      " + Math.round(((v2/projectDuration.get(k2)))*100 *100)/100+ "%");							
				});
			});
		
		
	
			
	}
}




















