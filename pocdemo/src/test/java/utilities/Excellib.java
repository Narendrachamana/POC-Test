package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import accelerators.Actiondriver;

public class Excellib {
	
	public static XSSFWorkbook wrkBookObj;
	public static XSSFSheet wrkSheetObj;
	
	
	
	public static  XSSFSheet getSheetObject(String inputDataFilePath, String SheetName) throws Exception
	{
		FileInputStream file = new FileInputStream(new File(inputDataFilePath));
		wrkBookObj = new XSSFWorkbook(file) ;
		wrkSheetObj= wrkBookObj.getSheet(SheetName);		
		return wrkSheetObj;
	}
	
	
 
	
	
	public static String getSheetCellData(String sColumnName, int iRowCount) throws Exception
	{
    	String cellData=null;
		int SheetColCount=Actiondriver.objInputSheet.getRow(0).getPhysicalNumberOfCells();
		for(int Colcnt=0;Colcnt<SheetColCount;Colcnt++)
		{
			if(Actiondriver.objInputSheet.getRow(0).getCell(Colcnt).getStringCellValue().equals(sColumnName))
				{
				cellData=Actiondriver.objInputSheet.getRow(iRowCount).getCell(Colcnt).getStringCellValue();
				return cellData;
				}
			
		}				
		return "";
	}


}
