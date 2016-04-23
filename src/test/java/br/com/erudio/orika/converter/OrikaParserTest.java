package br.com.erudio.orika.converter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import br.com.erudio.converter.ObjectParser;
import br.com.erudio.mocks.PersonMock;
import br.com.erudio.mocks.PersonMockFromJSON;
import br.com.erudio.vo.PersonVO;

public class OrikaParserTest {

	PersonMock inputObject;

    @Before
    public void setUp() {
    	inputObject = new PersonMock();
    }

    @Test
    public void parsePersonEntityToPersonVOTest() {
        PersonVO output = ObjectParser.parseObjectInputToObjectOutput(inputObject.mockPerson(1), PersonVO.class);
        System.out.println(output.getAddresses().get(0).getPostalCode());
        assertEquals("ONE PERSON 1", output.getName());
        assertEquals("34700-370", output.getAddresses().get(0).getPostalCode());
    }

    @Test
    public void parseListPersonsEntityToPersonsVOTest() {
        List<PersonVO> persons = ObjectParser.parserListObjectInputToObjectOutput(inputObject.mockPersonsList(9), PersonVO.class);
        assertEquals("ONE PERSON 1", persons.get(0).getName());
        assertEquals("34700-370", persons.get(1).getAddresses().get(0).getPostalCode());
        assertEquals("34700-371", persons.get(2).getAddresses().get(1).getPostalCode());
        assertEquals("34700-372", persons.get(3).getAddresses().get(2).getPostalCode());
    }
    
    @Test
	public void parsePersonEntityToPersonVOFromJSONTest(){
        PersonVO output = ObjectParser.parseObjectInputToObjectOutput(mockPersonFromJSON(), PersonVO.class);
        System.out.println(output.getAddresses().get(0).getPostalCode());
        assertEquals("ONE PERSON 1", output.getName());
        assertEquals("34700-370", output.getAddresses().get(0).getPostalCode());
	}

	public PersonVO mockPersonFromJSON(){
		PersonVO person = new PersonVO();
		try {
			person = new ObjectMapper().readValue(PersonMockFromJSON.PERSON, PersonVO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return person;
	}
	
	public ArrayList<PersonVO> mockPersonsFromJSON(){
//		ArrayList<PersonVO> dtoFromJSON = new ArrayList<PersonVO>();
//		try {
//			dtoFromJSON = new ObjectMapper().readValue(PersonsMockFromJSON.PERSONS, PersonVO.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return new ArrayList<PersonVO>();
	}
    
}