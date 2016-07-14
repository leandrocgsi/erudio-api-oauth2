package br.com.erudio.repository.interfaces;

import java.io.InputStream;
import java.util.List;

import br.com.erudio.model.Person;

public interface IImportRepository {

	List<Person> importFile(InputStream file, String fileName) throws Exception;
    
}