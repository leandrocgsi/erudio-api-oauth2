package br.com.erudio.service.reporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.erudio.fakedata.DataBean;
import br.com.erudio.fakedata.DataBeanMaker;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Reporter {
        
    public File makeReport() throws Exception {
	
    		InputStream inputStream = getClass().getResourceAsStream("template/test_jasper.jrxml");
            
            DataBeanMaker dataBeanMaker = new DataBeanMaker();
            ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
           
            @SuppressWarnings("rawtypes")
			Map parameters = new HashMap();
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
            File pdf = File.createTempFile("output.", ".pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
            return pdf;
    }
}