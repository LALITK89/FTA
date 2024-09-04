package com.selenium.fta.WordDocument;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateWordDocument 
{
   
public static String documentPath = null;
public static String documentCreation(String TCID) throws IOException
{
	// Create a Word document
	 try (XWPFDocument document = new XWPFDocument()) 
	    {
	
	// Save the document
        String DocumentFolder = "D:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\TPD\\";
        documentPath = DocumentFolder+TCID+".docx";
	    FileOutputStream fos = new FileOutputStream(documentPath);
	    document.write(fos);
	    fos.close();
	    }
	    catch (Exception e) 
        {
        e.printStackTrace();
         }
	 return documentPath;
   }

 public static String CaptureScreenshotAndDescrptionInsertIntoWordDocument(String ScreenshotDescription) throws IOException, HeadlessException, AWTException, InvalidFormatException
    {
    	// Path to the Word document
           String DocumentPath = documentPath;
        //String DocumentPath = "D:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\TPD\\TC001.docx";
        // Load the existing Word document
        FileInputStream fis = new FileInputStream(DocumentPath);
        XWPFDocument doc = new XWPFDocument(fis);

        // Add a description
        XWPFParagraph descriptionParagraph = doc.createParagraph();
        XWPFRun descriptionRun = descriptionParagraph.createRun();
        descriptionRun.setText(ScreenshotDescription);

        // Create a BufferedImage of the screen
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        // Convert BufferedImage to ByteArrayInputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

        // Add the image to the document
        XWPFParagraph imageParagraph = doc.createParagraph();
        XWPFRun imageRun = imageParagraph.createRun();
        imageRun.addPicture(bais, Document.PICTURE_TYPE_PNG, "screenshot.png", Units.toEMU(500), Units.toEMU(300));

        // Save the changes to the document
        try (FileOutputStream fos = new FileOutputStream(DocumentPath)) 
        {
            doc.write(fos);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } finally {
            fis.close();
            baos.close();
            bais.close();
        }

        return DocumentPath;
    }

 public static void printResult(String Result) throws IOException
 {
	// Path to the Word document
       String DocumentPath = documentPath;
     //String DocumentPath = "D:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\TPD\\TC001.docx";
     
	// Load the existing Word document
     FileInputStream fis = new FileInputStream(DocumentPath);
     XWPFDocument doc = new XWPFDocument(fis);
     
	// Add the Result
     XWPFParagraph descriptionParagraph = doc.createParagraph();
     XWPFRun descriptionRun = descriptionParagraph.createRun();
     descriptionRun.setText(Result);
     
     // Save the changes to the document
      	 try (FileOutputStream fos = new FileOutputStream(DocumentPath)) 
    	 {
             doc.write(fos);
     }
 }
     public static void main(String [] args) throws Exception
    {
  	documentCreation("TC001");
    CaptureScreenshotAndDescrptionInsertIntoWordDocument("Description is here");
    printResult("Execution Status: Passed");
    
    }
}
