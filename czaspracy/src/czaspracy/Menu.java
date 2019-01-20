package czaspracy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

	private ArrayList<Record> data;
	private int choice;
	private Scanner scanner;

	public Menu(ArrayList<Record> data) {
		this.data = data;
	}

	public void start() {
		System.out.println("Wybierz opcje:\n\n" 
				+ "1. Zestawienie per pracownik\n" 
				+ "2. Zestawienie per projekt\n"
				+ "3. Pojedynczy pracownik - szczegoly\n" 
				+ "4. Pracownik w projektach - udzial\n"
				+ "5. Wyjscie z programu");

		scanner = new Scanner(System.in);
		try {
			choice = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Wybierz poprawna opcje pomiedzy 1 a 5\n");
			this.start();
		}

		switch (choice) {

		case 1:
			System.out.println("Wybrano opcje " + choice);
			this.option1();
			start();
		case 2:
			System.out.println("Wybrano opcje " + choice);
			this.option2();
			start();
		case 3:
			System.out.println("Wybrano opcje " + choice);
			this.option3();
			start();
		case 4:
			System.out.println("Wybrano opcje " + choice);
			this.option4();
			start();
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("Wybierz poprawna opcje pomiedzy 1 a 5\n");
			this.start();

		}

	}

	// summary per employee
	private void option1() {

		Map<String, Double> result = data.stream()
				.collect(Collectors.groupingBy(Record::getName, Collectors.summingDouble(Record::getTaskDuration)));
		// System.out.println(result);

		result.forEach((k, v) -> {

			System.out.println(k + " " + v + " h");
		});
	}

	private void option2() {

		Map<String, Double> result = data.stream()
				.collect(Collectors.groupingBy(Record::getProject, Collectors.summingDouble(Record::getTaskDuration)));
		// System.out.println(result);

		result.forEach((k, v) -> {

			System.out.println(k + " " + v + " h");
		});
	}

	private void option3() {

		System.out.println("Podaj poprawnie Nazwisko_Imie pracownika:\n");
		String name = scanner.next();

		for (Record record : data) {
			if (record.getName().equals(name))
				System.out.println(record.getTaskName() + " " + record.getTaskDuration() + " h");
		}

	}

	private void option4() {

		System.out.println("Podaj poprawnie Nazwisko_Imie pracownika:\n");
		String name = scanner.next();
		HashSet<String> projects = new HashSet<String>();

		for (Record record : data) {
			if (record.getName().equals(name))
				projects.add(record.getProject());
		}

		for (String string : projects) {
			System.out.println(string);
		}

	}
}
