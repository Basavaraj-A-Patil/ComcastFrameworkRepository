package practice.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.ss.usermodel.*;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class ExcelDataReader {

    public static Map<String, Object> getRowAsMap(String uniqueData,String sheetName, String filePath) {
        Map<String, Object> resultMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();

            // Get header row for column names
            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(cell.getStringCellValue());
            }

            // Process rows
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getCell(0).getStringCellValue().equals(uniqueData)) { // Assuming uniqueData is in the first column
                    for (int i = 0; i < headers.size(); i++) {
                        Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        switch (cell.getCellType()) {
                            case STRING:
                                resultMap.put(headers.get(i), cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                resultMap.put(headers.get(i), cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                resultMap.put(headers.get(i), cell.getBooleanCellValue());
                                break;
                            default:
                                resultMap.put(headers.get(i), null);
                        }
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    public static void main(String[] args) {
        String uniqueData = "HT001"; // Replace with actual key value
        String filePath = "C:\\Users\\User\\Downloads\\Simpson_TestData_Sheet.xlsx"; // Replace with actual file path
        String sheetName = "Home";
        Map<String, Object> data = getRowAsMap(uniqueData,sheetName, filePath);

        // Print the data
        data.forEach((key, value) -> System.out.println(key + ": " + value));
        
        ExcelUtility eLib = new ExcelUtility();
        Map<String, Object> data1 = eLib.getRowAsMap(filePath, sheetName, uniqueData);
        System.out.println();
    }
}
