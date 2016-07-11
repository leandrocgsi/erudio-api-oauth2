package br.com.erudio.repository.implementations;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.erudio.repository.interfaces.IImportRepository;
import br.com.erudio.service.importer.CSVImporter;
import br.com.erudio.service.importer.ImportExample;
import br.com.erudio.service.importer.XLSXImporter;

@Repository
@Transactional(readOnly = true)
public class ImporterRepository implements IImportRepository, Serializable{

    private static final long serialVersionUID = 1L;

    @Autowired
    private XLSXImporter baseQuestionXLSXImporter;

    @Autowired
    private CSVImporter baseQuestionCSVImporter;

    public List<ImportExample> importFile(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename().toLowerCase();

        InputStream inputStream = file.getInputStream();

        if(fileName.endsWith(".xlsx")) return baseQuestionXLSXImporter.readXLSX(inputStream);
        else if(fileName.endsWith(".csv")) return baseQuestionCSVImporter.readCSV(inputStream);
        else throw new Exception("Invalid Format");
    }
}
