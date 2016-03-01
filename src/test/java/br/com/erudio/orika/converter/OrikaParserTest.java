package br.com.erudio.orika.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.erudio.orika.mocks.MockInputObject;
import br.com.erudio.orika.objects.OutputObject;

public class OrikaParserTest {

    MockInputObject inputObject;

    @Before
    public void setUp() {
        inputObject = new MockInputObject();
    }

    @Test
    public void parseObjectInputToObjectOutputTest() {
        OutputObject output = OrikaParser.parseObjectInputToObjectOutput(inputObject.mockInput(), OutputObject.class);
        assertEquals("Name Test", output.getName());
        assertEquals("Old City", output.getAddress().getTown());
        assertTrue(output.getAge() == 21);
    }

    @Test
    public void parserListObjectInputToObjectOutputTest() {
        List<OutputObject> output = OrikaParser.parserListObjectInputToObjectOutput(inputObject.mockInputList(), OutputObject.class);
        assertEquals("Name Test 2", output.get(0).getName());
        assertEquals("Old City", output.get(0).getAddress().getTown());
        assertTrue(output.get(0).getAge() == 22);
    }
}