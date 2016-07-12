package br.com.erudio.repository.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.erudio.model.Person;

public interface IImportRepository {

	List<Person> importFile(MultipartFile file) throws Exception;
    
}