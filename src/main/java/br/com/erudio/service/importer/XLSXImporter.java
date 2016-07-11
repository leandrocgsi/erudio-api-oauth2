package br.com.erudio.service.importer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class XLSXImporter {

    public List<ImportExample> readXLSX(InputStream input) {
        try {
            List<ImportExample> listQuestions = new ArrayList<ImportExample>();
            XSSFWorkbook wBook = new XSSFWorkbook(input);
            XSSFSheet sheet = wBook.getSheetAt(0);
            Row row;

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                if(row.getCell(0) != null && row.getCell(0).getCellType() != Cell.CELL_TYPE_BLANK &&
                   row.getCell(1) != null && row.getCell(1).getCellType() != Cell.CELL_TYPE_BLANK &&
                   row.getCell(2) != null && row.getCell(2).getCellType() != Cell.CELL_TYPE_BLANK &&
                   row.getCell(3) != null && row.getCell(3).getCellType() != Cell.CELL_TYPE_BLANK) {

                    ImportExample importExample = new ImportExample();
                    importExample.setQuestion_pt_br(row.getCell(3)!=null?row.getCell(3).getStringCellValue():null);
                    importExample.setFactor_pt_br(row.getCell(6)!=null?row.getCell(6).getStringCellValue():null);
                    importExample.setScale(row.getCell(7)!=null?row.getCell(7).getStringCellValue():null);
                    importExample.setOxygen_behavior_number(row.getCell(8)!=null?(int)row.getCell(8).getNumericCellValue():null);
                    importExample.setOxygen_behavior(row.getCell(9)!=null?row.getCell(9).getStringCellValue():null);
                    importExample.setGrid_intro_text(row.getCell(10)!=null?row.getCell(10).getStringCellValue():null);
                    listQuestions.add(importExample);
                }
            }
            //wBook.close();
            return listQuestions;
        } catch (Exception ioe) {
            ioe.printStackTrace();
            throw new ApplicationContextException("Loadfile Error");
        }
    }
}
