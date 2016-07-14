package br.com.erudio.repository.implementations;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.Person;
import br.com.erudio.repository.interfaces.IImportRepository;
import br.com.erudio.service.importer.CSVImporter;
import br.com.erudio.service.importer.XLSXImporter;

@Repository
@Transactional(readOnly = true)
public class ImporterRepository implements IImportRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @Autowired
    private XLSXImporter xlsxImporter;

    @Autowired
    private CSVImporter baseQuestionCSVImporter;

    public List<Person> importFile(InputStream inputStream, String fileName) throws Exception {
        if(fileName.endsWith(".xlsx")) return xlsxImporter.readXLSX(inputStream);
        else if(fileName.endsWith(".csv")) return baseQuestionCSVImporter.readCSV(inputStream);
        else throw new Exception("Invalid Format");
    }
}
