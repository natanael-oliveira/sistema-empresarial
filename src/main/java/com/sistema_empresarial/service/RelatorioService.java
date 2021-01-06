package com.sistema_empresarial.service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.sistema_empresarial.util.JDBCConnection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class RelatorioService {
	public void gerarPdf(String jrxml,Map<String,Object> parametros,FileOutputStream saida,String saidaPath) {
		try {
			System.out.println("Buscando jrxml em: "+jrxml);
			System.out.println("Compilando...");
			JasperReport jasperFile = JasperCompileManager.compileReport(jrxml);
			System.out.println("Inserindo dados do banco...");
			JasperPrint print = JasperFillManager.fillReport(jasperFile,parametros,JDBCConnection.getInstance().getConnection());
			System.out.println("Exportando arquivo para: "+saidaPath);
			System.out.println("Exportando...");
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,saida);
			exporter.exportReport();
			System.out.println("Concluído!");
			Desktop desktop = Desktop.getDesktop();
			System.out.println("Abrindo Arquivo...");
			try {
				desktop.open(new File(saidaPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
