package GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Filter.LocationFilter;

public class filterGUI {

	public void useLocF(ArrayList<String> database, double lat, double lon, double radius, int flag) {

		double dis;
		ArrayList<String> tempDatabase = new ArrayList<String>();

		for (int i = 0; i < database.size(); i++) {
			String[] col = database.get(i).split(",");
			dis = LocationFilter.distFrom(Double.valueOf(lat), Double.valueOf(lon), Double.valueOf(col[2]),
					Double.valueOf(col[3]));
			if (flag == 0) {
				if (dis <= radius)
					tempDatabase.add(database.get(i));
			} else if (dis > radius)
				tempDatabase.add(database.get(i));

		}

		database.clear();

		for (int i = 0; i < tempDatabase.size(); i++) {
			database.add(tempDatabase.get(i));
		}

		JOptionPane.showMessageDialog(null, "Location filter on database is done", "File Saved",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void useModF(ArrayList<String> database, String model, int flag) {

		ArrayList<String> tempDatabase = new ArrayList<String>();

		for (int i = 0; i < database.size(); i++) {
			String[] col = database.get(i).split(",");
			if (flag == 0) {
				if (col[1].equals("model=" + model)) {
					tempDatabase.add(database.get(i));
				}
			} else {
				if (!col[1].equals("model=" + model)) {
					tempDatabase.add(database.get(i));
				}
			}

		}

		database.clear();

		for (int i = 0; i < tempDatabase.size(); i++) {
			database.add(tempDatabase.get(i));
		}

		JOptionPane.showMessageDialog(null, "Model filter on database is done", "File Saved",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void useTimeF(ArrayList<String> database, String startTime, String endTime, int flag) throws ParseException {

		ArrayList<String> tempDatabase = new ArrayList<String>();

		for (int i = 0; i < database.size(); i++) {
			String[] col = database.get(i).split(",");

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date minDate = dateFormat.parse(startTime);
			Date maxDate = dateFormat.parse(endTime);
			Date getDate = dateFormat.parse(col[0]);

			if (flag == 0) {
				if ((getDate.after(minDate) || getDate.equals(minDate))
						&& (getDate.before(maxDate) || getDate.equals(maxDate))) {

					tempDatabase.add(database.get(i));
				}

			}

			else {
				if (getDate.before(minDate) || getDate.after(maxDate)) {

					tempDatabase.add(database.get(i));
				}
			}
		}

		database.clear();

		for (int i = 0; i < tempDatabase.size(); i++) {
			database.add(tempDatabase.get(i));
		}

		JOptionPane.showMessageDialog(null, "Time filter on database is done", "File Saved",
				JOptionPane.INFORMATION_MESSAGE);

	}
}
