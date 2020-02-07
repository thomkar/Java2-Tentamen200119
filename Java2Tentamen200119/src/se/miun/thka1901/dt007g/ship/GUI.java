package se.miun.thka1901.dt007g.ship;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
	// Inastansvariabler (alla grafiska komponenter samt fraktfartyget)
	private JPanel shipPanel;
	private JPanel cargoPanel;
	private JTextField shipNameTextField;
	private JTextField crewTextField;
	private JTextField maxWeightTextField;
	private JTextField currentWeightTextField;
	private JList cargoList;
	private JTextArea textArea;
	private CargoShip cargoShip ;


	public GUI(String title) {
		// Sätt titel på fönstret
		super(title);
		
		// Vad ska ske när vi stänger fönstret?
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Centrera fönstret på skärmen
		setLocationRelativeTo(null);

		// Ange vilken layout som ska användas i fönstret
		setLayout(new BorderLayout());

		// Initiera alla komponenter
		initComponents();

		// Uppdatera GUI med information från fraktfartyget
		updateShipInfo();

		// Sätt storleken på fönstret
		setSize(300, 250);

		// Gör fönstret synligt
		setVisible(true);
	}

	public static void main(String[] args) {
		GUI g = new GUI("Cargo ship info");
		
	}

	private void initComponents() {
		shipPanel = new JPanel(new GridLayout(4, 2));
		JLabel shipNameLabel = new JLabel("Ship Name");
		JLabel crewLabel = new JLabel("Crew");
		JLabel maxWeightLabel = new JLabel("MaxWeight");
		JLabel currentWeightLabel = new JLabel("Current Weight");

		shipNameTextField = new JTextField(20);
		crewTextField = new JTextField(20);
		maxWeightTextField = new JTextField(20);
		currentWeightTextField = new JTextField(20);
		
		shipPanel.add(shipNameLabel);
		shipPanel.add(crewLabel);
		shipPanel.add(shipNameTextField);
		shipPanel.add(crewTextField);
		shipPanel.add(maxWeightLabel);
		shipPanel.add(currentWeightLabel);
		shipPanel.add(maxWeightTextField);
		shipPanel.add(currentWeightTextField);

		add(shipPanel, BorderLayout.NORTH);
		
		cargoPanel = new JPanel(new BorderLayout(5, 2));
		//cargoList = new JList<Cargo>();
		textArea = new JTextArea();
		cargoShip = null;

		cargoPanel.add(new JLabel("Cargo"), BorderLayout.NORTH);
		cargoPanel.add(new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		//cargoPanel.add(textArea, BorderLayout.CENTER);
		add(cargoPanel, BorderLayout.CENTER);
	}

	private void updateShipInfo() {
		loadCargo();
		if (cargoShip == null)
			return;
		shipNameTextField.setText(cargoShip.getName());
		crewTextField.setText(Integer.toString(cargoShip.getCrew()));
		maxWeightTextField.setText(Integer.toString(cargoShip.getMaxWeight()));
		currentWeightTextField.setText(Integer.toString(cargoShip.getCurrentWeight()));
		
		for (Cargo cargo : cargoShip.getCargoList()) {
			//System.out.println(cargo.getName() + "\t" + cargo.getWeight());
			textArea.append(cargo.getName() + "\t weight = " + cargo.getWeight() + "\n");
		}	
	}
		
	private void loadCargo() {
		cargoShip = new CargoShip("HM Java II", 5000, 10);
		try {
			cargoShip.addCargo(new Cargo("Steel", 1500f));
			cargoShip.addCargo(new Cargo("Electronics", 500f));
			cargoShip.addCargo(new Cargo("Furnitures", 750.4f));
			cargoShip.addCargo(new Cargo("Books", 200f));
			cargoShip.addCargo(new Cargo("Bikes", 1000f));
		} catch (OverloadException e) {
			System.out.println("Overloaded, max weight is " + "cargoShip.getMaxWeight()");
			e.printStackTrace();
		}
		
	}
}