package Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class KMLTest {

    KML.ConvertToKML junitKML = new KML.ConvertToKML();
    
    @Test
	public void csvToKmlTest() throws IOException {
		String sourceCsv="c:/temp2/merged.csv";
		String expectedKml="c:/temp2/final.kml";
		File newKml=new File("c:/temp2/csvToKmlTest.kml");
		junitKML.setKmlLoc(newKml);
		junitKML.setCsvFile(sourceCsv);
		junitKML.csvToKml();
		
		String line;
		BufferedReader expected = new BufferedReader(new FileReader(expectedKml));
		BufferedReader newFile = new BufferedReader(new FileReader(newKml));
	    while ((line = expected.readLine()) != null) {
	      assertEquals(line, newFile.readLine());
	    }
	}

}
