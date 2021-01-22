package com.sistema_empresarial.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.Font;

public class RelatorioProgress extends JFrame {

	private JPanel contentPane;
	public JLabel stringProgress;
	public JProgressBar progressBar;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					RelatorioProgress frame = new RelatorioProgress();
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
	public RelatorioProgress() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 313, 145);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(RelatorioProgress.class.getResource("/icons/file.png")));
		lblNewLabel.setBounds(20, 11, 255, 35);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		stringProgress = new JLabel("Carregando...");
		stringProgress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		stringProgress.setHorizontalAlignment(SwingConstants.CENTER);
		stringProgress.setBounds(20, 54, 255, 17);
		contentPane.add(stringProgress);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(SystemColor.control);
		progressBar.setIndeterminate(true);
		progressBar.setBounds(20, 81, 255, 10);
		contentPane.add(progressBar);
	}

}
