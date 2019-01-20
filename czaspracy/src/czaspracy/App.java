package czaspracy;

import java.io.IOException;
import java.util.ArrayList;

public class App {

	ArrayList<Record> data;

	public static void main(String[] args) throws IOException {

		App app = new App();
		app.start();

	}

	private void start() throws IOException {

		DataLoader dataLoader = new DataLoader();

		if (dataLoader.getData() != null) {
			System.out.println("Dane zostaly poprawnie wczytane.");

			data = dataLoader.getData();
			Menu menu = new Menu(data);
			menu.start();

		} else {

			System.out.println("Dane nie zostaly poprawnie wczytane.");
		}

	}

}
