package com.sistema_empresarial.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.sistema_empresarial.model.Relatorio;
import com.sistema_empresarial.service.RelatorioService;
import com.sistema_empresarial.util.JDBCConnection;
import com.sistema_empresarial.util.Relatorios;

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
	private RelatorioService relatorioService = new RelatorioService();
	public RelatorioResurce(){
	}
	public void gerar(int type,String saidaPath){
		String jrxml = new File(Relatorios.getInstance().getRelatorios().get(type).getPath()).getAbsolutePath();
		RelatorioService relatorioService = new RelatorioService();
		try {
			FileOutputStream saida = new FileOutputStream(saidaPath);
			relatorioService.gerarPdf(jrxml, null, saida,saidaPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
