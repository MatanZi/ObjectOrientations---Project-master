package Filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeFilter extends FilterCSV {

	public void FilterBySpecificTime() throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		String cvsSplitBy = ",";
		int counter = 0;
		String dateInput = null;

		// Enter a specific time and date
		System.out.println("Type the exact date and time: (Format:2017-10-30 18:10:33)");
		dateInput = scanner.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(firstLocation))) {
			br.readLine(); // this will read the first line
			while ((line = br.readLine()) != null) {
				String[] column = line.split(cvsSplitBy);
				if (column[0].equals(dateInput)) {
					thePrint(column, firstLocation, lastLocation, counter);
					counter++;
				}
			}
		}
		scanner.close();
	}

	public void FilterByTime() throws FileNotFoundException, IOException, ParseException {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		String cvsSplitBy = ",";
		int counter = 0;
		// String dateInput = null;

		String endTime = null, startTime = null;

		// Enter a start time and date
		System.out.println("Type the start date and time: (Format:YYYY-MM-DD HH:MM:SS)");
		startTime = scanner.nextLine();

		// Enter a end time and date
		System.out.println("Type the end date and time: (Format:YYYY-MM-DD HH:MM:SS)");
		endTime = scanner.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(firstLocation))) {
			br.readLine(); // this will read the first line
			while ((line = br.readLine()) != null) {
				String[] column = line.split(cvsSplitBy);

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date minDate = dateFormat.parse(startTime);
				Date maxDate = dateFormat.parse(endTime);
				Date getDate = dateFormat.parse(column[0]);

				if ((getDate.after(minDate)||getDate.equals(minDate)) 
						&& (getDate.before(maxDate)||getDate.equals(maxDate))) {

					thePrint(column, firstLocation, lastLocation, counter);
					counter++;
				}
			}
		}
		scanner.close();
	}
}
