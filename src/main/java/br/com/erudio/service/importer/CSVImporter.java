package br.com.erudio.service.importer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class CSVImporter {

    public List<Person> readCSV(InputStream input){
        try {
            Iterable<CSVRecord> records;
            records = CSVFormat.RFC4180.parse(new InputStreamReader(input));
            Iterator<CSVRecord> iterator = records.iterator();
            iterator.next();
            return getPersonsList(iterator);
        } catch (IOException e) {
            throw new ApplicationContextException("Loadfile Error");
        }
    }

    private List<Person> getPersonsList(Iterator<CSVRecord> iterator) {
        List<Person> persons = new ArrayList<Person>();
        while (iterator.hasNext()) {
            Person person = getPerson(iterator);
            persons.add(person);
        }
        return persons;
    }

    private Person getPerson(Iterator<CSVRecord> iterator) {
        CSVRecord record = iterator.next();
        Person person = new Person();

        person.setName(record.get(0));
        person.setEmail(record.get(1));
        person.setPhone(record.get(2));
        person.setCpf(record.get(3));
//                person.setBirthDayDate(record.get(4));
        person.setLogin(record.get(5));
        person.setPassword(record.get(6));
        person.setPermission(record.get(7));
//                person.setGender(record.get(7));
        return person;
    }
}