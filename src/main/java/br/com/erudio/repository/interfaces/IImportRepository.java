package br.com.erudio.repository.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.erudio.service.importer.ImportExample;

public interface IImportRepository {

    List<ImportExample> importFile(MultipartFile file) throws Exception;
    
}