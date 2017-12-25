package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ReadAndRewriteCSV {
	
	String CsvFile;
	
	public ReadAndRewriteCSV() {
		//CsvFile="c:/temp/file0.csv";
	}
	
	public ReadAndRewriteCSV(String CsvLoc) {
		CsvFile=CsvLoc;
	}

	public String getCsvFile() {
		return CsvFile;
	}
	public void setCsvFile(String csvFile) {
		CsvFile = csvFile;
	}
	/**
	 * This function get a CSV file and returning a String value 
	 * of phone model from which the scan was performed
	 * @param csvFile The original CSV file
	 * @return The String containing the phone model
	 */
	public static String returnMod(String csvFile) {

		String line = "";
		String cvsSplitBy = ",";
		String model="";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			line = br.readLine();
			String[] column = line.split(cvsSplitBy);
			model=column[2];
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return model;
	}

	/**
	 * This function get a CSV file and converting it to a new CSV according to the format
	 * @param csvFile 	The original CSV file
	 * @param newCsv	The new CSV file
	 */

	public static void writeFile(String csvFile, String newCsv) {
		//Delimiter used in CSV file
		String NEW_LINE_SEPARATOR = "\n";
		//CSV file header
		String FILE_HEADER = "Time, ID, Lat, Lon, Alt, #WiFi networks, SSID1, MAC1, Frequncy1, Signal1,"
				+ " SSID2, MAC2, Frequncy2, Signal2,"
				+ " SSID3, MAC3, Frequncy3, Signal3,"
				+ " SSID4, MAC4, Frequncy4, Signal4,"
				+ " SSID5, MAC5, Frequncy5, Signal5,"
				+ " SSID6, MAC6, Frequncy6, Signal6,"
				+ " SSID7, MAC7, Frequncy7, Signal7,"
				+ " SSID8, MAC8, Frequncy8, Signal8,"
				+ " SSID9, MAC9, Frequncy9, Signal9,"
				+ " SSID10, MAC10, Frequncy10, Signal10";
		FileWriter fileWriter = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			fileWriter = new FileWriter(newCsv);
			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
				String mod=returnMod(csvFile);
				br.readLine(); // this will read the first line
				br.readLine();// this will read the second line

				Other.Info[] max = new Other.Info[10];
				int count = 0;
				while ((line = br.readLine()) != null) {

					String[] column = line.split(cvsSplitBy);
					Other.Info info = new Other.Info(column, mod);
					if (count > 0 && !max[0].time.equals(info.time)) {
						printPeriod(max, count, fileWriter);
						count = 0;
					}
					int i = 0;
					while (i < count && max[i].signal > info.signal) {
						++i;
					}
					while (i < count) {
						Other.Info pred = max[i];
						max[i] = info;
						info = pred;
						++i;
					}
					if (count < max.length) {
						max[count++] = info;
					}
				}
				if (count > 0) {
					printPeriod(max, count, fileWriter);
				}
			} 

			System.out.println("CSV file was created successfully");
		} 
		catch (Exception e) {
			System.out.println("Error in writeFile!");
			e.printStackTrace();
		}

		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} 

			catch (IOException e) {
				System.out.println("Error while flushing/closing writeFile!");
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * This function print the info in to the new CSV file 
	 * @param max Array containing the 10 max signals 
	 * @param count A counter
	 * @param fileWriter
	 * @throws IOException
	 */
	public static void printPeriod(Other.Info[] max, int count, Writer fileWriter) throws IOException {
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\n";
		fileWriter.append(max[0].time);
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(max[0].mod);
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(max[0].lat);
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(max[0].lon);
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(max[0].alt);
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(count));
		for (int i = 0; i < count; ++i) {
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(max[i].wifi);
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(max[i].mac);
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Integer.toString(max[i].frq));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Integer.toString(max[i].signal));
		}
		fileWriter.append(NEW_LINE_SEPARATOR);
	}

}
