package br.com.erudio.service.reporter;

import org.springframework.stereotype.Repository;

import br.com.erudio.fakedata.DataBean;
import br.com.erudio.fakedata.DataBeanMaker;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Repository
class Reporter {
        
    File makeReport() throws Exception {
	
    	DataBeanMaker dataBeanMaker = new DataBeanMaker();
		InputStream inputStream = getClass().getResourceAsStream("template/test_jasper.jrxml");
        
        ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		Map parameters = new HashMap();
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
        File pdf = File.createTempFile("output.", ".pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
        return pdf;
    }
}