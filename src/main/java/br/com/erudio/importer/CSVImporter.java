package br.com.erudio.importer;

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

@Service
public class CSVImporter {

    public List<ImportExample> readCSV(InputStream input){
        try {
            Iterable<CSVRecord> records;
            records = CSVFormat.RFC4180.parse(new InputStreamReader(input));
            Iterator<CSVRecord> iterator = records.iterator();
            iterator.next();
            List<ImportExample> listQuestions = new ArrayList<ImportExample>();

            while (iterator.hasNext()) {
                CSVRecord record = iterator.next();
                ImportExample importExample = new ImportExample();

                importExample.setQuestion_pt_br(record.get(3));
                importExample.setFactor_pt_br(record.get(6));
                importExample.setScale(record.get(7));
                importExample.setOxygen_behavior(record.get(9));
                importExample.setGrid_intro_text(record.get(10));
                listQuestions.add(importExample);
            }
            return listQuestions;
        } catch (IOException e) {
            throw new ApplicationContextException("Loadfile Error");
        }
    }
}