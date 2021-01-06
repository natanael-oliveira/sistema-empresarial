package com.sistema_empresarial.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sistema_empresarial.model.Relatorio;
import com.sistema_empresarial.resource.RelatorioResurce;
import com.sistema_empresarial.util.Relatorios;

import net.sf.jasperreports.engine.JRException;

import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FilePath extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilePath frame = new FilePath();
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
	@SuppressWarnings("static-access")
	public FilePath() {
		setResizable(false);
		setTitle("Gerar Relatórios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 337, 137);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
	
		List<Object> nameRelatorios = new ArrayList<Object>();
		for(int i=0;i<Relatorios.getInstance().getRelatorios().size();i++) {
			nameRelatorios.add(Relatorios.getInstance().getRelatorios().get(i).getName());
		}
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(nameRelatorios.toArray()));
		comboBox.setBounds(94, 24, 217, 25);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Gerar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileChooser fileChooser = new FileChooser("Gerar Relatório","pdf","Relatório.pdf");
				int i = fileChooser.fileSave().showSaveDialog(null);
				if(i == 0) {
					RelatorioResurce relatorioResurce = new RelatorioResurce();
					relatorioResurce.gerar(comboBox.getSelectedIndex(),fileChooser.getFileChooser().getSelectedFile().getPath());
					dispose();
				}else {
					System.out.println("cancelado");
				}
			}
		});
		btnNewButton.setBounds(212, 60, 99, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FilePath.class.getResource("/icons/file_75.png")));
		lblNewLabel.setBounds(10, 11, 74, 75);
		contentPane.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(94, 60, 99, 23);
		contentPane.add(btnCancelar);

	}
}
