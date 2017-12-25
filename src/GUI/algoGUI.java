package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Algorithms.Algo;
import Algorithms.Algo2;

public class algoGUI {
	
	public double[] useAlgo1(ArrayList<String> database, String macAddress) throws FileNotFoundException, IOException {

		double[] saveLoc = new double[3];

		// Delimiter used in CSV file
		String NEW_LINE_SEPARATOR = "\n";
		// CSV file header
		String FILE_HEADER = "Time, ID, Lat, Lon, Alt, #WiFi networks, SSID1, MAC1, Frequncy1, Signal1,"
				+ " SSID2, MAC2, Frequncy2, Signal2," + " SSID3, MAC3, Frequncy3, Signal3,"
				+ " SSID4, MAC4, Frequncy4, Signal4," + " SSID5, MAC5, Frequncy5, Signal5,"
				+ " SSID6, MAC6, Frequncy6, Signal6," + " SSID7, MAC7, Frequncy7, Signal7,"
				+ " SSID8, MAC8, Frequncy8, Signal8," + " SSID9, MAC9, Frequncy9, Signal9,"
				+ " SSID10, MAC10, Frequncy10, Signal10";

		String tempCSVLoc = "C:\\temp2\\prep\\algo1Temp.csv";

		try (FileWriter fw = new FileWriter(tempCSVLoc)) {

			fw.write(FILE_HEADER.toString());
			fw.write(NEW_LINE_SEPARATOR.toString());

			for (int i = 0; i < database.size(); i++) {
				fw.write(database.get(i).toString());
				fw.write(NEW_LINE_SEPARATOR.toString());
				i++;
			}

			fw.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		Algo algo1 = new Algo(tempCSVLoc, macAddress);
		saveLoc = algo1.firstAlgoOneMAC();

		File csvDelete = new File(tempCSVLoc);
		csvDelete.delete();

		JOptionPane.showMessageDialog(null, "Algo1 on mac address is done", "Algo1 Finish",
				JOptionPane.INFORMATION_MESSAGE);

		return saveLoc;

	}

	public void useAlgo1Database(ArrayList<String> database) throws FileNotFoundException, IOException {

		// Delimiter used in CSV file
		String NEW_LINE_SEPARATOR = "\n";
		// CSV file header
		String FILE_HEADER = "Time, ID, Lat, Lon, Alt, #WiFi networks, SSID1, MAC1, Frequncy1, Signal1,"
				+ " SSID2, MAC2, Frequncy2, Signal2," + " SSID3, MAC3, Frequncy3, Signal3,"
				+ " SSID4, MAC4, Frequncy4, Signal4," + " SSID5, MAC5, Frequncy5, Signal5,"
				+ " SSID6, MAC6, Frequncy6, Signal6," + " SSID7, MAC7, Frequncy7, Signal7,"
				+ " SSID8, MAC8, Frequncy8, Signal8," + " SSID9, MAC9, Frequncy9, Signal9,"
				+ " SSID10, MAC10, Frequncy10, Signal10";

		String tempCSVLoc = "C:\\temp2\\prep\\algo1Temp.csv";

		try (FileWriter fw = new FileWriter(tempCSVLoc)) {

			fw.write(FILE_HEADER.toString());
			fw.write(NEW_LINE_SEPARATOR.toString());

			for (int i = 0; i < database.size(); i++) {
				fw.write(database.get(i).toString());
				fw.write(NEW_LINE_SEPARATOR.toString());
				i++;
			}

			fw.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("C:\\temp2"));
		int retrival = chooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try (FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".csv")) {

				Algo algo1 = new Algo(tempCSVLoc);
				algo1.firstAlgoAllMACs(chooser.getSelectedFile() + ".csv");
				;
			} catch (Exception ex) {
				ex.printStackTrace();

			}

			File csvDelete = new File(tempCSVLoc);
			csvDelete.delete();

			JOptionPane.showMessageDialog(null, "Algo1 On All Database Is Done", "Algo1 Finish",
					JOptionPane.INFORMATION_MESSAGE);

		}

	}
	
	public double[] useAlgo2(ArrayList<String> database, String mac1, String mac2, String mac3,
			int sig1, int sig2, int sig3) {

		double[] saveLoc = new double[3];

		// Delimiter used in CSV file
		String NEW_LINE_SEPARATOR = "\n";
		// CSV file header
		String FILE_HEADER = "Time, ID, Lat, Lon, Alt, #WiFi networks, SSID1, MAC1, Frequncy1, Signal1,"
				+ " SSID2, MAC2, Frequncy2, Signal2," + " SSID3, MAC3, Frequncy3, Signal3,"
				+ " SSID4, MAC4, Frequncy4, Signal4," + " SSID5, MAC5, Frequncy5, Signal5,"
				+ " SSID6, MAC6, Frequncy6, Signal6," + " SSID7, MAC7, Frequncy7, Signal7,"
				+ " SSID8, MAC8, Frequncy8, Signal8," + " SSID9, MAC9, Frequncy9, Signal9,"
				+ " SSID10, MAC10, Frequncy10, Signal10";

		String tempCSVLoc = "C:\\temp2\\prep\\algo2Temp.csv";

		try (FileWriter fw = new FileWriter(tempCSVLoc)) {

			fw.write(FILE_HEADER.toString());
			fw.write(NEW_LINE_SEPARATOR.toString());

			for (int i = 0; i < database.size(); i++) {
				fw.write(database.get(i).toString());
				fw.write(NEW_LINE_SEPARATOR.toString());
				i++;
			}

			fw.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		Algo2 algo2 = new Algo2(tempCSVLoc, mac1, mac2, mac3,sig1, sig2, sig3);
		

		try {
			saveLoc=algo2.secondAlgo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File csvDelete = new File(tempCSVLoc);
		csvDelete.delete();

		JOptionPane.showMessageDialog(null, "Algo2 On Data Is Done", "Algo2 Finish",
				JOptionPane.INFORMATION_MESSAGE);

		return saveLoc;

	}

}
