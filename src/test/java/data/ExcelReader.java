package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream file=null;
	public FileInputStream getFileInputStream()
	{
		String filePath= System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx";
		File srcFile=new File(filePath);
		try {
			file=new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured" +e.getMessage());
			System.exit(0);
		}
		return file;
	}
	
	public Object[][] getExcelData()   throws IOException
	{
		file=getFileInputStream();
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet= wb.getSheetAt(0);
		int totalNumberOfRows=	(sheet.getLastRowNum()+1);
		int totalNumberofCol=4;
		String[][] arrayExcelData=new String[totalNumberOfRows][totalNumberofCol];
		for (int i = 0; i < totalNumberOfRows; i++) {
			for (int j = 0; j < totalNumberofCol; j++) {
				XSSFRow row=sheet.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
	}
	
}
