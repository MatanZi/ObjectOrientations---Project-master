package Filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LocationFilter extends FilterCSV {
	
	public void FilterByLocation() throws FileNotFoundException, IOException{
		double radius;
		Scanner scanner = new Scanner( System.in );
		String line = "";
		String cvsSplitBy = ",";
		int counter=0;
		String locationInput=null;
		System.out.println("Type the exact Location: (Format:Lat,Lon)");
		locationInput= scanner.nextLine();
		System.out.println("Enter a valid radius: ");
		radius=scanner.nextDouble();
		try (BufferedReader br = new BufferedReader(new FileReader(firstLocation))){
			br.readLine(); // this will read the first line
			while ((line = br.readLine()) != null) {
				String[] column = line.split(cvsSplitBy);
				String[] locationSplit=locationInput.split(",");
				double dis=distFrom(Double.valueOf(locationSplit[0]), Double.valueOf(locationSplit[1]),
						Double.valueOf(column[2]), Double.valueOf(column[3]));
				if(dis<=radius){
					thePrint(column, firstLocation, lastLocation, counter);
					counter++;

				}
			}
		}
	}
	
	public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
	    double earthRadius = 3958.75; // miles (or 6371.0 kilometers)
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    return dist;
	    }

}
