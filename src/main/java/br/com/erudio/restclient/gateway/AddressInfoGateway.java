package br.com.erudio.restclient.gateway;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import br.com.erudio.restclient.model.AddressInfo;

@Repository
public class AddressInfoGateway {

	private Logger logger = Logger.getLogger(AddressInfoGateway.class);
	
    public AddressInfo findAddressInfoByCEP(String cep) {
    	AddressInfo addressInfo = new AddressInfo();
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(AddressInfoGateway.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String urlAddress = "http://cep.desenvolvefacil.com.br/BuscarCep.php?cep=" + cep + "&ret=xml";
            logger.info("Getting addres info from " + urlAddress);
			URL url = new URL(urlAddress);
            addressInfo = (AddressInfo) unmarshaller.unmarshal(url);
        } catch (JAXBException ex) {
        	logger.fatal(ex);
        } catch (MalformedURLException ex) {
        	logger.fatal(ex);
        }
		return addressInfo;
    }
}