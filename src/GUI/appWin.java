package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class appWin {

	private JFrame frame;
	private JTextField txtLat;
	private JTextField txtLon;
	private JTextField txtRadius;
	private JTextField lonInput;
	private JTextField rInput;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JTextField endTimeInput;
	private JTextField txtModelName;
	private JTextField modelInput;
	private JTextField txtMacAddress;
	private JTextField algo1Input;
	private JTextField txtMacAddress_1;
	private JTextField txtMacAddress_2;
	private JTextField txtMacAddress_3;
	private JTextField mac1Input;
	private JTextField mac2Input;
	private JTextField mac3Input;
	private JTextField txtSignal;
	private JTextField signal1Input;
	private JTextField signal2Input;
	private JTextField signal3Input;
	private JTextField txtSignal_1;
	private JTextField txtSignal_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appWin window = new appWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public appWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<String> database = new ArrayList<String>();
		int macCounter = 0;
		
		

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setBounds(100, 100, 968, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		/////////////

		//////////////
		JLabel lblNewLabel = new JLabel("HeadLogo");
		lblNewLabel.setIcon(new ImageIcon(appWin.class.getResource("/Untitled-11.png")));
		lblNewLabel.setBounds(218, 11, 414, 104);
		frame.getContentPane().add(lblNewLabel);

		JTextArea txtrInfo = new JTextArea();
		txtrInfo.setBackground(Color.WHITE);
		txtrInfo.setText("Info:");
		txtrInfo.setBounds(10, 38, 261, 90);
		frame.getContentPane().add(txtrInfo);

		JLabel lblFilterHead = new JLabel("");
		lblFilterHead.setIcon(new ImageIcon(appWin.class.getResource("/filterHead.png")));
		lblFilterHead.setBounds(84, 139, 145, 32);
		frame.getContentPane().add(lblFilterHead);

		JLabel lblAlgoHead = new JLabel("");
		lblAlgoHead.setIcon(new ImageIcon(appWin.class.getResource("/algoHead.png")));
		lblAlgoHead.setBounds(566, 139, 145, 32);
		frame.getContentPane().add(lblAlgoHead);

		JLabel lblLocation = new JLabel("");
		lblLocation.setIcon(new ImageIcon(appWin.class.getResource("/loc.png")));
		lblLocation.setBounds(20, 195, 105, 23);
		frame.getContentPane().add(lblLocation);

		JLabel lblModel = new JLabel("");
		lblModel.setIcon(new ImageIcon(appWin.class.getResource("/mod.png")));
		lblModel.setBounds(203, 305, 105, 23);
		frame.getContentPane().add(lblModel);

		JLabel lblTime = new JLabel("");
		lblTime.setIcon(new ImageIcon(appWin.class.getResource("/time.png")));
		lblTime.setBounds(203, 196, 105, 23);
		frame.getContentPane().add(lblTime);

		JCheckBox locCheckBox = new JCheckBox("");
		locCheckBox.setBackground(Color.WHITE);
		locCheckBox.setBounds(131, 195, 21, 23);
		frame.getContentPane().add(locCheckBox);

		txtLat = new JTextField();
		txtLat.setText("Lat:");
		txtLat.setBounds(40, 230, 34, 20);
		frame.getContentPane().add(txtLat);
		txtLat.setColumns(10);

		JTextField latInput = new JTextField();
		latInput.setBounds(84, 230, 86, 20);
		frame.getContentPane().add(latInput);
		latInput.setColumns(10);

		txtLon = new JTextField();
		txtLon.setText("Lon:");
		txtLon.setColumns(10);
		txtLon.setBounds(40, 259, 34, 20);
		frame.getContentPane().add(txtLon);

		txtRadius = new JTextField();
		txtRadius.setText("Radius");
		txtRadius.setColumns(10);
		txtRadius.setBounds(40, 290, 48, 20);
		frame.getContentPane().add(txtRadius);

		lonInput = new JTextField();
		lonInput.setColumns(10);
		lonInput.setBounds(84, 259, 86, 20);
		frame.getContentPane().add(lonInput);

		rInput = new JTextField();
		rInput.setColumns(10);
		rInput.setBounds(94, 290, 86, 20);
		frame.getContentPane().add(rInput);

		JCheckBox timeCheckBox = new JCheckBox("");
		timeCheckBox.setBackground(Color.WHITE);
		timeCheckBox.setBounds(314, 196, 21, 23);
		frame.getContentPane().add(timeCheckBox);

		JCheckBox modelCheckBox = new JCheckBox("");
		modelCheckBox.setBackground(Color.WHITE);
		modelCheckBox.setBounds(314, 305, 21, 23);
		frame.getContentPane().add(modelCheckBox);

		txtStartTime = new JTextField();
		txtStartTime.setText("Start Time:\r\n");
		txtStartTime.setColumns(10);
		txtStartTime.setBounds(213, 230, 68, 20);
		frame.getContentPane().add(txtStartTime);

		JTextField startTimeInput = new JTextField();
		startTimeInput.setColumns(10);
		startTimeInput.setBounds(291, 230, 86, 20);
		frame.getContentPane().add(startTimeInput);

		txtEndTime = new JTextField();
		txtEndTime.setText("End Time:\r\n");
		txtEndTime.setColumns(10);
		txtEndTime.setBounds(213, 259, 68, 20);
		frame.getContentPane().add(txtEndTime);

		endTimeInput = new JTextField();
		endTimeInput.setColumns(10);
		endTimeInput.setBounds(291, 259, 86, 20);
		frame.getContentPane().add(endTimeInput);

		txtModelName = new JTextField();
		txtModelName.setText("Model Name:");
		txtModelName.setColumns(10);
		txtModelName.setBounds(218, 339, 86, 20);
		frame.getContentPane().add(txtModelName);

		modelInput = new JTextField();
		modelInput.setColumns(10);
		modelInput.setBounds(314, 339, 86, 20);
		frame.getContentPane().add(modelInput);

		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpWin.helpScreen();
			}
		});
		
		btnHelp.setBounds(853, 11, 89, 23);
		frame.getContentPane().add(btnHelp);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(appWin.class.getResource("/algo1.png")));
		label.setBounds(443, 196, 105, 23);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(appWin.class.getResource("/algo2.png")));
		label_1.setBounds(702, 196, 105, 23);
		frame.getContentPane().add(label_1);

		txtMacAddress = new JTextField();
		txtMacAddress.setText("MAC Address:");
		txtMacAddress.setColumns(10);
		txtMacAddress.setBounds(453, 230, 86, 20);
		frame.getContentPane().add(txtMacAddress);

		algo1Input = new JTextField();
		algo1Input.setColumns(10);
		algo1Input.setBounds(549, 230, 127, 20);
		frame.getContentPane().add(algo1Input);

		JTextArea algoResult = new JTextArea();
		algoResult.setText("Result:");
		algoResult.setBackground(Color.WHITE);
		algoResult.setBounds(463, 293, 188, 90);
		frame.getContentPane().add(algoResult);

		JLabel lblDddd = new JLabel("");
		lblDddd.setIcon(new ImageIcon(appWin.class.getResource("/naw.png")));
		lblDddd.setBounds(131, 178, 21, 20);
		frame.getContentPane().add(lblDddd);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(appWin.class.getResource("/naw.png")));
		label_3.setBounds(314, 178, 21, 20);
		frame.getContentPane().add(label_3);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(appWin.class.getResource("/naw.png")));
		label_5.setBounds(314, 279, 21, 20);
		frame.getContentPane().add(label_5);
		
		

		JButton locPress = new JButton("");
		locPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double lat = 0, lon = 0, r = 0;
				int flag = 0;

				try {
					lon = Double.parseDouble(lonInput.getText());
					lat = Double.parseDouble(latInput.getText());
					r = Double.parseDouble(rInput.getText());

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid numbers");
				}

				filterGUI op = new filterGUI();

				if (locCheckBox.isSelected())
					flag = 1;

				op.useLocF(database, lat, lon, r, flag);
				
				txtrInfo.setText("Info:\nAmount of lines is: " + database.size()
				+ "\nAmount of MAC address is: " + macCounter);

				
			}
		});
		locPress.setBounds(158, 195, 21, 23);
		frame.getContentPane().add(locPress);

		JButton timePress = new JButton("");
		timePress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String startTime = null, endTime = null;
				int flag = 0;

				try {
					startTime = startTimeInput.getText();
					endTime = endTimeInput.getText();

				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid numbers");
				}

				filterGUI op = new filterGUI();

				if (timeCheckBox.isSelected())
					flag = 1;

				try {
					op.useTimeF(database, startTime, endTime, flag);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				txtrInfo.setText("Info:\nAmount of lines is: " + database.size()
				+ "\nAmount of MAC address is: " + macCounter);
				
			}
		});
		timePress.setBounds(341, 195, 21, 23);
		frame.getContentPane().add(timePress);

		JButton modelPress = new JButton("");
		modelPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phoneModel = null;
				int flag=0;

				phoneModel = modelInput.getText();

				filterGUI op = new filterGUI();
				
				if(modelCheckBox.isSelected())
					flag=1;

				op.useModF(database, phoneModel, flag);

				txtrInfo.setText("Info:\nAmount of lines is: " + database.size()
				+ "\nAmount of MAC address is: " + macCounter);
				
			}
		});
		modelPress.setBounds(341, 305, 21, 23);
		frame.getContentPane().add(modelPress);

		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latInput.setText("");
				lonInput.setText("");
				rInput.setText("");
				modelInput.setText("");
				startTimeInput.setText("");
				endTimeInput.setText("");
				algo1Input.setText("");
				mac1Input.setText("");
				mac2Input.setText("");
				mac3Input.setText("");
				signal1Input.setText("");
				signal2Input.setText("");
				signal3Input.setText("");
				algoResult.setText("Result:");
			}

		});
		btnClearFields.setBounds(820, 52, 122, 23);
		frame.getContentPane().add(btnClearFields);

		txtMacAddress_1 = new JTextField();
		txtMacAddress_1.setText("MAC Address1:");
		txtMacAddress_1.setColumns(10);
		txtMacAddress_1.setBounds(712, 230, 86, 20);
		frame.getContentPane().add(txtMacAddress_1);

		txtMacAddress_2 = new JTextField();
		txtMacAddress_2.setText("MAC Address2:");
		txtMacAddress_2.setColumns(10);
		txtMacAddress_2.setBounds(712, 290, 86, 20);
		frame.getContentPane().add(txtMacAddress_2);

		txtMacAddress_3 = new JTextField();
		txtMacAddress_3.setText("MAC Address3:");
		txtMacAddress_3.setColumns(10);
		txtMacAddress_3.setBounds(712, 350, 86, 20);
		frame.getContentPane().add(txtMacAddress_3);

		mac1Input = new JTextField();
		mac1Input.setColumns(10);
		mac1Input.setBounds(815, 230, 127, 20);
		frame.getContentPane().add(mac1Input);

		mac2Input = new JTextField();
		mac2Input.setColumns(10);
		mac2Input.setBounds(815, 290, 127, 20);
		frame.getContentPane().add(mac2Input);

		mac3Input = new JTextField();
		mac3Input.setColumns(10);
		mac3Input.setBounds(815, 350, 127, 20);
		frame.getContentPane().add(mac3Input);

		txtSignal = new JTextField();
		txtSignal.setText("Signal1:");
		txtSignal.setColumns(10);
		txtSignal.setBounds(712, 259, 86, 20);
		frame.getContentPane().add(txtSignal);

		signal1Input = new JTextField();
		signal1Input.setColumns(10);
		signal1Input.setBounds(815, 259, 127, 20);
		frame.getContentPane().add(signal1Input);

		signal2Input = new JTextField();
		signal2Input.setColumns(10);
		signal2Input.setBounds(815, 321, 127, 20);
		frame.getContentPane().add(signal2Input);

		signal3Input = new JTextField();
		signal3Input.setColumns(10);
		signal3Input.setBounds(815, 381, 127, 20);
		frame.getContentPane().add(signal3Input);

		txtSignal_1 = new JTextField();
		txtSignal_1.setText("Signal2:");
		txtSignal_1.setColumns(10);
		txtSignal_1.setBounds(712, 319, 86, 20);
		frame.getContentPane().add(txtSignal_1);

		txtSignal_2 = new JTextField();
		txtSignal_2.setText("Signal3:");
		txtSignal_2.setColumns(10);
		txtSignal_2.setBounds(712, 381, 86, 20);
		frame.getContentPane().add(txtSignal_2);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String macAddress;
				double[] theLoc = new double[3];
				algoGUI op = new algoGUI();

				macAddress = algo1Input.getText();

				try {
					theLoc = op.useAlgo1(database, macAddress);
				} catch (IOException e) {
					e.printStackTrace();
				}

				algoResult.setText("Result:\nMac Address location is:\nLat: " + theLoc[0] + "\nLon: " + theLoc[1]
						+ "\nAlt: " + theLoc[2]);

			}
		});
		button.setBounds(557, 195, 21, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mac1, mac2, mac3;
				int sig1, sig2, sig3;
				double[] theLoc = new double[3];

				mac1 = mac1Input.getText();
				mac2 = mac2Input.getText();
				mac3 = mac3Input.getText();

				sig1 = Integer.parseInt(signal1Input.getText());
				sig2 = Integer.parseInt(signal2Input.getText());
				sig3 = Integer.parseInt(signal3Input.getText());

				algoGUI op = new algoGUI();

				theLoc = op.useAlgo2(database, mac1, mac2, mac3, sig1, sig2, sig3);

				algoResult.setText(
						"Result:\nLocation is:\nLat: " + theLoc[0] + "\nLon: " + theLoc[1] + "\nAlt: " + theLoc[2]);

			}
		});
		button_1.setBounds(817, 195, 21, 23);
		frame.getContentPane().add(button_1);

		JButton algo1DatabasePress = new JButton("Database Algo 1");
		algo1DatabasePress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				algoGUI op = new algoGUI();

				try {
					op.useAlgo1Database(database);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		algo1DatabasePress.setBounds(459, 258, 138, 23);
		frame.getContentPane().add(algo1DatabasePress);

		JLabel lblMadeby = new JLabel("");
		lblMadeby.setIcon(new ImageIcon(appWin.class.getResource("/madeBy.png")));
		lblMadeby.setBounds(0, 381, 271, 27);
		frame.getContentPane().add(lblMadeby);

		JMenuBar menuBar_1 = new JMenuBar();
		frame.setJMenuBar(menuBar_1);

		JMenu mnFile = new JMenu("File");
		menuBar_1.add(mnFile);

		JMenuItem mntmLoadFile = new JMenuItem("Load File");
		mntmLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openFile op = new openFile();

				try {
					op.pickFile(database);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				txtrInfo.setText("Info:\nAmount of lines is: " + database.size()
				+ "\nAmount of MAC address is: " + macCounter);

			}
		});
		mnFile.add(mntmLoadFile);

		JMenuItem mntmLoadFolder = new JMenuItem("Load Folder");
		mntmLoadFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile op = new openFile();

				try {
					op.pickFolder(database);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				
				txtrInfo.setText("Info:\nAmount of lines is: " + database.size()
				+ "\nAmount of MAC address is: " + macCounter);

				
			}
		});
		mnFile.add(mntmLoadFolder);

		JMenu mnSaveAs = new JMenu("Save as...");
		mnFile.add(mnSaveAs);

		JMenuItem mntmCsv = new JMenuItem("CSV");

		// Save file as CSV from the database
		mntmCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openFile op = new openFile();

				try {
					op.saveFileCSV(database);
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		mnSaveAs.add(mntmCsv);

		JMenuItem mntmKml = new JMenuItem("KML");
		// Save file as KML from the database
		mntmKml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				openFile op = new openFile();

				try {
					op.saveFileKML(database);
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		mnSaveAs.add(mntmKml);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmClearDatabase = new JMenuItem("Clear Database");
		mntmClearDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				database.clear();

				txtrInfo.setText("Info:\nAmount of lines is: " + database.size()
				+ "\nAmount of MAC address is: " + macCounter);
			}
		});
		mnFile.add(mntmClearDatabase);

		
		
	}
}
