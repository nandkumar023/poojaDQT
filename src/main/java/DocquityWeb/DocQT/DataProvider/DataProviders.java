package DocquityWeb.DocQT.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginTest")
	public static Object[][] getLoginData() throws IOException {
		DataFormatter formattor=new DataFormatter();
		FileInputStream fis = 
				new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/TestData/Login_TestData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0); //Collecting data from first sheet in the workbook. For switching 
		//between the sheets change the sheet number on line 56.
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int colCount=row.getLastCellNum();
		Object[][] data=new Object[rowCount-1][colCount]; //Memory allocation to multi dimension array
		for(int i=0; i<rowCount-1;i++) {
			row=sheet.getRow(i+1);
			for(int j=0;j<colCount;j++) {
				XSSFCell cell=row.getCell(j);
				data[i][j]=formattor.formatCellValue(cell);
				}
			}
		return data; //return data;
	}

}
