package com.gui.cleofe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PoS extends JFrame{
	private JPanel flavorPane;
	private JPanel addOnPane;
	private JPanel totalPane;
	private Border blackline, topline;
	private TitledBorder flavorTitle; 
	private TitledBorder addOnTitle;
	private JRadioButton vanillaButton;
	private JRadioButton strawberryButton; 
	private JRadioButton chocolateButton;
	private JCheckBox springkleCheckBox;
	private JCheckBox peanutCheckBox;
	private JCheckBox fudgeCheckBox;
	private JLabel vanillaPriceLabel;
	private JLabel strawberryPriceLabel;
	private JLabel chocolatePriceLabel;
	private JLabel springklePriceLabel;
	private JLabel peanutPriceLabel;
	private JLabel fudgePriceLabel;
	private JLabel totalPriceLabel;
	private JLabel subTotalPriceLabel;
	private JLabel taxPriceLabel;
	private JLabel totalLabel;
	private JLabel subTotalLabel;
	private JLabel taxLabel; 
	private JButton calculateButton;
	private JButton resetButton;
	private JButton exitButton;
	private ButtonGroup flavorGroup;
	private Color black = new Color(0, 0, 0);
	private double total = 0;
	private double subtotal = 0;
	private double tax = 0;
	private double flavortemp = 0; 
	private double addontemp = 0; 
	
	public PoS(String title) {
		super(title);
		
		blackline = BorderFactory.createLineBorder(black);
		topline = BorderFactory.createMatteBorder(2, 0, 0, 0, black);
		flavorTitle = BorderFactory.createTitledBorder(blackline, "Flavors");
		addOnTitle = BorderFactory.createTitledBorder(blackline, "Add Ons");
		flavorTitle.setTitleFont(new Font("Open Sans Extrabold", Font.BOLD, 22));
		addOnTitle.setTitleFont(new Font("Open Sans Extrabold", Font.BOLD, 22));
		
		flavorPane = new JPanel();
		addOnPane = new JPanel();
		totalPane = new JPanel();
		
		vanillaPriceLabel = new JLabel("$1.00");
		strawberryPriceLabel = new JLabel("$1.50");
		chocolatePriceLabel = new JLabel("$2.00");
		
		springklePriceLabel = new JLabel("$0.25");
		peanutPriceLabel = new JLabel("$0.50");
		fudgePriceLabel = new JLabel("$0.75");
		
		totalLabel = new JLabel("Total");
		subTotalLabel = new JLabel("Subtotal");
		taxLabel = new JLabel("Tax");
		
		totalPriceLabel = new JLabel("0.00");
		subTotalPriceLabel = new JLabel("0.00");
		taxPriceLabel = new JLabel("0.00");
		
		vanillaButton = new JRadioButton("Vanilla");
		strawberryButton = new JRadioButton("Strawberry");
		chocolateButton = new JRadioButton("Chocolate");
		calculateButton = new JButton("Calculate");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		
		springkleCheckBox = new JCheckBox("Springkles");
		peanutCheckBox = new JCheckBox("Peanuts");
		fudgeCheckBox = new JCheckBox("Fudge");

		
		setPreferredSize(new Dimension(400, 630));
		setLayout(null);
		flavorPane.setBounds(20, 20, 345, 180);
		flavorPane.setBorder(flavorTitle);
		vanillaButton.setFont(new Font("Open Sans", Font.BOLD, 14));
		strawberryButton.setFont(new Font("Open Sans", Font.BOLD, 14));
		chocolateButton.setFont(new Font("Open Sans", Font.BOLD, 14));

		addOnPane.setBounds(20, 200, 345, 180);
		addOnPane.setBorder(addOnTitle);
		springkleCheckBox.setFont(new Font("Open Sans", Font.BOLD, 14));
		peanutCheckBox.setFont(new Font("Open Sans", Font.BOLD, 14));
		fudgeCheckBox.setFont(new Font("Open Sans", Font.BOLD, 14));

		totalPane.setBounds(20, 400, 345, 180);
		totalPane.setBorder(topline);
		
		flavorPane.setLayout(null);
		vanillaButton.setBounds(20, 30, 200, 50);
		strawberryButton.setBounds(20, 75, 200, 50);
		chocolateButton.setBounds(20, 120, 200, 50);
		vanillaButton.setSelected(true);

		vanillaPriceLabel.setBounds(0, 30, 310, 50);
		strawberryPriceLabel.setBounds(0, 75, 310, 50);
		chocolatePriceLabel.setBounds(0, 120, 310, 50);
		
		vanillaPriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		strawberryPriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		chocolatePriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		
		flavorPane.add(vanillaButton);
		flavorPane.add(strawberryButton);
		flavorPane.add(chocolateButton);
		
		flavorPane.add(vanillaPriceLabel);
		flavorPane.add(strawberryPriceLabel);
		flavorPane.add(chocolatePriceLabel);
		

		addOnPane.setLayout(null);
		springkleCheckBox.setBounds(20, 30, 200, 50);
		peanutCheckBox.setBounds(20, 75, 200, 50);
		fudgeCheckBox.setBounds(20, 120, 200, 50);
		
		springklePriceLabel.setBounds(0, 30, 310, 50);
		peanutPriceLabel.setBounds(0, 75, 310, 50);
		fudgePriceLabel.setBounds(0, 120, 310, 50);
		
		springklePriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		peanutPriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		fudgePriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		
		addOnPane.add(springkleCheckBox);
		addOnPane.add(peanutCheckBox);
		addOnPane.add(fudgeCheckBox);
		
		addOnPane.add(springklePriceLabel);
		addOnPane.add(peanutPriceLabel);
		addOnPane.add(fudgePriceLabel);

		totalPane.setLayout(null);
		totalLabel.setBounds(0,0,100,50);
		subTotalLabel.setBounds(0,25,100,50);
		taxLabel.setBounds(0,45,100,50);
		
		totalPriceLabel.setBounds(0,0,345,50);
		subTotalPriceLabel.setBounds(0,25,345,50);
		taxPriceLabel.setBounds(0,45,345,50);
		
		totalPriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		subTotalPriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		taxPriceLabel.setHorizontalAlignment(JTextField.RIGHT);
		
		calculateButton.setBounds(0,90,345,40);
		resetButton.setBounds(0, 140, 160, 30);
		exitButton.setBounds(185, 140, 160, 30);
		
		totalPriceLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		subTotalPriceLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
		taxPriceLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
		totalLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		subTotalLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
		taxLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
		
		totalPane.add(totalLabel);
		totalPane.add(subTotalLabel);
		totalPane.add(taxLabel);
		totalPane.add(subTotalPriceLabel);
		totalPane.add(totalPriceLabel);
		totalPane.add(taxPriceLabel);
		totalPane.add(calculateButton);
		totalPane.add(resetButton);
		totalPane.add(exitButton);
		
		add(flavorPane);
		add(addOnPane);
		add(totalPane);
		
		flavorGroup = new ButtonGroup();
		flavorGroup.add(vanillaButton);
		flavorGroup.add(strawberryButton);
		flavorGroup.add(chocolateButton);
		
		CheckBoxHandler handlerCheckBox = new CheckBoxHandler();		
		springkleCheckBox.addItemListener(handlerCheckBox);
		peanutCheckBox.addItemListener(handlerCheckBox);
		fudgeCheckBox.addItemListener(handlerCheckBox);
		
		RadioButtonHandler handlerRadioButton = new RadioButtonHandler();
		vanillaButton.addItemListener(handlerRadioButton);
		strawberryButton.addItemListener(handlerRadioButton);
		chocolateButton.addItemListener(handlerRadioButton);
		
		ButtonHandler handlerButton = new ButtonHandler();
		calculateButton.addActionListener(handlerButton);
		exitButton.addActionListener(handlerButton);
		resetButton.addActionListener(handlerButton);
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton sourceButton = (JButton) e.getSource();
			
			if (sourceButton.getText().equals("Calculate")) {
				subtotal = flavortemp + addontemp;
				tax = subtotal * 0.06;
				total = subtotal + tax;
				
				totalPriceLabel.setText(String.format("%.2f", total));
				subTotalPriceLabel.setText(String.format("%.2f", subtotal));
				taxPriceLabel.setText(String.format("%.2f", tax));
			}
			
			if (sourceButton.getText().equals("Reset")) {
				flavorGroup.clearSelection();
				vanillaButton.setSelected(true);
				
				springkleCheckBox.setSelected(false);
				peanutCheckBox.setSelected(false);
				fudgeCheckBox.setSelected(false);
				
				totalPriceLabel.setText("0.00");
				subTotalPriceLabel.setText("0.00");
				taxPriceLabel.setText("0.00");
			}
			if (sourceButton.getText().equals("Exit")) {
				System.exit(0);
			}
		}
	}
	
	private class RadioButtonHandler implements ItemListener {
		private double vanilla = 1.00;
		private double strawberry = 1.50;
		private double chocolate = 2.00;
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (vanillaButton.isSelected()) {
				flavortemp = vanilla;
			}
			
			if (strawberryButton.isSelected()) {
				flavortemp = strawberry;
			}
			
			if (chocolateButton.isSelected()) {
				flavortemp = chocolate;
			}
		}
		
	} 
	private class CheckBoxHandler implements ItemListener {
		private double springkle = 0.25;
		private double peanut = 0.50;
		private double fudge = 0.75;
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (springkleCheckBox.isSelected()) {
				addontemp = springkle;
			}
			
			if (peanutCheckBox.isSelected()) {
				addontemp = peanut;
			}
			
			if (fudgeCheckBox.isSelected()) {
				addontemp = fudge;
			}
			
			if (springkleCheckBox.isSelected() && peanutCheckBox.isSelected()) {
				addontemp = springkle + peanut;
			}
			
			if (springkleCheckBox.isSelected() && fudgeCheckBox.isSelected()) {
				addontemp = springkle + fudge;
			}
			
			if (peanutCheckBox.isSelected() && fudgeCheckBox.isSelected()) {
				addontemp = fudge + peanut;
			}
			
			if (springkleCheckBox.isSelected() &&  peanutCheckBox.isSelected() && fudgeCheckBox.isSelected()) {
				addontemp = springkle + fudge + peanut;
			}
			
			if (springkleCheckBox.isSelected()==false && peanutCheckBox.isSelected()==false && fudgeCheckBox.isSelected()== false) {
				addontemp = 0;
			}
			
		}

	}

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}
		PoS poSFrame = new PoS("Point-of-Sales");
		poSFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		poSFrame.pack();
		poSFrame.setResizable(false);
		poSFrame.setLocationRelativeTo(null);
		poSFrame.setVisible(true);
	}
}
