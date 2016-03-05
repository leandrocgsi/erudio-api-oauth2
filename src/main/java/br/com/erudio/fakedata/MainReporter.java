package br.com.erudio.fakedata;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class MainReporter {

	private static Logger log = Logger.getAnonymousLogger();
	
	/*public static void main(String[] args) throws Exception {
		
//		DefaultJasperReportsContext context = DefaultJasperReportsContext.getInstance();
//		JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.xpath.executer.factory", "net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");
		long start = System.currentTimeMillis();
		
		String currentDirectory = System.getProperty("user.dir");
		String complementarDirectory = "//src//main//resources//br//com//erudio//service//reporter//template//";
		String jrxmlPath = currentDirectory + complementarDirectory + "test_jasper.jrxml";
		
//		----------------
		
	//  URL url = getClass().getClassLoader().getResource("../template/test_jasper.jrxml");
//		String jrxmlDirectory =  getClass().getClassLoader().getSystemResource("../template/test_jasper.jrxml").getPath();
		
//		----------------
		log.info(jrxmlPath);
		
		InputStream inputStream = new FileInputStream(jrxmlPath);

		DataBeanMaker dataBeanMaker = new DataBeanMaker();
		ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();

		log.info("Setting the data in a JRBeanCollectionDataSource of Jasper. Hitherto been spent " + calculaTempo(start) + " seconds");
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

		@SuppressWarnings("rawtypes")
		Map parameters = new HashMap();

		
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);


		log.info("Creating a JasperPrint. Hitherto been spent " + calculaTempo(start) + " seconds");
		
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
		

		log.info("Starting exporting to PDF. Hitherto been spent " + calculaTempo(start) + " seconds");
		
		JasperExportManager.exportReportToPdfFile(jasperPrint,
				"C:/Users/LEANDRO/Desktop/test_jasper.pdf");
		log.info("Finished. Hitherto been spent " + calculaTempo(start) + " seconds");
	}

	private static long calculaTempo(Long start) {
		return ((System.currentTimeMillis() - start) / 1000);
	}*/
}
