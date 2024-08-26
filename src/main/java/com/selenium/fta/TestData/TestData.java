package com.selenium.fta.TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



//HSSF Class--.xls

//XSSF Class --.xlsx


public class TestData 
{
	static Workbook Wbook = null;
	static Sheet sheetobj  = null;
	public static Map<String,String> TDMap = null;
	
public static void getWorkBookIbj() throws IOException
		{
			FileInputStream fis = new FileInputStream("TestData\\TestData.xlsx");
			Wbook  = new XSSFWorkbook(fis);
			
		}
		
public static void getworksheet()
		{
	  
			sheetobj = Wbook.getSheet("TestData");
		}
		
public static int getrowcount()
		{
			int rowcnt = sheetobj.getPhysicalNumberOfRows();
			return rowcnt;
		}
		
public static int columncnt()
		{
			Row rowobj = sheetobj.getRow(0);
			int columncnt = rowobj.getPhysicalNumberOfCells();
			return columncnt;
		}
		
public static int getdesirerownum(String TCID) throws IOException
		{
			int desirerow = 0;
			getWorkBookIbj();
			getworksheet();
			int rowcnt = getrowcount();
			int colcnt = columncnt();
			for(int i=1;i<=rowcnt;i++)
			{
				for(int j=1;j<=colcnt;j++)
				{
					Row rowobj = sheetobj.getRow(i);
					Cell cellobj = rowobj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					String dalaval = cellobj.getStringCellValue();
					if(dalaval.equalsIgnoreCase(TCID))
					{
						desirerow=i;
//						break;
					}
				}
				if(desirerow !=0)
				{
					break;
				}
				
			}
			return desirerow;
		}
		
	
 public static void GetactualScenarioData(String TCID) throws IOException
      {
	TDMap =new HashMap<String,String>();
	int rownumber = getdesirerownum(TCID);
	int colcnt = columncnt();
	//int rowcnt = getrowcount();
	
	for(int j=4;j<=colcnt;j++)
	{
		
		Row rowobj = sheetobj.getRow(rownumber);
		Cell cellobj = rowobj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		String KeyName =cellobj.getStringCellValue();
		Cell cellobj1 = rowobj.getCell(j+1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		String KeyValue = cellobj1.getStringCellValue();
		TDMap.put(KeyName, KeyValue);
		j=j+1;
		
	}
}

}
