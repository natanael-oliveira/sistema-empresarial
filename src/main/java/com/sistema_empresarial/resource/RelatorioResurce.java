package com.sistema_empresarial.resource;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.sistema_empresarial.model.Relatorio;
import com.sistema_empresarial.util.JDBCConnection;
import com.sistema_empresarial.util.Relatorios;
import com.sistema_empresarial.view.FileChooser;
import com.sistema_empresarial.view.RelatorioProgress;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.annotations.ExporterParameter;

public class RelatorioResurce {
	RelatorioProgress progress = new RelatorioProgress();
	public RelatorioResurce(){
	}
	public void gerar(int type,String saidaPath){
		String jrxml = new File(Relatorios.getInstance().getRelatorios().get(type).getPath()).getAbsolutePath();
		try {
			FileOutputStream saida = new FileOutputStream(saidaPath);
			gerarPdf(jrxml, null, saida,saidaPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void showSaveDialog(int index) {
		FileChooser fileChooser = new FileChooser("Gerar Relatório","pdf","Relatório.pdf");
		int i = fileChooser.fileSave().showSaveDialog(null);
		if(i == 0) {
			progress.setVisible(true);
			gerar(index,fileChooser.getFileChooser().getSelectedFile().getPath());
		}else {
		}
	}
	public void gerarPdf(String jrxml,Map<String,Object> parametros,FileOutputStream saida,String saidaPath) {
		try {
			progress.progressBar.setIndeterminate(false);
			progress.stringProgress.setText("Compilando...");
			progress.progressBar.setValue(25);
			JasperReport jasperFile = JasperCompileManager.compileReport(jrxml);
			progress.stringProgress.setText("Inserindo dados do banco...");
			progress.progressBar.setValue(50);
			JasperPrint print = JasperFillManager.fillReport(jasperFile,parametros,JDBCConnection.getInstance().getConnection());
			progress.stringProgress.setText("Exportando...");
			progress.progressBar.setValue(75);
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,saida);
			exporter.exportReport();
			progress.stringProgress.setText("Concluído!");
			progress.progressBar.setValue(100);
			try {
				int option = JOptionPane.showConfirmDialog(null,"Deseja abrir o documento?");
				if(option == 0) {
					Desktop desktop = Desktop.getDesktop();
					desktop.open(new File(saidaPath));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	public static class ProgressGerarPdf extends Thread {
		@Override
		public void run() {
			
		}
	}
}
