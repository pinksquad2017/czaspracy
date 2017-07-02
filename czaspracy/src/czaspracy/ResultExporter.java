package czaspracy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResultExporter {

	public static void exportToHtml(Map<String,Double> result) {
		File file = new File("report.html");

		
		try {
			// creates the file
			file.createNewFile();

			// creates a FileWriter Object
			FileWriter writer;
			writer = new FileWriter(file);
			// Writes the content to the file
			writer.write("<!DOCTYPE html>");
			writer.write("<html lang='pl'>");
			writer.write("<head>");
			writer.write("<meta charset='UTF-8'>");
			writer.write("<title>Raport dla opcji 1</title>");
			writer.write("<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>'");
			writer.write("</head>");
			writer.write("<body>");
			
			writer.write("<table class='table table-bordered table-striped'>");
			writer.write("<tr>");
			writer.write("<th>Pracownik</th>");
			writer.write("<th>Czas pracy</th>");
			writer.write("</tr>");
					
	
			
			//generate table body
			for (Map.Entry<String, Double> entry : result.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
				writer.write("<tr>");
				writer.write("<td>"+ entry.getKey()+"</td>");
				writer.write("<td> "+ entry.getValue()+"</td>");
			writer.write("</tr>");
			}
			
			writer.write("</table>");
			writer.write("</body>");
			writer.write("</html>");
			
			
			
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Creates a FileReader Object
		Map<String, Double> result = new HashMap<String,Double>();
		result.put("Anna Nowak", 4.0);
		result.put("Anna Kowalska", 8.0);
		result.put("Anna Nowak", 4.0);
		ResultExporter.exportToHtml(result); // reads the content to the array
		System.out.println("done");

	}

}