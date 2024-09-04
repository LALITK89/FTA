package com.selenium.fta.TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//HSSF Class--.xls

//XSSF Class --.xlsx

public class TestData
{
	static Workbook Wbook = null;
	static Sheet sheetobj  = null;
	public static Map<String, String> TDMap = null;
	
// To Initialize Workbook
public static void getWorkBookIbj() throws IOException
		{
			FileInputStream fis = new FileInputStream("TestData\\TestData.xlsx");
			Wbook  = new XSSFWorkbook(fis);
			
		}
// To Load Sheet	
public static void getworksheet()
		{
	  
			sheetobj = Wbook.getSheet("TestData");
		}

//To Get Row Count
public static int getrowcount()
		{
			int rowcnt = sheetobj.getPhysicalNumberOfRows(); //Fetch count of filled rows data.
			return rowcnt;
		}
	
//To Get Column Count
public static int columncnt()
		{
			Row rowobj = sheetobj.getRow(0);
			int columncnt = rowobj.getPhysicalNumberOfCells(); //Fetch count of filled cells data.
			return columncnt;
		}
	
// To find the row number with the desired TCID
public static int getdesirerownum(String TCID) throws IOException //This method will identified the desired row in which test data is holding
		{
			int desirerow = 0; //
			getWorkBookIbj();  //To activate workbook
			getworksheet();   //To activate worksheet
			int rowcnt = getrowcount();  //Return Row count
			int colcnt = columncnt();   //Return Column count
			for(int i=1;i<=rowcnt;i++)  //This loop will work till total row count.
			{
				for(int j=1;j<=colcnt;j++) //This loop work till total column count.
				{
					Row rowobj = sheetobj.getRow(i);
					Cell cellobj = rowobj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK); // CREATE_NULL_AS_BLANK Will skip the blank row
					String dalaval = cellobj.getStringCellValue();  //Return the Cell data in string format.
					if(dalaval.equalsIgnoreCase(TCID)) //Will identified the row data as per passed test case id.
					{
						desirerow=i; //Return the Row data.
					}
				}
				if(desirerow !=0)
				{
					break;
				}
				
			}
			return desirerow;
		}
		
	
//To get actual scenario data
 public static void GetactualScenarioData(String TCID) throws IOException //
      {
	TDMap =new HashMap<String, String>(); // To store the data in key-value form
	int rownumber = getdesirerownum(TCID); // It will return the row data in which having the test data.
	int colcnt = columncnt();
	
	for(int j=4;j<=colcnt;j++)  //Loop will start from the colum 4 in which test data exists till column count.
	{
		
		Row rowobj = sheetobj.getRow(rownumber); //To get the Row data & will return on row object variable.
		Cell cellobj = rowobj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);  // To reach the particular Cell.
		String KeyName =cellobj.getStringCellValue();  // To fetch the Cell data in key name variable.
		Cell cellobj1 = rowobj.getCell(j+1, MissingCellPolicy.CREATE_NULL_AS_BLANK); // To reach the particular Cell.
			
		String KeyValue;
		if(cellobj1.getCellType() == CellType.NUMERIC) // If any cell having the numeric value then it will convert in string format
		{
		    KeyValue = NumberToTextConverter.toText(cellobj1.getNumericCellValue()); // If any cell having the numeric value then it will convert in string format
		 
		}
		else
		{
			KeyValue = cellobj1.getStringCellValue(); // To fetch the Cell data in key value variable.
		
		}
		TDMap.put(KeyName, KeyValue);
		j=j+1; // will add +1 in J to fetch the next value data, because dats is stored in Key value form.
	}
}

}
