package com.comcast.crm.generic.fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	public String getDataFromExcelFile(String filePath, String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowCountOfSheet(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	public int getRowCountOfSheet(String filPath, String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(filPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	public void setDataToExcelFile(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testData/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}

	public Object[][] getDataFromDataProvider(String sheetName) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetName).getLastRowNum();
		int lastCellNum = wb.getSheet(sheetName).getRow(0).getLastCellNum();

		Object[][] objArr = new Object[lastRowNum][lastCellNum];
		for (int i = 0; i < lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				objArr[i][j] = wb.getSheet(sheetName).getRow(i + 1).getCell(j).toString();
			}
		}
		wb.close();
		return objArr;
	}

	public String getDataFromExcelFile(String sheetName, String testCaseID, String reqKey) throws Throwable {
		String actTCID = "";
		String actKey = "";
		String data = "";
		boolean flag = false;
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			try {
				actTCID = sh.getRow(i).getCell(0).getStringCellValue();
			} catch (Exception e) {
			}
			if (actTCID.equalsIgnoreCase(testCaseID)) {
				for (int j = 1; j < sh.getRow(i).getLastCellNum(); j++) {
					try {
						actKey = sh.getRow(i - 1).getCell(j).getStringCellValue();
					} catch (Exception e) {
					}
					if (actKey.equalsIgnoreCase(reqKey)) {
						try {
							data = sh.getRow(i).getCell(j).getStringCellValue();
						} catch (Exception e) {
						}
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
		}
		wb.close();
		return data;
	}

	public String getDataFromExcelFile(String filePath, String sheetName, String testCaseID, String reqKey)
			throws Throwable {
		String actTCID = "";
		String actKey = "";
		String data = "";
		boolean flag = false;
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			try {
				actTCID = sh.getRow(i).getCell(0).getStringCellValue();
			} catch (Exception e) {
			}
			if (actTCID.equalsIgnoreCase(testCaseID)) {
				for (int j = 1; j < sh.getRow(i).getLastCellNum(); j++) {
					try {
						actKey = sh.getRow(i - 1).getCell(j).getStringCellValue();
					} catch (Exception e) {
					}
					if (actKey.equalsIgnoreCase(reqKey)) {
						try {
							data = sh.getRow(i).getCell(j).getStringCellValue();
						} catch (Exception e) {
						}
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
		}
		wb.close();
		return data;
	}
	
	public static Map<String, Object> getRowAsMap(String filePath, String sheetName, String uniqueData) {
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
}
