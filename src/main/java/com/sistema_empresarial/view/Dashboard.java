package com.sistema_empresarial.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.sistema_empresarial.resource.FuncionarioResource;
import com.sistema_empresarial.tableModel.FuncionarioTableModel;
import com.sistema_empresarial.util.JPAConnector;

import javax.swing.JTable;
import javax.swing.JToolBar;
import java.awt.Button;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Canvas;
import javax.swing.BoxLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import java.awt.Point;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dashboard extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JProgressBar progressBar;
	private FuncionarioResource funcionarioResource = new FuncionarioResource();
	FuncionarioCreate cfd = new FuncionarioCreate();
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setResizable(false);
		setTitle("Dashboard de Funcionários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(104, 11, 296, 54);
		layeredPane.setBorder(new LineBorder(SystemColor.control, 1, true));
		layeredPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(7, 7, 41, 41);
		btnNewButton.setBackground(Color.WHITE);
		layeredPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/users.png")));

		final JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(funcionarioResource.remove(FuncionarioTableModel.getInstance().getColumnId(table.getSelectedRow()))) {
					FuncionarioTableModel.getInstance().removeRow(table.getSelectedRow());
				}
			}
		});
		
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/user_delete.png")));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(103, 7, 41, 41);
		layeredPane.add(btnNewButton_1_1);
		
		final JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setEnabled(false);
		btnNewButton_1_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/edit.png")));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(151, 7, 41, 41);
		layeredPane.add(btnNewButton_1_1_1);
		contentPane.add(layeredPane);
		
		JButton btnNewButton_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilePath rs = new FilePath();
				rs.setVisible(true);
			}
		});
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/file.png")));
		btnNewButton_1_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1_1.setBounds(199, 7, 41, 41);
		layeredPane.add(btnNewButton_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 139, 470, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(FuncionarioTableModel.getInstance());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_1_1.setEnabled(true);
				btnNewButton_1_1_1.setEnabled(true);
				
			}
		});
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setViewportView(table);
		
		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(false);
		progressBar.setBounds(128, 350, 357, 16);
		contentPane.add(progressBar);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Progress p = new Progress();
				p.start();
				table.setModel(FuncionarioTableModel.getInstance());
			}
		});
		btnNewButton_2.setBounds(18, 346, 99, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cfd.setVisible(true);
				btnNewButton_1_1.setEnabled(false);
				btnNewButton_1_1_1.setEnabled(false);
				table.clearSelection();
			}
		});
		btnNewButton_1.setBounds(55, 7, 41, 41);
		btnNewButton_1.setBackground(Color.WHITE);
		layeredPane.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/user_add.png")));		
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPAConnector.getInstance().closeConnection();
			}
		});
		btnNewButton_1_1_1_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/logout.png")));
		btnNewButton_1_1_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1_1_1.setBounds(247, 7, 41, 41);
		layeredPane.add(btnNewButton_1_1_1_1_1);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filtros de Busca", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		layeredPane_1.setBounds(18, 70, 470, 63);
		contentPane.add(layeredPane_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				FuncionarioTableModel.getInstance().buildFilter(textField.getText());
			}
		});
		textField.setColumns(10);
		textField.setBounds(243, 20, 213, 28);
		layeredPane_1.add(textField);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(186, 26, 47, 14);
		layeredPane_1.add(lblNewLabel);
		setLocationRelativeTo(null);
		
	}
	public class Progress extends Thread{
		@Override
		public void run() {
			super.run();
			try {
				progressBar.setStringPainted(true);
				while(progressBar.getValue() < 100) {
					sleep(3);
					progressBar.setValue(progressBar.getValue()+1);
					progressBar.setString(progressBar.getValue()+"%");
					if(progressBar.getValue() == 50) {
						FuncionarioTableModel.getInstance().build();
					}
				}
				sleep(1000);
				progressBar.setStringPainted(false);
				progressBar.setValue(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
