package abcbank.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import abcbank.LoanCalculator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLoanAmount;
	private JTextField textFieldNumberOfYears;
	private JTextField textFieldYearlyInterestRate;
	private JTextField textFieldMonthlyPayment;
	private JTextField textFieldTotalPayment;
	private JTextField textFieldTotalInterest;
	LoanCalculator calculator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameApp frame = new JFrameApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		calculator = new LoanCalculator();
		
		JButton btnCompute = new JButton("Compute");
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double loanAmount = 0;
				int numberOfYears = 0;
				double yearlyInterestRate = 0;
				
				try{
					loanAmount = Double.parseDouble(textFieldLoanAmount.getText());
					numberOfYears = Integer.parseInt(textFieldNumberOfYears.getText());
					yearlyInterestRate = Double.parseDouble(textFieldYearlyInterestRate.getText());
				}
				catch(NumberFormatException nfe){
					System.out.print("Please enter integers only.");
				}
				
				try{
					calculator.setLoanAmount(loanAmount);
					calculator.setNumberOfYears(numberOfYears);
					calculator.setYearlyInterestRate(yearlyInterestRate);
				}
				catch(IllegalArgumentException iae){
					System.out.print(iae.getMessage());
				}
				
				textFieldMonthlyPayment = (Double.toString(calculator.getMonthlyPayment()));
				
				
			}
		});
		btnCompute.setBounds(10, 217, 89, 23);
		contentPane.add(btnCompute);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLoanAmount.setText("");
				textFieldNumberOfYears.setText("");
				textFieldYearlyInterestRate.setText("");
				textFieldMonthlyPayment.setText("");
				textFieldTotalPayment.setText("");
				textFieldTotalInterest.setText("");
			}
		});
		btnClear.setBounds(109, 217, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnStop.setBounds(208, 217, 89, 23);
		contentPane.add(btnStop);
		
		JLabel lblLoanAmount = new JLabel("Loan Amount");
		lblLoanAmount.setBounds(10, 19, 63, 14);
		contentPane.add(lblLoanAmount);
		
		JLabel lblNumberOfYears = new JLabel("Number of Years");
		lblNumberOfYears.setBounds(10, 52, 80, 14);
		contentPane.add(lblNumberOfYears);
		
		JLabel lblYearlyInterestRate = new JLabel("Yearly Interest Rate");
		lblYearlyInterestRate.setBounds(10, 85, 98, 14);
		contentPane.add(lblYearlyInterestRate);
		
		JLabel lblMonthlyPayment = new JLabel("Monthly Payment");
		lblMonthlyPayment.setBounds(10, 118, 83, 14);
		contentPane.add(lblMonthlyPayment);
		
		JLabel lblTotalPayment = new JLabel("Total Payment");
		lblTotalPayment.setBounds(10, 151, 69, 14);
		contentPane.add(lblTotalPayment);
		
		JLabel lblTotalInterest = new JLabel("Total Interest");
		lblTotalInterest.setBounds(10, 184, 66, 14);
		contentPane.add(lblTotalInterest);
		
		textFieldLoanAmount = new JTextField();
		textFieldLoanAmount.setBounds(208, 16, 86, 20);
		contentPane.add(textFieldLoanAmount);
		textFieldLoanAmount.setColumns(10);
		
		textFieldNumberOfYears = new JTextField();
		textFieldNumberOfYears.setBounds(208, 49, 86, 20);
		contentPane.add(textFieldNumberOfYears);
		textFieldNumberOfYears.setColumns(10);
		
		textFieldYearlyInterestRate = new JTextField();
		textFieldYearlyInterestRate.setBounds(208, 82, 86, 20);
		contentPane.add(textFieldYearlyInterestRate);
		textFieldYearlyInterestRate.setColumns(10);
		
		textFieldMonthlyPayment = new JTextField();
		textFieldMonthlyPayment.setBounds(208, 115, 86, 20);
		contentPane.add(textFieldMonthlyPayment);
		textFieldMonthlyPayment.setColumns(10);
		
		textFieldTotalPayment = new JTextField();
		textFieldTotalPayment.setBounds(208, 148, 86, 20);
		contentPane.add(textFieldTotalPayment);
		textFieldTotalPayment.setColumns(10);
		
		textFieldTotalInterest = new JTextField();
		textFieldTotalInterest.setBounds(208, 181, 86, 20);
		contentPane.add(textFieldTotalInterest);
		textFieldTotalInterest.setColumns(10);
	}
}
