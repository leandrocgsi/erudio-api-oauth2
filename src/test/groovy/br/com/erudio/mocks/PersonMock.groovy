package br.com.erudio.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.erudio.model.Address;
import br.com.erudio.model.AddressType;
import br.com.erudio.model.City;
import br.com.erudio.model.Gender;
import br.com.erudio.model.Person;
import br.com.erudio.model.PublicAreaType;
import br.com.erudio.model.State;

class PersonMock {
	
	ArrayList<Person> mockPersonsList(Integer quantity) {
		ArrayList<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < quantity; i++) persons.add(mockPerson(i));
		persons;
	}

	Person mockPerson(int i) {
		Person person = new Person();
		person.setAddresses(mockAddresses(i));
		person.setBirthDayDate(new Date());
		person.setCpf("175.321.061-3" + i);
		person.setEmail("a@b.c");
		person.setGender(mockGender(i));
		person.setIdPerson(i + 1);
		person.setInsertDate(new Date());
		person.setLogin("login" + 1);
		person.setName("ONE PERSON " + 1);
		person.setPassword("123456" + 1);
		person.setPermission("ADMIN");
		person.setPhone("+55(34)91234-567" + 1);
		person;
	}

	List<Address> mockAddresses(int i) {
		ArrayList<Address> addresses = new ArrayList<Address>();
		for (int j = 0; j < i; j++) addresses.add(mockAddress(j));
		addresses;
	}

	Address mockAddress(int j) {
		Address address = new Address();
		address.setAddressType(mockAddressType(j));
		address.setCity(mockCity(j));
		address.setComplement("SOME COMPLEMENT " + j);
		address.setIdAddress(j);
		address.setNeighborhood("SOME NEIGHBORHOOD " + j);
		address.setNumber(j);
		address.setPostalCode("34700-37" + j);
		address.setPublicAreaType(mockPublicAreaType());
		address.setState(mockState(j));
		address.setStreetName("STREET NAME " + j);
		address;
	}

	State mockState(int j) {
		State state = new State();
		state.setIdState(1);
		state.setStateName("SOME STATE NAME");
		state;
	}

	PublicAreaType mockPublicAreaType() {
		PublicAreaType publicAreaType = new PublicAreaType();
		publicAreaType.setIdPublicAreaType(1);
		publicAreaType.setPublicAreaTypeDescription("MALE");
		publicAreaType;
	}

	City mockCity(int j) {
		City city = new City();
		city.setIdCity(1);
		city.setName("CITY " + j);
		city;
	}

	AddressType mockAddressType(int j) {
		AddressType addressType = new AddressType();
		addressType.setIdAddressType(1);
		addressType.setDescription("ADDRESS TYPE " + j);
		addressType;
	}

	Gender mockGender(int i) {
		if((1 % 2) == 0) mockMale();
		mockFemale();
	}

	Gender mockFemale() {
		Gender gender = new Gender();
		gender.setIdGender(1);
		gender.setDescription("MALE");
		gender;
	}

	Gender mockMale() {
		Gender gender = new Gender();
		gender.setIdGender(2);
		gender.setDescription("FEMALE");
		gender;
	}
}