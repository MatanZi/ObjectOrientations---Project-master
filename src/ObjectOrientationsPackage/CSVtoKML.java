package ObjectOrientationsPackage;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import Algorithms.Algo;
import CSV.MergeCSV;
import CSV.ReadAndRewriteCSV;
import Filter.FilterCSV;
import KML.ConvertToKML;

/**
 * Converting, sorting and filtering a CSV file to a KML file
 * 
 * @see <b>CSV:</b> https://en.wikipedia.org/wiki/Comma-separated_values
 *      <P>
 *      <b>KML:</b> https://en.wikipedia.org/wiki/Keyhole_Markup_Language
 *
 * @version 1.0
 */

public class CSVtoKML {

	public static void main(String[] args) throws IOException, ParseException {

		// Get the list of file in the 'temp' folder and changing them to the format
		File[] fileList = new File("c:/temp").listFiles();

		for (int i = 0; i < fileList.length; i++) {
			String newCsv = "c:/temp2/afterFormat/NewC" + i + ".csv";
			ReadAndRewriteCSV MakeCSV = new ReadAndRewriteCSV("c:/temp/file" + i + ".csv");
			ReadAndRewriteCSV.writeFile(MakeCSV.getCsvFile(), newCsv);
		}

		// Get the new CSV files and merge them to one file
		File file = new File("c:/temp2/afterFormat/");
		File[] files = file.listFiles();

		MergeCSV merge=new MergeCSV();
		merge.GetMerged(files);

		String filterCSV = "c:/temp2/filterCSV.csv";

		// Use filter function [Input, Output]
		FilterCSV FilterObj = new FilterCSV();
		FilterObj.Filter();

		// Check if filter CSV is exist, if so convert him to KML
		// else convert the merge CSV to KML
		ConvertToKML Converter = new ConvertToKML();
		File f = new File(filterCSV);
		if (f.exists() && !f.isDirectory()) {
			Converter.setCsvFile(filterCSV);
			Converter.csvToKml();
		} else
			Converter.csvToKml();

		System.out.println("Done\n");

		//Algo a = new Algo();
		// a.firstAlgoAllMACs();

		// Algo2 x=new Algo2();
		// x.secondAlgo();

	}// END MAIN

}// END PROGRAM
