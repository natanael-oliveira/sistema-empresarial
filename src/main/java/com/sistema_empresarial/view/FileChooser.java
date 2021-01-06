package com.sistema_empresarial.view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
	private JFileChooser fileChooser = new JFileChooser();
	private String title;
	private String extencion;
	private String fileName;
	
	public FileChooser() {}
	
	public FileChooser(String title, String extencion, String fileName) {
		super();
		this.title = title;
		this.extencion = extencion;
		this.fileName = fileName;
	}
	
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExtencion() {
		return extencion;
	}

	public void setExtencion(String extencion) {
		this.extencion = extencion;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public JFileChooser fileSave() {
		this.fileChooser.setBounds(0, 0, 610, 353);
		this.fileChooser.setDialogTitle(title);
		this.fileChooser.setSelectedFile(new File(fileName));
		this.fileChooser.setAcceptAllFileFilterUsed(true);
		FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Formato ."+extencion,extencion);
		this.fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
		this.fileChooser.setDefaultLocale(null);
		return this.fileChooser;
	}
}
