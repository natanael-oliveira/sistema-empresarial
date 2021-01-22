package com.sistema_empresarial.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sistema_empresarial.model.Funcionario;
import com.sistema_empresarial.resource.FuncionarioResource;
import com.sistema_empresarial.tableModel.FuncionarioTM;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.TextField;

public class FuncionarioCreate extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	FuncionarioResource funcionarioResource = new FuncionarioResource();
	private JTextField textField_cargo;
	
	public FuncionarioCreate() {
		
		setTitle("Cadastrar Funcionário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 332, 217);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lbl_name = new JLabel("Nome:");
		lbl_name.setBounds(10, 15, 46, 14);
		contentPane.add(lbl_name);
		
		textField_name = new JTextField();
		textField_name.setBounds(10, 36, 294, 27);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lbl_cargo = new JLabel("Cargo:");
		lbl_cargo.setBounds(10, 71, 46, 14);
		contentPane.add(lbl_cargo);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCampos();
				dispose();
			}
		});
		btn_cancelar.setBounds(47, 144, 95, 23);
		contentPane.add(btn_cancelar);
		
		JButton btn_salvar = new JButton("Salvar");
		btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setName(textField_name.getText());
				funcionario.setJob(textField_cargo.getText());
				funcionarioResource.save(funcionario);
				FuncionarioTM.getInstance().addRow(funcionario);
				clearCampos();
				dispose();
			}
		});
		btn_salvar.setBounds(182, 144, 95, 23);
		contentPane.add(btn_salvar);
		
		textField_cargo = new JTextField();
		textField_cargo.setColumns(10);
		textField_cargo.setBounds(10, 92, 294, 27);
		contentPane.add(textField_cargo);
		
	}
	
	public void clearCampos(){
		textField_name.setText("");
		textField_cargo.setText("");
	}
}
