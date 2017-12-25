package Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.io.File;

import org.junit.Test;

public class CSVTest {
	CSV.ReadAndRewriteCSV junitCSV = new CSV.ReadAndRewriteCSV();
	CSV.MergeCSV junitCSV2 = new CSV.MergeCSV();
	@Test
	public void returnModTest(){
		String result =junitCSV.returnMod("c:/temp/file0.csv");
		assertEquals("model=LG-H815", result);
	}
	@Test
	public void writeFileTest() throws IOException {
		String expectedCSV="c:/temp2/NewC0.csv";
		String orgCSV="c:/temp/file0.csv";
		String testCSV="c:/temp2/testWriteFile.csv";
		junitCSV.writeFile(orgCSV, testCSV);
		String line;
		BufferedReader expected = new BufferedReader(new FileReader(expectedCSV));
		BufferedReader newCsv = new BufferedReader(new FileReader(testCSV));
	    while ((line = expected.readLine()) != null) {
	      assertEquals(line, newCsv.readLine());
	    }
		
	}
	@Test
	public void getMergedTest() throws IOException {
		String expectedCSV="c:/temp2/merged.csv";
		String testCSV="c:/temp2/testGetMerged.csv";
		
		File file = new File("c:/temp2/afterFormat/");
		File[] files = file.listFiles();
		CSV.MergeCSV.GetMerged(files, testCSV);
		
		String line;
		BufferedReader expected = new BufferedReader(new FileReader(expectedCSV));
		BufferedReader newCsv = new BufferedReader(new FileReader(testCSV));
	    while ((line = expected.readLine()) != null) {
	      assertEquals(line, newCsv.readLine());
	    }
		
	}
}
