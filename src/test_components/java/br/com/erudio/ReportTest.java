package br.com.erudio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;

import br.com.erudio.fakedata.DataBean;
import br.com.erudio.fakedata.DataBeanMaker;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReportTest {

	private static Logger log = Logger.getAnonymousLogger();

	@Test
	public void reportTest() throws FileNotFoundException, JRException {

		long start = System.currentTimeMillis();

		String currentDirectory = System.getProperty("user.dir");
		String complementarDirectory = "//src//main//resources//br//com//erudio//service//reporter//template//";
		String jrxmlPath = currentDirectory + complementarDirectory + "test_jasper.jrxml";

		log.info(jrxmlPath);

		InputStream inputStream = new FileInputStream(jrxmlPath);

		DataBeanMaker dataBeanMaker = new DataBeanMaker();
		ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();

		log.info("Setting the data in a JRBeanCollectionDataSource of Jasper. Hitherto been spent "
				+ calculaTempo(start) + " seconds");

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

		@SuppressWarnings("rawtypes")
		Map parameters = new HashMap();

		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

		log.info("Creating a JasperPrint. Hitherto been spent " + calculaTempo(start) + " seconds");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

		log.info("Starting exporting to PDF. Hitherto been spent " + calculaTempo(start) + " seconds");

		JasperExportManager.exportReportToPdfFile(jasperPrint, System.getProperty("user.dir") + "\\target\\test_jasper.pdf");
		log.info("Finished. Hitherto been spent " + calculaTempo(start) + " seconds");
	}

	private static long calculaTempo(Long start) {
		return ((System.currentTimeMillis() - start) / 1000);
	}

}
