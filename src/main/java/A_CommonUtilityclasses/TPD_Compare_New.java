package A_CommonUtilityclasses;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class TPD_Compare_New 
{
	

	public static void main(String[] args) 
	{
		
		        String pdf1Path = "D:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\Corporate Tax Registration Certificate.pdf";
		        String pdf2Path = "D:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\Corporate Tax Registration Certificate.pdf";

		        try {
		            String text1 = extractTextFromPDF(pdf1Path);
		            String text2 = extractTextFromPDF(pdf2Path);

		            // Remove dynamic values from both PDFs
		            text1 = removeDynamicValues(text1);
		            text2 = removeDynamicValues(text2);

		            // Compare the cleaned text
		            boolean areEqual = compareText(text1, text2);

		            if (areEqual) {
		                System.out.println("The PDFs are identical.");
		            } else {
		                System.out.println("The PDFs are different.");
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    // Method to extract text from a PDF file
		    public static String extractTextFromPDF(String filePath) throws IOException {
		        PDDocument document = PDDocument.load(new File(filePath));
		        PDFTextStripper stripper = new PDFTextStripper();
		        String text = stripper.getText(document);
		        document.close();
		        return text;
		    }

		    // Method to remove dynamic values from the extracted text
		    public static String removeDynamicValues(String text) {
		        // Example: Remove dates (e.g., "2024-11-28" or "MM/DD/YYYY")
		        text = text.replaceAll("\\d{4}-\\d{2}-\\d{2}", "DYNAMIC_DATE");

		        // Example: Remove time (e.g., "12:45 PM" or "HH:mm AM/PM")
		        text = text.replaceAll("\\d{1,2}:\\d{2} (AM|PM)", "DYNAMIC_TIME");

		        // Example: Remove numbers (e.g., product IDs, phone numbers, etc.)
		        text = text.replaceAll("\\d+", "DYNAMIC_NUMBER");

		        // Example: Remove email addresses
		        text = text.replaceAll("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", "DYNAMIC_EMAIL");

		        // Example: Remove random generated IDs
		        text = text.replaceAll("\\b[a-fA-F0-9]{32}\\b", "DYNAMIC_ID");  // Example for a 32-character hex ID

		        // You can add more regex patterns based on the types of dynamic content in your PDF

		        return text;
		    }

		    // Method to compare the extracted text
		    public static boolean compareText(String text1, String text2) {
		        // Normalize the texts by removing extra spaces and converting to lowercase
		        text1 = text1.replaceAll("\\s+", " ").toLowerCase().trim();
		        text2 = text2.replaceAll("\\s+", " ").toLowerCase().trim();

		        return text1.equals(text2);
		    }
		}


