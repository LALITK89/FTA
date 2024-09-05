package com.selenium.fta.TestData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.fta.utility_class.Utilityclass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TestDataOutput 
{
	public static void UpdateTestDateInExcel(String TestCaseID, String Message, String Status, String FBN) 
	
	 {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        Workbook workbook = null;

        try 
        {
            // Open the existing Excel file
        	Utilityclass.configfile();
            fis = new FileInputStream(Utilityclass.propobj.getProperty("TestData.Outputfile"));
            workbook = new XSSFWorkbook(fis);

            // Access the desired sheet (by name or index)
            Sheet sheet = workbook.getSheet(Utilityclass.propobj.getProperty("OutputTestData.SheetName"));
            if (sheet == null) 
            {
                sheet = workbook.createSheet("LatestTestOutput");
            }

            // Find the last row and create new rows
            int lastRowNum = sheet.getLastRowNum();
            int newRowNum = lastRowNum + 1;

            // Add new data
            Object[][] newData = {{TestCaseID, Message, Status, FBN}};

            for (Object[] rowData : newData) 
            {
                Row row = sheet.createRow(newRowNum++);
                int colNum = 0;
                for (Object field : rowData) 
                {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) 
                    {
                        cell.setCellValue((String) field);
                    } 
                    else if (field instanceof Integer) 
                    {
                        cell.setCellValue((Integer) field);
                    }
                }
            }

            // Write the changes to the file
            fos = new FileOutputStream(Utilityclass.propobj.getProperty("TestData.Outputfile"));
            workbook.write(fos);

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            // Close resources
            try {
                if (workbook != null) workbook.close();
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) 
    {
        UpdateTestDateInExcel("TC002", "Verification success messages", "Passed", "104327369934");
    }
}
