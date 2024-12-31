package D_RND;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelScriptExecutor 
{
	public static void main(String[] args) {
        // Specify the file path of the Excel file
        String excelFilePath = "E:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\groups.xlsx";
        
        // The row and column you want to check
        int rowIndex = 1; // Row index (starting from 0)
        int colIndex = 0; // Column index (starting from 0)

        try {
            // Create a FileInputStream to read the Excel file
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            
            // Create an instance of XSSFWorkbook (use HSSFWorkbook for .xls files)
            Workbook workbook = new XSSFWorkbook(fis);
            
            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            
            // Get the row at the specified index
            Row row = sheet.getRow(rowIndex);
            
            if (row != null) {
                // Get the cell at the specified column index
                Cell cell = row.getCell(colIndex);
                
                if (cell != null) {
                    // Check the value of the cell
                    String cellValue = cell.getStringCellValue().trim();
                    
                    // If the value is "Yes", execute the script
                    if ("Sanity".equalsIgnoreCase(cellValue)) {
                        executeScript();
                    } else {
                        System.out.println("The value is not 'Yes'. No script will be executed.");
                    }
                }
            }
            
            // Close the workbook and input stream
            workbook.close();
            fis.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Method to execute when the value in Excel is "Yes"
    public static void executeScript() {
        //System.out.println("Executing script because the value is 'Sanity'.");
        // Your script logic goes here, e.g., calling external scripts, methods, etc.
        try 
    	{
            
        	//String scriptPath = "E:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\FTA_Project\\src\\main\\java\\A_CommonUtilityclasses\\Launch_Browser.java";  // Or .bat file on Windows
        	
        	ProcessBuilder processBuilder = new ProcessBuilder("java", "D_RND.Hello");
        
            //ProcessBuilder processBuilder = new ProcessBuilder(scriptPath);
            processBuilder.start();
        } 
    	catch (IOException e) 
    	{
            e.printStackTrace();
        }
    }
    	
    }
