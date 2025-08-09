package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReaderTestNg {
	
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;	
	public XSSFSheet sheet;
      Properties prop;
	ConfigReaderTest config;
	
public ExcelReaderTestNg() throws IOException {
	this.config= new ConfigReaderTest();
	this.path= config.readConfig().getProperty("path");
}
// to get row count 


@DataProvider(name="dataPro")
public List<String> readData(String colName) throws IOException {
	List<String> dataList = new ArrayList<>();
	fis = new FileInputStream(path);
	workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("TestData");
	
	// Header Row 
	XSSFRow headerRow = sheet.getRow(0); 
    int totalRows = sheet.getPhysicalNumberOfRows(); 
	
    int colIndex = -1;
    for (Cell cell : headerRow) {
    	if(cell.getStringCellValue().trim().equalsIgnoreCase(colName)) {
    		colIndex = cell.getColumnIndex();
    		break;
    	}
		
	}
    if (colIndex == -1) {
        workbook.close();
        throw new IllegalArgumentException("Column '" + colName + "' not found in sheet.");
    }
    
 // Start from row 1 (excluding header)
    for (int i = 1; i < totalRows; i++) {
        XSSFRow row = sheet.getRow(i);
        if (row != null) {
            Cell cell = row.getCell(colIndex);
            String value = (cell != null) ? cell.toString() : "";
            dataList.add(value);
        }
    }
    workbook.close();
    fis.close();
	return dataList;
    
}



//@DataProvider(name="dataPro")
//public String[][] getCellData(String sheetName, int row, int col) throws IOException {	
//	fis = new FileInputStream(path);
//	workbook= new XSSFWorkbook(fis);
//	sheet=workbook.getSheet(sheetName);
//	int rowCount = sheet.getPhysicalNumberOfRows();
//	int cellCount = sheet.getRow(0).getLastCellNum();
//	String[][] data = new String[rowCount-1	][cellCount];
//    for(int i=0;i<rowCount-1;i++) {
//	for(int j=0;j<cellCount;j++) {	
//		XSSFCell cellData = sheet.getRow(i+1).getCell(j);
//		DataFormatter df = new DataFormatter();
//		data[i][j] = df.formatCellValue(cellData);
//		
//	}
//	System.out.println();
//}
//	workbook.close();
//	fis.close();
//	
//	return data;
//	
//}

@DataProvider(name="dataPro")
public String[][] getCellData() throws IOException {	
	fis = new FileInputStream(path);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheetAt(0);
	int rowCount = sheet.getPhysicalNumberOfRows();
	int cellCount = sheet.getRow(0).getLastCellNum();
	String[][] data = new String[rowCount-1	][cellCount];
    for(int i=0;i<rowCount-1;i++) {
	for(int j=0;j<cellCount;j++) {	
		XSSFCell cellData = sheet.getRow(i+1).getCell(j);
		DataFormatter df = new DataFormatter();
		data[i][j] = df.formatCellValue(cellData);
	}
	System.out.println();
}
	workbook.close();
	fis.close();
	return data;	
}
}
