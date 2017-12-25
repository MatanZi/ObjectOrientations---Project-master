package Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

public class FilterTest {
	Filter.FilterCSV junitFilter = new Filter.FilterCSV();
	
	@Test
	public void filterTest() throws IOException {
		String sourceCsv="c:/temp2/merged.csv";
		String expectedCsv="c:/temp2/filterCSV.csv";
		String testCSV="c:/temp2/TESTfilterCSV.csv";
		junitFilter.setLastLocation(testCSV);
		junitFilter.Filter();
		
		String line;
		BufferedReader expected = new BufferedReader(new FileReader(expectedCsv));
		BufferedReader newFile = new BufferedReader(new FileReader(testCSV));
	    while ((line = expected.readLine()) != null) {
	      assertEquals(line, newFile.readLine());
	    }
	}

}
