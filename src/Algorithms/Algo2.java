package Algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Algo2 {

	String fileLoc;
	String MacAddr[] = new String[3];
	int signal[] = new int[3];

	private double power = 2;
	private double sigDiff = 0.4;
	private double norm = 10000;
	private double minDiff = 3;
	private double noSignal = -120;
	private double diffNoSignal = 100;

	public Algo2() {
		fileLoc = "c:/temp2/merged.csv";
	}

	public Algo2(String newFileLocation, String newMacAddress1, String newMacAddress2, String newMacAddress3,
			int newSignal1, int newSignal2, int newSignal3) {
		fileLoc = newFileLocation;
		MacAddr[0] = newMacAddress1;
		MacAddr[1] = newMacAddress2;
		MacAddr[2] = newMacAddress3;
		signal[0] = newSignal1;
		signal[1] = newSignal2;
		signal[2] = newSignal3;

	}

	public void insertData() {

		for (int i = 0; i < 3; i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the " + (i + 1) + " MAC address:");
			MacAddr[i] = scanner.nextLine();
			System.out.println("Enter the signal of this MAC address:");
			signal[i] = scanner.nextInt();

			scanner.close();
		}

	}

	public double[] caculateW(double[][] MACsSignal) {
		double[] thePi = new double[3];

		double[][] diff = new double[3][3];

		for (int i = 0; i < 3; i++) {
			boolean[] flags = { true, true, true };

			if (MACsSignal[i][0] == 0)
				flags[0] = false;
			if (MACsSignal[i][1] == 0)
				flags[1] = false;
			if (MACsSignal[i][2] == 0)
				flags[2] = false;

			for (int j = 0; j < 3; j++) {

				if (MACsSignal[i][j] <= noSignal && flags[j])
					diff[i][j] = diffNoSignal;

				else if (flags[j])
					diff[i][j] = Math.max(minDiff, Math.abs(signal[i] - MACsSignal[i][j]));

				else
					diff[i][j] = -1;

			}

		}

		double[][] wDiff = new double[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (diff[i][j] == -1)
					wDiff[i][j] = 1;
				else
					wDiff[i][j] = norm / (Math.pow(diff[i][j], sigDiff) * Math.pow(signal[i], power));
			}
		}

		thePi[0] = wDiff[0][0] * wDiff[1][0] * wDiff[2][0];
		thePi[1] = wDiff[0][1] * wDiff[1][1] * wDiff[2][1];
		thePi[2] = wDiff[0][2] * wDiff[1][2] * wDiff[2][2];

		return thePi;
	}

	public double[] secondAlgo() throws FileNotFoundException, IOException {
		// Array to save the final location
		double[] assumedLocation = new double[3];
		double[][] assumedMACsLocation = new double[3][3];
		double[][] MACSignals = new double[3][3];
		Scanner scanner = new Scanner(System.in);

		if (signal[0] == 0)
			insertData();

		// Delimiter used in CSV file
		String line = "";
		String cvsSplitBy = ",";

		// Get the location of each MAC address
		for (int j = 0; j < 3; j++) {
			Algo use = new Algo(fileLoc, MacAddr[j]);
			assumedMACsLocation[j] = use.firstAlgoOneMAC();
		}

		for (int j = 0; j < 3; j++) {

			int count = 0;

			try (BufferedReader br = new BufferedReader(new FileReader(fileLoc))) {
				br.readLine(); // this will read the first line

				while ((line = br.readLine()) != null) {
					String[] column = line.split(cvsSplitBy);

					for (int i = 0; i < Integer.parseInt(column[5]) - 1; i++) {
						if (count < 3 && column[7 + i * 4].equals(MacAddr[j])) {

							MACSignals[j][count] = Double.valueOf(column[9 + i * 4]);// Sig
							Arrays.sort(MACSignals[j]);
							count++;

						}

						else if (column[7 + i * 4].equals(MacAddr[j]) && count > 2) {
							if (Double.valueOf(column[9]) > MACSignals[j][0]) {
								MACSignals[j][0] = Double.valueOf(column[9 + i * 4]);// Sig
								Arrays.sort(MACSignals[j]);
							}
						}

					}

				} // End - While next line

			} // End - read

		} // END - For 3

		double[] pi = caculateW(MACSignals);

		double wLoc[][] = new double[3][3];
		double wSum[] = new double[3];
		double sumPi = pi[0] + pi[1] + pi[2];

		for (int i = 0; i < 3; i++) {
			wLoc[i][0] = assumedMACsLocation[i][0] * pi[i];
			wLoc[i][1] = assumedMACsLocation[i][1] * pi[i];
			wLoc[i][2] = assumedMACsLocation[i][2] * pi[i];
			wSum[0] += wLoc[i][0];
			wSum[1] += wLoc[i][1];
			wSum[2] += wLoc[i][2];
		}

		assumedLocation[0] = wSum[0] / sumPi;
		assumedLocation[1] = wSum[1] / sumPi;
		assumedLocation[2] = wSum[2] / sumPi;

		System.out.println(Arrays.toString(assumedLocation));
		scanner.close();
		return assumedLocation;
	}

	//////////////////////////////////////////////////

	/**
	 * This function get an 2D array and sort it
	 * 
	 * @param arr
	 *            The array you want to sort
	 */
	public static void sort2DArr(double arr[][]) {
		Arrays.sort(arr, new Comparator<double[]>() {
			@Override
			public int compare(final double[] entry1, final double[] entry2) {
				final double freq1 = entry1[3];
				final double freq2 = entry2[3];
				return Double.compare(freq1, freq2);
			}
		});
	}

}
