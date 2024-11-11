package Excel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class ExcelReader 
{
	public List<String> readGroupNames(String filePath) throws FileNotFoundException, IOException
	{
        List<String> groupNames = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis))
        {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet)
            {
                if (row.getRowNum() != 0)
                {
                	// Skip header
                    Cell cell = row.getCell(0);
                    groupNames.add(cell.getStringCellValue());
                }
            }
        }
        return groupNames;
    }
}
