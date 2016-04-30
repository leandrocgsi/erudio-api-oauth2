package br.com.erudio.restclient.gateway;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;

import br.com.erudio.restclient.model.AddressInfo;

@Repository
public class AddressInfoGateway {

    public AddressInfo findAddressInfoByCEP(String cep) {
    	AddressInfo addressInfo = new AddressInfo();
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(AddressInfoGateway.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            URL url = new URL("http://cep.desenvolvefacil.com.br/BuscarCep.php?cep=" + cep + "&ret=xml");
            addressInfo = (AddressInfo) unmarshaller.unmarshal(url);
        } catch (JAXBException ex) {
            Logger.getLogger(AddressInfoGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AddressInfoGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
		return addressInfo;
    }
}