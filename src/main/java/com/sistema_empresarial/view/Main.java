package com.sistema_empresarial.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.sistema_empresarial.tableModel.FuncionarioTableModel;
import com.sistema_empresarial.util.JPAConnector;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JProgressBar progressBar;
	private JLabel lblNewLabel_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					Main frame = new Main();
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
	public Main() {
		setTitle("Sistema Empresarial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 239);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/icons/logo-100.jpg")));
		lblNewLabel.setBounds(83, 11, 105, 99);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema Empresarial");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 18));
		lblNewLabel_1.setBounds(187, 32, 259, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Author: Natanael Oliveira");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(187, 67, 259, 14);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 109, 400, 2);
		contentPane.add(separator);
		

//		
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBounds(46, 158, 400, 10);
		contentPane.add(progressBar);
		Progress progress = new Progress();
		progress.start();
		LoadString loadString = new LoadString();
		loadString.start();
//		
		lblNewLabel_6 = new JLabel("Conectando...");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(46, 136, 400, 14);
		contentPane.add(lblNewLabel_6);
	}
	public class LoadString extends Thread{
		@Override
		public void run() {
			super.run();
			try {
				sleep(2000);
				while(progressBar.getValue() < 1) {
					lblNewLabel_6.setText("Conectando");
					sleep(500);
					lblNewLabel_6.setText("Conectando.");
					sleep(500);
					lblNewLabel_6.setText("Conectando..");
					sleep(500);
					lblNewLabel_6.setText("Conectando...");
					sleep(500);
				}
				lblNewLabel_6.setText("Conectado!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public class Progress extends Thread{
		@Override
		public void run() {
			super.run();
			try {
				sleep(2000);
				JPAConnector.getInstance();
				progressBar.setIndeterminate(false);
				progressBar.setStringPainted(true);
				while(progressBar.getValue() < 100) {
					sleep(3);
					progressBar.setValue(progressBar.getValue()+1);
					progressBar.setString(progressBar.getValue()+"%");
				}
				sleep(1500);
				LoginAdmin admin = new LoginAdmin();
				admin.setVisible(true);
				dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
