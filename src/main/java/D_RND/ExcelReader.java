package D_RND;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class ExcelReader 
{
	// Method to read group name from an Excel file
    public static String readGroupNameFromExcel(String excelFilePath) throws IOException 
    {
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fis);  // For .xlsx files
        Sheet sheet = workbook.getSheetAt(0);  // Read the first sheet (you can change the index if needed)
        Row row = sheet.getRow(1);  // Read the first row (adjust row index if needed)
        Cell cell = row.getCell(0);  // Read the first column (adjust column index if needed)
        
        String groupName = null;
        if (cell != null) 
        {
            groupName = cell.getStringCellValue();  // Get the group name as a string
        }

        workbook.close();
        fis.close();
        return groupName;
    }

    public static void main(String[] args) 
    {
        try 
        {
            String groupName = readGroupNameFromExcel("E:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\groups.xlsx");
            System.out.println("Group Name from Excel: " + groupName);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    }
