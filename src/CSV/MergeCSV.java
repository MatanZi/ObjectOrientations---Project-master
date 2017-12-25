package CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class MergeCSV {

	/**
	 * This function get all the new CSV (after converting them according to the
	 * format) and merge them to one file
	 * 
	 * @param paths
	 *            The list where all file locations are stored
	 * @return The new String list containing all the info
	 * @throws IOException
	 */

	String outputLoc;
	
	public MergeCSV() {
		outputLoc="c:/temp2/merged.csv";
	}
	
	public MergeCSV(String newOutLoc) {
		outputLoc=newOutLoc;
	}

	public  void GetMerged(File[] files) throws IOException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(outputLoc));

		//Just for space
		System.out.println();
		
		for (int i = 0; i < files.length; i++) {

			System.out.println("Processing " + files[i].getPath() + "... ");
			BufferedReader br = new BufferedReader(new FileReader(files[i].getPath()));
			
			//If it's not the first file, skip the first line
			if (i > 0)
				br.readLine();
			
			String line = br.readLine();
			while (line != null) {
				pw.println(line);
				line = br.readLine();
			}
			br.close();
		}
		pw.close();
		System.out.println("All files have been concatenated into merged.csv\n");
	}
	
	
	public static void GetMerged(File[] files, String mergeLoc) throws IOException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(mergeLoc));

		//Just for space
		System.out.println();
		
		for (int i = 0; i < files.length; i++) {

			System.out.println("Processing " + files[i].getPath() + "... ");
			BufferedReader br = new BufferedReader(new FileReader(files[i].getPath()));
			
			//If it's not the first file, skip the first line
			if (i > 0)
				br.readLine();
			
			String line = br.readLine();
			while (line != null) {
				pw.println(line);
				line = br.readLine();
			}
			br.close();
		}
		pw.close();
		System.out.println("All files have been concatenated into merged.csv\n");
	}

	

}
