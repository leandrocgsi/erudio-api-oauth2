package br.com.erudio.fakedata;

import java.util.ArrayList;
import java.util.logging.Logger;

public class DataBeanMaker {
	
    private Logger log = Logger.getAnonymousLogger();
    
	public ArrayList<DataBean> getDataBeanList() {
		
		ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

		log.info("Creating the guys");
		
	    dataBeanList.add(produce("Babji, Chetty", "Engineer", "Nuremberg", "Germany"));
		dataBeanList.add(produce("Albert Einstein", "Engineer", "Ulm", "Germany"));
		dataBeanList.add(produce("Alfred Hitchcock", "Movie Director", "London", "UK"));
		dataBeanList.add(produce("Wernher Von Braun", "Rocket Scientist", "Wyrzysk", "Poland (Previously Germany)"));
		dataBeanList.add(produce("Sigmund Freud", "Neurologist", "Pribor", "Czech Republic (Previously Austria)"));
		dataBeanList.add(produce("Mahatma Gandhi", "Lawyer", "Gujarat", "India"));
		dataBeanList.add(produce("Sachin Tendulkar", "Cricket Player", "Mumbai", "India"));
		dataBeanList.add(produce("Michael Schumacher", "F1 Racer", "Cologne", "Germany"));
		for (int i = 0; i < 100; i++) {
			dataBeanList.add(produce("No famous person " + i, "Normal Occupation" + i, "One Place" + i, "One Country" + i));
		}
		dataBeanList.add(produce("Leandro Costa", "Nomad Programmer", "Uberlândia - Patos de Minas - Brasília", "Brazil"));
		log.info("Guys created");
		return dataBeanList;
	}

	private DataBean produce(String name, String occupation, String place, String country) {
		DataBean dataBean = new DataBean();

		dataBean.setName(name);
		dataBean.setOccupation(occupation);
		dataBean.setPlace(place);
		dataBean.setCountry(country);

		return dataBean;
	}
}
