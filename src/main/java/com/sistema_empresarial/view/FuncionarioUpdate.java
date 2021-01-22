package com.sistema_empresarial.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sistema_empresarial.resource.FuncionarioResource;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncionarioUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String nome;
	private String cargo;
	private Long id;
	private int indexSelected;
	
	public FuncionarioUpdate(Long j,String nome, String cargo,int i){
		this.indexSelected = i;
		this.id = j;
		this.nome = nome;
		this.cargo = cargo;
		setLocationRelativeTo(null);
		setTitle("Atualizar Funcionário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 332, 217);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 296, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 32, 296, 27);
		textField.setText(nome);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cargo:");
		lblNewLabel_1.setBounds(10, 70, 296, 21);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 90, 296, 27);
		textField_1.setText(cargo);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioResource funcionarioResource = new FuncionarioResource();
				funcionarioResource.update(id,textField.getText(),textField_1.getText(),indexSelected);
				dispose();
			}
		});
		btnNewButton.setBounds(177, 144, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(46, 144, 95, 23);
		contentPane.add(btnNewButton_1);
	}
}
