package czaspracy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ResultExporter {

	public static void exportToHtml1(Map<String,Double> result) {
		File file = new File("report1.html");

		
		try {
			// creates the file
			file.createNewFile();

			// creates a FileWriter Object
			FileWriter writer;
			writer = new FileWriter(file);
			// Writes the content to the file
		     writer.write(" <!DOCTYPE html>");
		      writer.write(" <html>");
		      writer.write(" <head>");
		      writer.write(" <title>raport</title>");
		      writer.write(" </head>");
		      writer.write(" <body style='background-color: HotPink;'>");
		      writer.write(" <h1 style= color:blue;> Raport czasu pracy</h1>");
		      writer.write(" <h2 style= color:blue;> Raport 1 - Alfabetyczny spis pracownikow </h2>");

		     
		      writer.write("<style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}");
		     
		      writer.write(".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;}");
		      writer.write(".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;}");
		      writer.write(".tg .tg-yw4l{vertical-align:top}");
		      writer.write("</style>");
		    		  writer.write("<table class='tg'>");
		    				  writer.write(" <tr>");
		    						  writer.write("  <th class='tg-yw4l'><b>Nazwisko i imię </b></th>");
		    						  writer.write("  <th class='tg-yw4l'><b>Liczba przepracowanych godzin</b></th>");
		    								  writer.write("</tr>");
		    								  
		    								//generate table body
		    									for (Map.Entry<String, Double> entry : result.entrySet()) {
		    										writer.write("<tr>");
		    										writer.write("<th class='tg-yw4l'>"+ entry.getKey()+"</th>");
		    										writer.write("<th class='tg-yw4l'> "+ entry.getValue()+"</th>");
		    									writer.write("</tr>");
		    									}
		    								  
		    								 
		    										  writer.write("</table>"); 
		    										  writer.write("</body>");
		        writer.write("</html>");								  
		      writer.flush();
		      writer.close();;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void exportToHtml2(Map<String,Double> result) {
	File file = new File("report2.html");

		
		try {
			// creates the file
			file.createNewFile();

			// creates a FileWriter Object
			FileWriter writer;
			writer = new FileWriter(file);
			// Writes the content to the file
		     writer.write(" <!DOCTYPE html>");
		      writer.write(" <html>");
		      writer.write(" <head>");
		      writer.write(" <title>raport</title>");
		      writer.write(" </head>");
		      writer.write(" <body style='background-color: HotPink;'>");
		      writer.write(" <h1 style= color:blue;> Raport czasu pracy</h1>");
		      writer.write(" <h2 style= color:blue;> Raport 1 - Alfabetyczny spis pracownikow </h2>");

		     
		      writer.write("<style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}");
		     
		      writer.write(".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;}");
		      writer.write(".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;}");
		      writer.write(".tg .tg-yw4l{vertical-align:top}");
		      writer.write("</style>");
		    		  writer.write("<table class='tg'>");
		    				  writer.write(" <tr>");
		    						  writer.write("  <th class='tg-yw4l'><b>Nazwa projektu </b></th>");
		    						  writer.write("  <th class='tg-yw4l'><b>Liczba godzin</b></th>");
		    								  writer.write("</tr>");
		    								  
		    								//generate table body
		    									for (Map.Entry<String, Double> entry : result.entrySet()) {
		    										writer.write("<tr>");
		    										writer.write("<th class='tg-yw4l'>"+ entry.getKey()+"</th>");
		    										writer.write("<th class='tg-yw4l'> "+ entry.getValue()+"</th>");
		    									writer.write("</tr>");
		    									}
		    								  
		    								 
		    										  writer.write("</table>"); 
		    										  writer.write("</body>");
		        writer.write("</html>");								  
		      writer.flush();
		      writer.close();;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void exportToHtml3(Map<String,Map<String,Double>> result) {
File file = new File("report3.html");

		
		try {
			// creates the file
			file.createNewFile();

			// creates a FileWriter Object
			FileWriter writer;
			writer = new FileWriter(file);
			// Writes the content to the file
		     writer.write(" <!DOCTYPE html>");
		      writer.write(" <html>");
		      writer.write(" <head>");
		      writer.write(" <title>raport</title>");
		      writer.write(" </head>");
		      writer.write(" <body style='background-color:powderpink;'>");
		      writer.write(" <h1 style= color:blue;> Raport czasu pracy</h1>");
		      writer.write(" <h2 style= color:blue;> Raport 1 - Alfabetyczny spis pracownikow </h2>");

		     
		      writer.write("<style type='text/css'>.tg  {border-collapse:collapse;border-spacing:0;}");
		     
		      writer.write(".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;}");
		      writer.write(".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;}");
		      writer.write(".tg .tg-yw4l{vertical-align:top}");
		      writer.write("</style>");
		    		  writer.write("<table class='tg'>");
		    				  writer.write(" <tr>");
		    						  writer.write("  <th class='tg-yw4l'><b>Miesiąc</b></th>");
		    						  writer.write("  <th class='tg-yw4l'><b>Nazwa projektu</b></th>");
		    						  writer.write("  <th class='tg-yw4l'><b>Liczba godzin</b></th>");
		    								  writer.write("</tr>");
		    								  
		    									result.forEach((k1,v1) -> { 
		    										try {
														writer.write("<tr>");
													} catch (IOException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
		    										try {
														writer.write("<th class='tg-yw4l'>"+ k1 +"</th>");
													} catch (IOException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
		    											v1.forEach((k2,v2) -> {
		    												try {
																writer.write("<th class='tg-yw4l'>"+ k2 +"</th>");
															} catch (IOException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
		    												try {
																writer.write("<th class='tg-yw4l'>"+ v2 +"</th>");
															} catch (IOException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
		    											});
		    										});
		    									
		    									
		    								 
		    										  writer.write("</table>"); 
		    										  writer.write("</body>");
		      writer.write("</html>");								  
		      writer.flush();
		      writer.close();;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}