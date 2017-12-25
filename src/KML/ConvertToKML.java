package KML;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;

public class ConvertToKML {
	
	String csvFile;
	File kmlLoc;

	public ConvertToKML() {
		csvFile="c:/temp2/merged.csv";
		kmlLoc=new File("c:/temp2/final.kml");
	}
	
	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}

	public File getKmlLoc() {
		return kmlLoc;
	}

	public void setKmlLoc(File kmlLoc) {
		this.kmlLoc = kmlLoc;
	}

	public ConvertToKML(String newCSVfile,File newKmlFile) {
		csvFile=newCSVfile;
		kmlLoc=newKmlFile;
	}
	
	/**
	 * This function get the new merge CSV file and converting it to a KML file
	 * @throws IOException
	 */
	public  void csvToKml() throws IOException {
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("csvToKml").withOpen(true);		
		String line = "";
		String cvsSplitBy = ",";
		Scanner scanner = new Scanner( System.in );
		System.out.println();




		// create a Folder
		Folder folder = doc.createAndAddFolder();
		folder.withName("CSV to KML").withOpen(true);

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			br.readLine(); // this will read the first line
			while ((line = br.readLine()) != null) {
				String[] column = line.split(cvsSplitBy);
				double lat=Double.parseDouble(column[2]);
				double lon=Double.parseDouble(column[3]);
				double alt=Double.parseDouble(column[4]);
				String id=column[1].replace("model=", "");
				// create Placemark elements
				createPlacemark(doc, folder, column[0], id, column[6],  
						column[7], column[8], column[9], lon
						, lat, alt);

			}
		}	

		// print and save
		kml.marshal(kmlLoc);

	}

	/**
	 * This function create a new placemark
	 * @param document
	 * @param folder
	 * @param Time
	 * @param ID
	 * @param SSID
	 * @param MAC
	 * @param Frequency
	 * @param Signal
	 * @param longitude
	 * @param latitude
	 * @param Alt
	 */
	public static void createPlacemark(Document document, Folder folder, String Time, String ID, String SSID,  
			String MAC, String Frequency,String Signal, double longitude, double latitude, double Alt ) {
		
		Icon icon = new Icon()
				.withHref("http://maps.google.com/mapfiles/ms/icons/blue-dot.png");//set the placemark icon
		Style style = document.createAndAddStyle();
		style.withId("style_" + ID) // set the stylename to use this style from the placemark
		.createAndSetIconStyle().withScale(0.8).withIcon(icon); // set size and icon
		style.createAndSetLabelStyle().withColor("5000FF14").withScale(1.0); // set color and size for the name

		Placemark placemark = folder.createAndAddPlacemark();
		// use the style for each placemark
		placemark.withName(ID)
		.withStyleUrl("#style_" + ID)
		.withDescription(
				"Time: <b>"+ Time +"</b><br/>ID: <b>"+ ID +"</b><br/>SSID: <b>"+ SSID +"</b><br/>"
						+ "MAC: <b>"+ MAC +"</b><br/>Frequency: <b>"+ Frequency +"</b><br/>"
						+ "Signal: <b>"+ Signal +"</b>")

		// coordinates and distance (zoom level) of the viewer
		.createAndSetLookAt().withLongitude(longitude).withLatitude(latitude).withAltitude(Alt);
		
		//Add TimeStamp
		placemark.createAndSetTimeStamp().setWhen(Time.replace(" ", "T")+"Z");
		
		placemark.createAndSetPoint().addToCoordinates(longitude, latitude); // set coordinates
	}

	
	
}