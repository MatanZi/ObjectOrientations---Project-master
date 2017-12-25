package Filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ModelFilter extends FilterCSV{
	
	public void FilterByModel() throws FileNotFoundException,IOException{
		Scanner scanner = new Scanner( System.in );
		String line = "";
		String cvsSplitBy = ",";
		int counter=0;
		String idInput="model=";
		System.out.println("Type the exact model:");
		idInput+= scanner.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(firstLocation))){
			br.readLine(); // this will read the first line
			while ((line = br.readLine()) != null) {
				String[] column = line.split(cvsSplitBy);
				if(column[1].equals(idInput)) {
					thePrint(column, firstLocation, lastLocation, counter);
					counter++;

				}
			}
		}
	}	
	}
	

