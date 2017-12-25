package Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;

import Algorithms.Algo;

public class AlgorithmsTest {

	@Test
	public void Algo1Test() throws FileNotFoundException, IOException {
		Algo alg =  new Algo();
		String Mac ="1c:b9:c4:16:05:3c";
		double Expected[]={32.1050521923486, 35.21013151170138, 686.4367190003204};
		assertArrayEquals(Expected, alg.firstAlgo(),0);
	}
	@Test
	public void Algo2Test(){
		
	}

}
