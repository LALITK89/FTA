package Excel;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestNGXmlGenerator 
{
	public static void generateTestNGXml(List<String> groupNames) throws IOException
	{
        XmlSuite suite = new XmlSuite();
        suite.setName("Suite");
        
 
        for (String groupName : groupNames)
        {
            XmlTest test = new XmlTest(suite);
            test.setName("Test");
            test.setIncludedGroups(List.of(groupName)); // Include the specific group
           
//            List<XmlClass> testClasses = new ArrayList<>();
//            testClasses.add(new XmlClass("TestRunnerClasses.TestNG"));
//            test.setXmlClasses(testClasses);
        }
 
        // Write the XML to a file
        try (FileWriter writer = new FileWriter("testng.xml"))
        {
            writer.write(suite.toXml());
        }
    }
    
    public static void main(String[] args) throws IOException
    {
      // Read groups from Excel
    String excelPath = "TestData\\Commands.xlsx";
    ExcelReader excelReader = new ExcelReader();
    List<String> groupNames = excelReader.readGroupNames(excelPath);

    // Generate testng.xml
    TestNGXmlGenerator.generateTestNGXml(groupNames);
    
	// Run TestNG with the generated XML
    TestNG testng = new TestNG();
    testng.setXmlSuites(List.of(new XmlSuite())); // Use the generated XML suite
    testng.run();  
 
        
    }
}
